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
 * Gerador de valores para criacao aleatoria de objetos e povoamento da base
 * de dados
 * 
 * @author orlando
 */
public class GeradorDeNome {
    
    static private String[] prenomesMasc = {
      "Apolinario",
      "Ariosto",
      "Asbrubal",
      "Astolfo",
      "Astromar",
      "Austregesilo",
      "Dionisio",
      "Edipino",
      "Genival",
      "Gilberto",
      "Lindomar",
      "Nicolau",
      "Quirino",
      "Rui",
      "Sebastiao",
      "Sergio",
      "Vantui",
      "Venceslau",
      "Vespasiano",
      "Wilson"
    };
    
    static private String[] prenomesFem = {
        "Antonieta",
        "Camila",
        "Carla",
        "Cristiane",
        "Dulce",
        "Gerolina",
        "Gerusa",
        "Guilhermina",
        "Hermengada",
        "Itala",
        "Jocasta",
        "Livia",
        "Luisa",
        "Margarida",
        "Felicia",
        "Magnolia",
        "Marluce",
        "Medeia",
        "Milene",
        "Patricia",
        "Silvia"
    };
    
    static private String[] sobrenomes = {
        "Albuquerque",
        "Alcantara",
        "Araujo",
        "Bonifacio",
        "Calisto",
        "Carneiro",
        "Cavalcante",
        "Duarte",
        "Dutra",
        "Figueira",
        "Gomes",
        "Leoncio",
        "Limeira",
        "Malta",
        "Mikioto",
        "Monticelli",
        "Nobre",
        "Peixoto",
        "Pinho",
        "Viotti",
        "Silva",
        "Souza",
        "Tamoio",
        "Tanamura",
        "Tenorio"
    };
    
    static private String sobrenome() {
        
        ExpressaoGeradora fulano = new ExpressaoGeradora(15);
        fulano.colar(new ParteSorteada(sobrenomes));
        
        ExpressaoGeradora deFulanoTal = new ExpressaoGeradora(20);
        deFulanoTal.colar(new ParteFixa("de "));
        deFulanoTal.colar(new ParteSorteada(sobrenomes));
        deFulanoTal.colar(new ParteFixa(" "));
        deFulanoTal.colar(new ParteSorteada(sobrenomes));
        
        ExpressaoGeradora fulanoDeTal = new ExpressaoGeradora(20);
        fulanoDeTal.colar(new ParteSorteada(sobrenomes));
        fulanoDeTal.colar(new ParteFixa(" de "));
        fulanoDeTal.colar(new ParteSorteada(sobrenomes));
        
        ExpressaoGeradora fulanoTal = new ExpressaoGeradora(45);
        fulanoTal.colar(new ParteSorteada(sobrenomes));
        fulanoTal.colar(new ParteFixa(" "));
        fulanoTal.colar(new ParteSorteada(sobrenomes));
        
        ExpressaoGeradora[] opts = {fulano, deFulanoTal, fulanoDeTal, fulanoTal};
        Gerador g = new Gerador(opts);
        
        return g.prox();

    }
    
    static public String proxMasc() {
        
        ExpressaoGeradora joaoAlguem = new ExpressaoGeradora(5);
        joaoAlguem.colar(new ParteFixa("Joao "));
        joaoAlguem.colar(new ParteSorteada(prenomesMasc));
        joaoAlguem.colar(new ParteFixa(" " + sobrenome()));
        
        ExpressaoGeradora zeAlguem = new ExpressaoGeradora(5);
        zeAlguem.colar(new ParteFixa("Jose "));
        zeAlguem.colar(new ParteSorteada(prenomesMasc));
        zeAlguem.colar(new ParteFixa(" " + sobrenome()));

        ExpressaoGeradora alguem = new ExpressaoGeradora(90);
        alguem.colar(new ParteSorteada(prenomesMasc));
        alguem.colar(new ParteFixa(" " + sobrenome()));
        
        ExpressaoGeradora[] opts = {joaoAlguem, zeAlguem, alguem};
        Gerador g1 = new Gerador(opts);
        
        ExpressaoGeradora maneFilho = new ExpressaoGeradora(4);
        maneFilho.colar(new ParteFixa(" Filho"));
        
        ExpressaoGeradora maneJunior = new ExpressaoGeradora(4);
        maneJunior.colar(new ParteFixa(" Junior"));
        
        ExpressaoGeradora maneNeto = new ExpressaoGeradora(7);
        maneNeto.colar(new ParteFixa(" Neto"));
        
        ExpressaoGeradora mane = new ExpressaoGeradora(85);
        mane.colar(new ParteFixa(""));
        
        ExpressaoGeradora[] opts2 = {maneFilho, maneJunior, maneNeto, mane};
        Gerador g2 = new Gerador(opts2);
        
        return g1.prox() + g2.prox();
    }
    
    static public String proxFem() {
        
        ExpressaoGeradora anaAlguem = new ExpressaoGeradora(5);
        anaAlguem.colar(new ParteFixa("Ana "));
        anaAlguem.colar(new ParteSorteada(prenomesFem));
        anaAlguem.colar(new ParteFixa(" " + sobrenome()));
        
        ExpressaoGeradora mariaAlguem = new ExpressaoGeradora(5);
        mariaAlguem.colar(new ParteFixa("Maria "));
        mariaAlguem.colar(new ParteSorteada(prenomesFem));
        mariaAlguem.colar(new ParteFixa(" " + sobrenome()));

        ExpressaoGeradora alguem = new ExpressaoGeradora(90);
        alguem.colar(new ParteSorteada(prenomesFem));
        alguem.colar(new ParteFixa(" " + sobrenome()));
        
        ExpressaoGeradora[] opts = {anaAlguem, mariaAlguem, alguem};
        Gerador g = new Gerador(opts);
        return g.prox();
    }
    
    static public String prox() {
        Random g = new Random();
        if (g.nextBoolean()) {
            return proxFem();
        } else {
            return proxMasc();
        }
    }
        
}
