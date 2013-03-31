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

/**
 *
 * @author orlando
 */
public class GeradorDeLivroTecnico {
    
    private static String[] prefixos = {
        "Manual de ",
        "Elementos de ",
        "Introdução a ",
        "Cadernos de "
    };
    
    private static String[] sufixos = {
        " Passo a Passo",
        " em 24 horas"
    };
    
    static public String prox() {
        DadoJusto p = new DadoJusto(prefixos.length);
        DadoJusto s = new DadoJusto(sufixos.length);
        int[] pesos = {5,3,1};
        DadoViciado d = new DadoViciado(pesos);
        int sorteio = d.lancar();
        if (sorteio == 0) {
            return prefixos[p.lancar()] + GeradorDeAreaDeConhecimento.prox();
        } else if (sorteio == 1){
            return GeradorDeAreaDeConhecimento.prox();
        } else {
            return GeradorDeAreaDeConhecimento.prox() + sufixos[s.lancar()];
        }        
    }
    
    
}
