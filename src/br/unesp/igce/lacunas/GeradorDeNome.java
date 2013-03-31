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
        "Viotti",
        "Silva",
        "Souza",
        "Tamoio",
        "Tanamura",
        "Tenorio"
    };
    
    static private String sobrenome() {
        DadoJusto d = new DadoJusto(sobrenomes.length);
        int[] sobrs = d.lancarVariasVezesSemRepetir(2);
        int[] pesos = {15,20,20,45};
        DadoViciado dd = new DadoViciado(pesos);
        int sorteio = dd.lancar();
        if (sorteio == 0) {
            return sobrenomes[sobrs[0]];
        } else if (sorteio == 1){
            return "de " + sobrenomes[sobrs[0]] + " " + sobrenomes[sobrs[1]];
        } else if (sorteio == 2) {
            return sobrenomes[sobrs[0]] + " de " + sobrenomes[sobrs[1]];
        } else {
            return sobrenomes[sobrs[0]] + " " + sobrenomes[sobrs[1]];
        }
    }
    
    static public String proxMasc() {
        DadoJusto d = new DadoJusto(prenomesMasc.length);
        int nm = d.lancar();
        int[] pesos = {5,5,90};
        DadoViciado dd = new DadoViciado(pesos);
        int sorteio = dd.lancar();
        String resTemp;
        if (sorteio == 0) {
           resTemp = "Jose " + prenomesMasc[nm] + " " + sobrenome();
        } else if (sorteio == 1){
           resTemp = "Joao " + prenomesMasc[nm] + " " + sobrenome();
        } else {
           resTemp = prenomesMasc[nm] + " " + sobrenome();
        }
        int[] pesos2 = {4,4,7,85};
        dd = new DadoViciado(pesos2);
        sorteio = dd.lancar();
        if (sorteio == 0) {
            return resTemp + " Filho";
        } else if (sorteio == 1) {
            return resTemp + " Junior";
        } else if (sorteio == 2) {
            return resTemp + " Neto";
        } else {
            return resTemp;
        }   
    }
    
    static public String proxFem() {
        DadoJusto d = new DadoJusto(prenomesFem.length);
        int nm = d.lancar();
        int[] pesos = {5,5,90};
        DadoViciado dd = new DadoViciado(pesos);
        int sorteio = dd.lancar();
        if (sorteio == 0) {
           return "Ana " + prenomesFem[nm] + " " + sobrenome();
        } else if (sorteio == 1){
           return "Maria " + prenomesFem[nm] + " " + sobrenome();
        } else {
           return prenomesFem[nm] + " " + sobrenome();
        }
    }
    
    static public String prox() {
        DadoJusto d = new DadoJusto(2);
        int srt = d.lancar();
        if (srt == 0) {
            return proxFem();
        } else {
            return proxMasc();
        }
    }
        
}
