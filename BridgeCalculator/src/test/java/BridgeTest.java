/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import bridgecalculator.domain.GamePointsCalculator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import bridgecalculator.domain.RoundPointsCalculator;

/**
 *
 * @author Meri
 */
public class BridgeTest {

    public BridgeTest() {
    }

    RoundPointsCalculator laskin;
    GamePointsCalculator gamepoints;

    @Before
    public void setUp() {
        laskin = new RoundPointsCalculator("ns", "Pata", 3, 2, "Yli", "Normaali", "Vaaraton");
        gamepoints = new GamePointsCalculator("ns", 30 ,40,0);
    }

    @Test
    public void luotuLaskinOlemassa() {
        assertTrue(laskin != null);
    }

    @Test
    public void palauttaaTrikin() {
        assertEquals(3, laskin.getContractTrick());
    }

    @Test
    public void palauttaaTikin() {
        assertEquals(2, laskin.getResultTrick());
    }

    @Test
    public void palauttaaJoukkueen() {
        assertEquals("ns", laskin.getTeam());
    }

    @Test
    public void palauttaaMaakertoimen() {
        assertEquals(30, laskin.getSuitCoefficient());
    }

    @Test
    public void palauttaaPisteetAlleViivan() {
        assertEquals(90, laskin.countPointsUnderLine());
    }

    @Test
    public void palauttaaPisteetViivanPaalle() {
        assertEquals(60, laskin.countPointsOverLine());
    }

    
    @Test
    public void luotuGamePointOlemassa() {
        assertTrue(gamepoints != null);
    }
    
    @Test
    public void palauttaaNsUnderLine() {
        assertEquals("40", gamepoints.PointsNsUnderLine());
    }
    
    @Test
    public void palauttaaNsOverLine() {
        assertEquals("30", gamepoints.PointsNsOverLine());
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
