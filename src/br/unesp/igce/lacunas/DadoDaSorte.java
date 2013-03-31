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

/**
 * 
 * 
 * @author orlando
 */
public abstract class DadoDaSorte {
    
    public abstract int lancar();
    
    protected static int[] extrairArray(ArrayList<Integer> al) {
        Object[] ar = al.toArray();
        int[] res = new int[ar.length];
        for (int i = 0; i < ar.length; i++) {
            res[i] = ((Integer) ar[i]).intValue();
        }
        return res;
    }
    
    /**
     * Lanca um dado varias vezes
     * O numero de vezes tem que ser menor ou igual ao numero de lados.
     * @param vezes
     * @return 
     */
    public int[] lancarVariasVezes(int vezes) {
        int lance = lancar();
        ArrayList<Integer> lances = new ArrayList<Integer> ();
        lances.add(lance);
        for (int i = 0; i < vezes - 1; i++) {
            lance = lancar();
            lances.add(lance);
        }
        return extrairArray(lances);
    }
}
