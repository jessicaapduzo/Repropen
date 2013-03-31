/* Copyright 2013 Universidade Estadual Paulista
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package br.unesp.igce.lacunas;

import java.util.ArrayList;
import java.util.Random;

/**
 * Dado que realiza sorteio com base em distribuicao estatistica
 * @author orlando
 */
public class DadoViciado extends DadoDaSorte {
    private Random g = new Random();
    private int[] distribuicao;
    
    public DadoViciado (int[] pesos){
        distribuicao = new int[pesos.length - 1];
        int total = 0;
        for (int i = 0; i < pesos.length; i++) 
            if (pesos[i] > 0)
                total += pesos[i];
        if (total == 0)
            System.err.println("Pesos devem ser positivos");
        else {
            int acumula = 0;
            for (int i = 0; i < pesos.length - 1 ; i++) {
                acumula += pesos[i]*100/total;
                distribuicao[i] = acumula;
            }
        }
    }
    
    /**
     * Sorteia um valor de acordo com a distribuicao dos pesos
     * @return
     */
    @Override
   public int lancar() {
        int sorteio = g.nextInt(100);
        int lado;
        for (lado = 0; lado < distribuicao.length; lado++)
            if (sorteio < distribuicao[lado]) 
                break;
        return lado;
    }
    
     public static void main(String[] args) {
        int[] pesos = {1,2,2,5};
        DadoViciado dado = new DadoViciado(pesos);
        int[] a = dado.lancarVariasVezes(7);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }


}
