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
public class GeradorDeTexto {
    
    private static String[] frases = {
        "Lorem ipsum dolor sit amet, consectetur adipisicing elit, "
            + "sed do eiusmod tempor incididunt ut labore et dolore "
            + "magna aliqua.",
        "Ut enim ad minim veniam, quis nostrud exercitation ullamco "
            + "laboris nisi ut aliquip ex ea commodo consequat.",
        "Duis aute irure dolor in reprehenderit in voluptate velit "
            + "esse cillum dolore eu fugiat nulla pariatur.",
        "Excepteur sint occaecat cupidatat non proident, sunt in culpa "
            + "qui officia deserunt mollit anim id est laborum.",
        "Glou glou glou glou gloy glu gliu glii glii glio.",
        "Tupe tupe tupe tupi tupu tupa tepe tepe tem glem ga.",
        "Tranu trini trino tren terere tem dudu dada tapara tam.",
        "Vontonoi caractamparam duno treno taktananakar zem tem.",
        "Divorgenes tom divogenes, caramacaras tantaram zulu data.",
        "Cormicoides som velotes, tunukuram adjanas boroloreim."
    };
    
    public static String proxFrase() {
        DadoJusto f = new DadoJusto(frases.length);
        return frases[f.lancar()];
    }
    
    public static String proxParagrafo () {
        DadoJusto f = new DadoJusto(frases.length);
        DadoJusto q = new DadoJusto(3);
        int i = 3 + q.lancar();
        int[] fr = f.lancarVariasVezesSemRepetir(i);
        String res = "";
        for (int j = 0; j < fr.length; j++) {
            res = res + frases[fr[j]];
            res = res + " ";
        }
        return res.substring(0, res.length() - 1);
    }
    
    public static String proxDoisParagrafos () {
        return proxParagrafo() + "\n" + proxParagrafo();
    }

    public static String proxTresParagrafos () {
        return proxDoisParagrafos() + "\n" + proxParagrafo();
    }

    public static void main(String[] args) {
        System.out.println(proxTresParagrafos());
    }
}
