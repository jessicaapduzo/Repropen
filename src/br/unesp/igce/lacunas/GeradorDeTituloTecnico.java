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
 * gera titulo de livro tecnico.
 * 
 * baseia-se no gerador de area de conhecimento.
 * 
 * gera tres opcoes de string: com prefixo ("Manual de ", etc.), simples ou
 * com sufixo (" Passo a Passo", etc.).
 * 
 * @author orlando
 */
public class GeradorDeTituloTecnico {
    
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
    
    /**
     * @return tres opcoes de expressao: c/ pref, simples, c/ suf
     */
    static public String prox() {

        ExpressaoGeradora exp0 = new ExpressaoGeradora(5);
        exp0.colar(new ParteSorteada(prefixos));
        exp0.colar(new ParteFixa(GeradorDeAreaDeConhecimento.prox()));
        
        ExpressaoGeradora exp1 = new ExpressaoGeradora(3);
        exp1.colar(new ParteFixa(GeradorDeAreaDeConhecimento.prox()));
        
        ExpressaoGeradora exp2 = new ExpressaoGeradora(1);
        exp2.colar(new ParteFixa(GeradorDeAreaDeConhecimento.prox()));
        exp2.colar(new ParteSorteada(sufixos));
        
        ExpressaoGeradora[] opts = {exp0, exp1, exp2};
        Gerador g = new Gerador(opts);
        
        return g.prox();
    }
    
}
