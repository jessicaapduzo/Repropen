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
 *
 * @author orlando
 */
public class ParteSorteada implements ParteDeExpressao {
    private String[] roleta;
    
    public ParteSorteada(String[] valores) {
        roleta = valores;
    }
    
    @Override
    public String get(){
        Random g = new Random();
        int sorteio = g.nextInt(roleta.length);
        return roleta[sorteio];
    }

}
