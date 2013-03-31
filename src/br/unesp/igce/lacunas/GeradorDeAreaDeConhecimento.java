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
public class GeradorDeAreaDeConhecimento {
    
    static private String[] prefixos = {
       "Astro",
       "Meta",
       "Metalo",
       "Neo",
       "Proto"
    };

    static private String[] radicais = {
       "culinari",
       "economi",
       "fisic",
       "quimic",
    };
    
    static private String[] sufixos = {
        "ologia",
        "ogenese",
        "onetica"
    };
    
    static private String[] adjetivos = {
        " Pura",
        " Pratica",
        " Neanderthal",
        " Linear",
        " Nuclear",
        " Relativista"
    };
            
    static public String prox() {
        DadoJusto p = new DadoJusto(prefixos.length);
        DadoJusto r = new DadoJusto(radicais.length);
        DadoJusto s = new DadoJusto(sufixos.length);
        DadoJusto a = new DadoJusto(adjetivos.length);
        int[] pesos = {5,2,6};
        DadoViciado d = new DadoViciado(pesos);
        int sorteio = d.lancar();
        String resTemp;
        if (sorteio == 0) {
            resTemp = prefixos[p.lancar()] + radicais[r.lancar()] + "a";
        } else if (sorteio == 1){
            resTemp = radicais[r.lancar()] + "a";
            resTemp = resTemp.substring(0, 1).toUpperCase() + 
                    resTemp.substring(1, resTemp.length());
        } else {
            resTemp = radicais[r.lancar()] + sufixos[s.lancar()];
            resTemp = resTemp.substring(0, 1).toUpperCase() + 
                    resTemp.substring(1, resTemp.length());
        }
        int[] pesos2 = {2,3};
        d = new DadoViciado(pesos2);
        sorteio = d.lancar();
        if (sorteio == 0) {
            return resTemp;
        } else {
            return resTemp + adjetivos[a.lancar()];
        }
        
    }
    

}
