/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piscifactoria;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Fernando
 */
public class nivelTest {
    
    public nivelTest() {
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

    /**
     * Test of ponEnNivel method, of class nivel.
     */
    @Test
    public void testPonEnNivel() {
        System.out.println("ponEnNivel");
        casilla cas = null;
        Acuatico bicho = null;
        boolean test = false;
        nivel instance = new nivel();
        instance.ponEnNivel(cas, bicho, test);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pintaNivel method, of class nivel.
     */
    @Test
    public void testPintaNivel() {
        System.out.println("pintaNivel");
        boolean test = false;
        nivel instance = new nivel();
        String[] expResult = null;
        String[] result = instance.pintaNivel(test);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of PonTapa method, of class nivel.
     */
    @Test
    public void testPonTapa() {
        System.out.println("PonTapa");
        nivel instance = new nivel();
        String expResult = "";
        String result = instance.PonTapa();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of PonPie method, of class nivel.
     */
    @Test
    public void testPonPie() {
        System.out.println("PonPie");
        String shift = "";
        nivel instance = new nivel();
        String expResult = "";
        String result = instance.PonPie(shift);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of PonPieNumerico method, of class nivel.
     */
    @Test
    public void testPonPieNumerico() {
        System.out.println("PonPieNumerico");
        String shift = "";
        nivel instance = new nivel();
        String expResult = "";
        String result = instance.PonPieNumerico(shift);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of padRight method, of class nivel.
     */
    @Test
    public void testPadRight() {
        System.out.println("padRight");
        String s = "";
        int n = 0;
        String expResult = "";
        String result = nivel.padRight(s, n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of padLeft method, of class nivel.
     */
    @Test
    public void testPadLeft() {
        System.out.println("padLeft");
        String s = "";
        int n = 0;
        String expResult = "";
        String result = nivel.padLeft(s, n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of quitaMarcaActualizadoEnNivel method, of class nivel.
     */
    @Test
    public void testQuitaMarcaActualizadoEnNivel() {
        System.out.println("quitaMarcaActualizadoEnNivel");
        nivel instance = new nivel();
        instance.quitaMarcaActualizadoEnNivel();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of muerenBichosAncianosEnNivel method, of class nivel.
     */
    @Test
    public void testMuerenBichosAncianosEnNivel() {
        System.out.println("muerenBichosAncianosEnNivel");
        boolean test = false;
        nivel instance = new nivel();
        instance.muerenBichosAncianosEnNivel(test);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dameIdBicho method, of class nivel.
     */
    @Test
    public void testDameIdBicho() {
        System.out.println("dameIdBicho");
        casilla cas = null;
        nivel instance = new nivel();
        String expResult = "";
        String result = instance.dameIdBicho(cas);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of devoraPezEnNivel method, of class nivel.
     */
    @Test
    public void testDevoraPezEnNivel() {
        System.out.println("devoraPezEnNivel");
        boolean test = false;
        nivel instance = new nivel();
        instance.devoraPezEnNivel(test);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminaPezEnNivel method, of class nivel.
     */
    @Test
    public void testEliminaPezEnNivel() {
        System.out.println("eliminaPezEnNivel");
        Pez P = null;
        boolean test = false;
        nivel instance = new nivel();
        instance.eliminaPezEnNivel(P, test);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminaTiburonEnNivel method, of class nivel.
     */
    @Test
    public void testEliminaTiburonEnNivel() {
        System.out.println("eliminaTiburonEnNivel");
        Tiburon T = null;
        boolean test = false;
        nivel instance = new nivel();
        instance.eliminaTiburonEnNivel(T, test);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminaPezDeVector method, of class nivel.
     */
    @Test
    public void testEliminaPezDeVector() {
        System.out.println("eliminaPezDeVector");
        String idPez = "";
        boolean test = false;
        nivel instance = new nivel();
        instance.eliminaPezDeVector(idPez, test);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of eliminaTiburonesDeVector method, of class nivel.
     */
    @Test
    public void testEliminaTiburonesDeVector() {
        System.out.println("eliminaTiburonesDeVector");
        String idTib = "";
        boolean test = false;
        nivel instance = new nivel();
        instance.eliminaTiburonesDeVector(idTib, test);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of muevePecesEnNivel method, of class nivel.
     */
    @Test
    public void testMuevePecesEnNivel() {
        System.out.println("muevePecesEnNivel");
        boolean test = false;
        nivel instance = new nivel();
        instance.muevePecesEnNivel(test);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mueveTiburonesEnNivel method, of class nivel.
     */
    @Test
    public void testMueveTiburonesEnNivel() {
        System.out.println("mueveTiburonesEnNivel");
        boolean test = false;
        nivel instance = new nivel();
        instance.mueveTiburonesEnNivel(test);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of colocaEnDestinoP method, of class nivel.
     */
    @Test
    public void testColocaEnDestinoP() {
        System.out.println("colocaEnDestinoP");
        casilla origen = null;
        casilla destino = null;
        nivel instance = new nivel();
        instance.colocaEnDestinoP(origen, destino);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of colocaEnDestinoT method, of class nivel.
     */
    @Test
    public void testColocaEnDestinoT() {
        System.out.println("colocaEnDestinoT");
        casilla origen = null;
        casilla destino = null;
        boolean hayCaza = false;
        nivel instance = new nivel();
        instance.colocaEnDestinoT(origen, destino, hayCaza);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of decideMovimientoPezEnNivel method, of class nivel.
     */
    @Test
    public void testDecideMovimientoPezEnNivel() {
        System.out.println("decideMovimientoPezEnNivel");
        casilla origen = null;
        boolean test = false;
        nivel instance = new nivel();
        boolean expResult = false;
        boolean result = instance.decideMovimientoPezEnNivel(origen, test);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of decideMovimientoTiburonEnNivel method, of class nivel.
     */
    @Test
    public void testDecideMovimientoTiburonEnNivel() {
        System.out.println("decideMovimientoTiburonEnNivel");
        casilla origen = null;
        boolean test = false;
        nivel instance = new nivel();
        instance.decideMovimientoTiburonEnNivel(origen, test);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of esCasillaVacia method, of class nivel.
     */
    @Test
    public void testEsCasillaVacia() {
        System.out.println("esCasillaVacia");
        casilla cas = null;
        nivel instance = new nivel();
        boolean expResult = false;
        boolean result = instance.esCasillaVacia(cas);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dameRumboAleatorio method, of class nivel.
     */
    @Test
    public void testDameRumboAleatorio() {
        System.out.println("dameRumboAleatorio");
        boolean test = false;
        nivel instance = new nivel();
        int expResult = 0;
        int result = instance.dameRumboAleatorio(test);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dameCasillaAleatoriaContigua method, of class nivel.
     */
    @Test
    public void testDameCasillaAleatoriaContigua() {
        System.out.println("dameCasillaAleatoriaContigua");
        casilla origen = null;
        boolean test = false;
        nivel instance = new nivel();
        casilla expResult = null;
        casilla result = instance.dameCasillaAleatoriaContigua(origen, test);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of decideLugarEnNivel method, of class nivel.
     */
    @Test
    public void testDecideLugarEnNivel() {
        System.out.println("decideLugarEnNivel");
        casilla origen = null;
        boolean test = false;
        nivel instance = new nivel();
        casilla expResult = null;
        casilla result = instance.decideLugarEnNivel(origen, test);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of creaIdBichoEnNivel method, of class nivel.
     */
    @Test
    public void testCreaIdBichoEnNivel() {
        System.out.println("creaIdBichoEnNivel");
        casilla cas = null;
        ArrayList vContadores = null;
        String idPadre = "";
        nivel instance = new nivel();
        String expResult = "";
        String result = instance.creaIdBichoEnNivel(cas, vContadores, idPadre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of esMismoBicho method, of class nivel.
     */
    @Test
    public void testEsMismoBicho() {
        System.out.println("esMismoBicho");
        Acuatico a = null;
        Acuatico b = null;
        nivel instance = new nivel();
        boolean expResult = false;
        boolean result = instance.esMismoBicho(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of esMismoPez method, of class nivel.
     */
    @Test
    public void testEsMismoPez() {
        System.out.println("esMismoPez");
        Pez a = null;
        Pez b = null;
        nivel instance = new nivel();
        boolean expResult = false;
        boolean result = instance.esMismoPez(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dameIndicePez method, of class nivel.
     */
    @Test
    public void testDameIndicePez() {
        System.out.println("dameIndicePez");
        Pez objetivo = null;
        nivel instance = new nivel();
        int expResult = 0;
        int result = instance.dameIndicePez(objetivo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of partoPez method, of class nivel.
     */
    @Test
    public void testPartoPez() {
        System.out.println("partoPez");
        casilla cuna = null;
        Pez padre = null;
        ArrayList vContadores = null;
        boolean test = false;
        nivel instance = new nivel();
        instance.partoPez(cuna, padre, vContadores, test);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of partoTiburon method, of class nivel.
     */
    @Test
    public void testPartoTiburon() {
        System.out.println("partoTiburon");
        casilla cuna = null;
        Tiburon padre = null;
        ArrayList vContadores = null;
        boolean test = false;
        nivel instance = new nivel();
        instance.partoTiburon(cuna, padre, vContadores, test);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of colocaEnDestinoPHijo method, of class nivel.
     */
    @Test
    public void testColocaEnDestinoPHijo() {
        System.out.println("colocaEnDestinoPHijo");
        casilla origen = null;
        casilla destino = null;
        boolean test = false;
        nivel instance = new nivel();
        instance.colocaEnDestinoPHijo(origen, destino, test);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of colocaEnDestinoTHijo method, of class nivel.
     */
    @Test
    public void testColocaEnDestinoTHijo() {
        System.out.println("colocaEnDestinoTHijo");
        casilla origen = null;
        casilla destino = null;
        boolean test = false;
        nivel instance = new nivel();
        instance.colocaEnDestinoTHijo(origen, destino, test);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reproduceTiburonEnNivel method, of class nivel.
     */
    @Test
    public void testReproduceTiburonEnNivel() {
        System.out.println("reproduceTiburonEnNivel");
        Tiburon padre = null;
        ArrayList vContadores = null;
        boolean test = false;
        nivel instance = new nivel();
        instance.reproduceTiburonEnNivel(padre, vContadores, test);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reproducePezEnNivel method, of class nivel.
     */
    @Test
    public void testReproducePezEnNivel() {
        System.out.println("reproducePezEnNivel");
        Pez padre = null;
        ArrayList vContadores = null;
        boolean test = false;
        nivel instance = new nivel();
        instance.reproducePezEnNivel(padre, vContadores, test);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reproduceTiburonesEnNivel method, of class nivel.
     */
    @Test
    public void testReproduceTiburonesEnNivel() {
        System.out.println("reproduceTiburonesEnNivel");
        ArrayList vContadores = null;
        boolean test = false;
        nivel instance = new nivel();
        instance.reproduceTiburonesEnNivel(vContadores, test);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reduceCeloTiburonesEnNivel method, of class nivel.
     */
    @Test
    public void testReduceCeloTiburonesEnNivel() {
        System.out.println("reduceCeloTiburonesEnNivel");
        nivel instance = new nivel();
        instance.reduceCeloTiburonesEnNivel();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of poneEnCeloTiburonesEnNivel method, of class nivel.
     */
    @Test
    public void testPoneEnCeloTiburonesEnNivel() {
        System.out.println("poneEnCeloTiburonesEnNivel");
        nivel instance = new nivel();
        instance.poneEnCeloTiburonesEnNivel();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reduceCeloPecesEnNivel method, of class nivel.
     */
    @Test
    public void testReduceCeloPecesEnNivel() {
        System.out.println("reduceCeloPecesEnNivel");
        nivel instance = new nivel();
        instance.reduceCeloPecesEnNivel();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of poneEnCeloPecesEnNivel method, of class nivel.
     */
    @Test
    public void testPoneEnCeloPecesEnNivel() {
        System.out.println("poneEnCeloPecesEnNivel");
        nivel instance = new nivel();
        instance.poneEnCeloPecesEnNivel();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reanudaNoCeloPeces method, of class nivel.
     */
    @Test
    public void testReanudaNoCeloPeces() {
        System.out.println("reanudaNoCeloPeces");
        ArrayList vContadores = null;
        nivel instance = new nivel();
        instance.reanudaNoCeloPeces(vContadores);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reanudaNoCeloTiburones method, of class nivel.
     */
    @Test
    public void testReanudaNoCeloTiburones() {
        System.out.println("reanudaNoCeloTiburones");
        ArrayList vContadores = null;
        nivel instance = new nivel();
        instance.reanudaNoCeloTiburones(vContadores);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reproducePecesEnNivel method, of class nivel.
     */
    @Test
    public void testReproducePecesEnNivel() {
        System.out.println("reproducePecesEnNivel");
        ArrayList vContadores = null;
        boolean test = false;
        nivel instance = new nivel();
        instance.reproducePecesEnNivel(vContadores, test);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of recuentoBichosEnCeloEnNivel method, of class nivel.
     */
    @Test
    public void testRecuentoBichosEnCeloEnNivel() {
        System.out.println("recuentoBichosEnCeloEnNivel");
        nivel instance = new nivel();
        int expResult = 0;
        int result = instance.recuentoBichosEnCeloEnNivel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of recuentoPecesEnCeloEnNivel method, of class nivel.
     */
    @Test
    public void testRecuentoPecesEnCeloEnNivel() {
        System.out.println("recuentoPecesEnCeloEnNivel");
        nivel instance = new nivel();
        int expResult = 0;
        int result = instance.recuentoPecesEnCeloEnNivel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of recuentoTiburonesEnCeloEnNivel method, of class nivel.
     */
    @Test
    public void testRecuentoTiburonesEnCeloEnNivel() {
        System.out.println("recuentoTiburonesEnCeloEnNivel");
        nivel instance = new nivel();
        int expResult = 0;
        int result = instance.recuentoTiburonesEnCeloEnNivel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dameTamañoDelEnteroMayor method, of class nivel.
     */
    @Test
    public void testDameTamañoDelEnteroMayor() {
        System.out.println("dameTama\u00f1oDelEnteroMayor");
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        nivel instance = new nivel();
        int expResult = 0;
        int result = instance.dameTamañoDelEnteroMayor(a, b, c, d);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of estaEnBorde method, of class nivel.
     */
    @Test
    public void testEstaEnBorde() {
        System.out.println("estaEnBorde");
        casilla cas = null;
        nivel instance = new nivel();
        boolean expResult = false;
        boolean result = instance.estaEnBorde(cas);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dimeQueRumboEs method, of class nivel.
     */
    @Test
    public void testDimeQueRumboEs() {
        System.out.println("dimeQueRumboEs");
        int numRumbo = 0;
        nivel instance = new nivel();
        String expResult = "";
        String result = instance.dimeQueRumboEs(numRumbo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of testeaCasillaOrigen method, of class nivel.
     */
    @Test
    public void testTesteaCasillaOrigen() {
        System.out.println("testeaCasillaOrigen");
        int x = 0;
        int y = 0;
        boolean test = false;
        int rumbo = 0;
        nivel instance = new nivel();
        instance.testeaCasillaOrigen(x, y, test, rumbo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of testeaCasillaDestino method, of class nivel.
     */
    @Test
    public void testTesteaCasillaDestino() {
        System.out.println("testeaCasillaDestino");
        int x = 0;
        int y = 0;
        boolean test = false;
        int rumbo = 0;
        nivel instance = new nivel();
        instance.testeaCasillaDestino(x, y, test, rumbo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dameCasillaDestino method, of class nivel.
     */
    @Test
    public void testDameCasillaDestino() {
        System.out.println("dameCasillaDestino");
        int rumbo = 0;
        casilla origen = null;
        boolean test = false;
        nivel instance = new nivel();
        casilla expResult = null;
        casilla result = instance.dameCasillaDestino(rumbo, origen, test);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
