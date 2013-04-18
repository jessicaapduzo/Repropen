/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lacunas;

import br.unesp.igce.lacunas.ExpressaoGeradora;
import br.unesp.igce.lacunas.Gerador;
import br.unesp.igce.lacunas.ParteSorteada;

/**
 *Gera o item da compra
 * 
 * Duas partes: produto e marca
 * 
 * @author jessica
 */
public class GeradorDeXYZ {
       private static String[] produto = {
        "Oleo ",
        "Detergente ",
        "Papel Higienico ",
        "Papel Toalha ",
        "Esponja ",
    };
    
    private static String[] marca = {
        "Ypê",
        "Yuri",
        "Assolan",
        "Bom Bril",
        "Fofinho",
        "Liza"
    };
     public static String prox() {
        
        ExpressaoGeradora exp = new ExpressaoGeradora(1);
        exp.colar(new ParteSorteada(produto));
        exp.colar(new ParteSorteada(marca));
        
        ExpressaoGeradora[] ops = {exp};
        Gerador g = new Gerador(ops);
        
        return g.prox();
    }
    
}
    
