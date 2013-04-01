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
 * gera texto em uma lingua ficticia.
 * 
 * as palavras sao inventadas.
 * 
 * permite gerar uma frase, um paragrafo com numero aleatorio de frases,
 * dois ou tres paragrafos da mesma forma.
 * 
 * @author orlando
 */
public class GeradorDeTexto {
    
    private static String[] frases = {
        "Raspatic donovis tendendoi uriatam, balaburte samuabo. ",
        "Xisvipique taque lene lodovocum perculare, troivante tate. ",
        "Doscopurum virtuane, xapacante vequetrigue, uluarau barbante. ",
        "Rostro povich, violante, cello dulce, dulce cello, cai ramevo. ",
        "Vontonoi caractamparam duno treno taktananakar zem tem.",
        "Divorgenes tom divogenes, caramacaras tantaram zulu data.",
        "Cormicoides som velotes, tunukuram adjanas boroloreim.",
        "Dorbi ante, mula prakti, olerante sandalos olentes, gor dal. ",
        "Zizibue ratanique olereu devagar zeu, mar tinho davi la.",
        "Ulti dor lacio, bilacquidas par nas nismok do spok. ",
        "Trenk trankou. " ,
        "Du di vindas. ",
        "Entonio vader, sky muolqui, chorche lutas isperdeu. ",
        "More nomore, diave rum, dia tia tuntamon, arriribes divison. "
    };
    
    public static String proxFrase() {
        DadoDaSorte f = new DadoDaSorte(frases.length);
        return frases[f.lancar()];
    }
    
    /**
     * @return numero aleatorio de frases.
     */
    public static String proxParagrafo () {
        DadoDaSorte f = new DadoDaSorte(frases.length);
        DadoDaSorte q = new DadoDaSorte(3);
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
    
}
