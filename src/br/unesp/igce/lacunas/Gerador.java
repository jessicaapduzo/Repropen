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

import java.util.Random;

/**
 *
 * @author orlando
 */
public class Gerador {
    private ExpressaoGeradora[] cartucho;
    private int[] distribuicao;
    private Random g = new Random();

    
    public Gerador(ExpressaoGeradora[] cartucho){
        this.cartucho = cartucho;
        
        distribuicao = new int[cartucho.length - 1];
        int total = 0;
        for (int i = 0; i < cartucho.length; i++) 
            if (cartucho[i].peso > 0)
                total += cartucho[i].peso;
        if (total == 0)
            System.err.println("Pesos devem ser positivos");
        else {
            int acumula = 0;
            for (int i = 0; i < cartucho.length - 1 ; i++) {
                acumula += cartucho[i].peso*100/total;
                distribuicao[i] = acumula;
            }
        }

    }
    
    public String prox() {
        int sorteio = g.nextInt(100);
        int iCaso;
        for (iCaso = 0; iCaso < distribuicao.length; iCaso++)
            if (sorteio < distribuicao[iCaso]) 
                break;
        ExpressaoGeradora caso = cartucho[iCaso];
        
        String mtg = "";
        ParteDeExpressao[] partes = caso.toArray();
        for (int i = 0; i < partes.length; i++) {
            mtg = mtg + partes[i].get();
        }
        return mtg;
    }
}
