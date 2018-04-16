/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import bridgecalculator.domain.Laskin;

/**
 *
 * @author Meri
 */
public class BridgeTest {

    public BridgeTest() {
    }

    Laskin laskin;

    @Before
    public void setUp() {
        laskin = new Laskin("Pata", 3, 2, "Yli", "Normaali", "Vaaraton");;

    }

    @Test
    public void luotuLaskinOlemassa() {
        assertTrue(laskin != null);
    }

    @Test
    public void palauttaaTrikin() {
        assertEquals(3, laskin.getTrikki());
    }

    @Test
    public void palauttaaTikin() {
        assertEquals(2, laskin.getTikki());
    }
    
     @Test
    public void palauttaaMaakertoimen() {
        assertEquals(30, laskin.getMaaKerroin());
    }
    
     @Test
    public void palauttaaPisteetAlleViivan() {
        assertEquals(90, laskin.laskeAlleLinjan());
    }
    
     @Test
    public void palauttaaPisteetViivanPaalle() {
        assertEquals(60, laskin.laskeYliLinjan());
    }
    
     @Test
    public void palauttaaHavitytPisteet() {
        assertEquals(0, laskin.laskeHavitytPisteet());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
