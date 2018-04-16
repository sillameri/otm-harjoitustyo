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
        laskin = new Laskin("pata", 3, 2, "yli", "Normaali", "Vaaraton");;

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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
