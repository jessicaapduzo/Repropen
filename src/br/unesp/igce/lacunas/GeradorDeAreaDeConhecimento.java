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
    
    static public String prox () {
        
        ExpressaoGeradora exp0 = new ExpressaoGeradora(5);
        exp0.colar(new ParteSorteada(prefixos));
        exp0.colar(new ParteSorteada(radicais));
        exp0.colar(new ParteFixa("a"));
              
        ExpressaoGeradora exp1 = new ExpressaoGeradora(2);
        exp1.colar(new ParteSorteada(radicais));
        exp1.colar(new ParteFixa("a"));
        
        ExpressaoGeradora exp2 = new ExpressaoGeradora(6);
        exp2.colar(new ParteSorteada(radicais));
        exp2.colar(new ParteSorteada(sufixos));
        
        ExpressaoGeradora[] p1 = {exp0, exp1, exp2};
        Gerador g1 = new Gerador(p1);
        String parte1 = g1.prox();
        parte1 = parte1.substring(0, 1).toUpperCase() + 
                parte1.substring(1, parte1.length());
        
        ExpressaoGeradora exp3 = new ExpressaoGeradora(2);
        exp3.colar(new ParteFixa(""));
        
        ExpressaoGeradora exp4 = new ExpressaoGeradora(3);
        exp4.colar(new ParteSorteada(adjetivos));
        
        ExpressaoGeradora[] p2 = {exp3, exp4};
        Gerador g2 = new Gerador(p2);
        
        return parte1 + g2.prox();
    }
    
}
