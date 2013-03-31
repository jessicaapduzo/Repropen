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
 * @author orlando
 */
public class ExpressaoGeradora {

    public int peso;
    private ArrayList<ParteDeExpressao> partes = new ArrayList<ParteDeExpressao>();
    
    public ExpressaoGeradora(int peso){
        this.peso = peso;
    }
    
    public void colar(ParteDeExpressao parte) {
        partes.add(parte);       
    }
    
    public ParteDeExpressao[] toArray() {
        Object[] ar = partes.toArray();
        ParteDeExpressao[] res = new ParteDeExpressao[ar.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = (ParteDeExpressao) ar[i];
        }
        return res;
    }
}
