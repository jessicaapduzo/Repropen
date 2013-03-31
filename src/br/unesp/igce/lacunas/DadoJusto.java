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
 * Gerador de valores aleatorios com chances iguais
 * 
 * @author orlando
 */
public class DadoJusto extends DadoDaSorte {
    private Random g = new Random();
    private int lados;
    
    public DadoJusto(int lados){
        this.lados = lados;
    }
    
    @Override
    public int lancar() {
        return g.nextInt(lados);
    }
    
    public int[] lancarVariasVezesSemRepetir(int vezes) {
        int lance = lancar();
        ArrayList<Integer> lances = new ArrayList<Integer> ();
        lances.add(lance);
        for (int i = 0; i < vezes - 1; i++) {
            while(lances.contains(new Integer(lance)))
                lance = lancar();
            lances.add(lance);
        }
        return extrairArray(lances);
    }
    
    public static void main(String[] args) {
        DadoJusto dado = new DadoJusto(6);
        int[] a = dado.lancarVariasVezesSemRepetir(3);
        for (int i = 0; i < 3; i++) {
            System.out.println(a[i]);
        }
    }

}
