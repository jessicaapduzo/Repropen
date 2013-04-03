package br.unesp.igce.lacunas.testes;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import br.unesp.igce.lacunas.ExpressaoGeradora;
import br.unesp.igce.lacunas.Gerador;
import br.unesp.igce.lacunas.ParteDeExpressao;
import br.unesp.igce.lacunas.ParteFixa;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author orlando
 */
public class TesteDeParteFixa {
    
    public TesteDeParteFixa() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void testarGeracaoSimples() {
        String fixa = "Em teste ";
        ParteFixa parte = new ParteFixa(fixa);
        ExpressaoGeradora exp = new ExpressaoGeradora(1);
        exp.colar(parte);
        ExpressaoGeradora[] exps = {exp};
        Gerador g = new Gerador(exps);
        String resultado = g.prox();
        assertEquals(fixa, resultado);
    }
}