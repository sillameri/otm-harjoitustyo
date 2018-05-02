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

    RoundPointsCalculator roundpoints1;
    RoundPointsCalculator roundpoints2;
    GamePointsCalculator gamepoints;

    @Before
    public void setUp() {
        roundpoints1 = new RoundPointsCalculator("ns", "Pata", 3, 2, "Yli", "Normaali", "Vaaraton");
        roundpoints2 = new RoundPointsCalculator("ew", "Ruutu", 3, 2, "Ali", "Normaali", "Vaaraton");

        gamepoints = new GamePointsCalculator("ns", 30, 40, 0);
    }

    @Test
    public void luotuLaskinOlemassa() {
        assertTrue(roundpoints1 != null);
    }

    @Test
    public void palauttaaTrikin() {
        assertEquals(3, roundpoints1.getContractTrick());
    }

    @Test
    public void palauttaaTikin() {
        assertEquals(2, roundpoints1.getResultTrick());
    }

    @Test
    public void palauttaaJoukkueen() {
        assertEquals("ns", roundpoints1.getTeam());
    }

    @Test
    public void palauttaaMaakertoimen1() {
        assertEquals(30, roundpoints1.getSuitCoefficient());
    }

    @Test
    public void palauttaaMaakertoimen2() {
        assertEquals(20, roundpoints2.getSuitCoefficient());
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

    // viiikko 6
    @Test
    public void returnsNormalOption() {
        assertEquals("Normaali", roundpoints1.getNormal());
    }

    @Test
    public void returnsVulnerableOption() {
        assertEquals("Vaaraton", roundpoints1.getVulnerable());
    }

    @Test
    public void returnsNoTrumpPointsUnderLine1() {
        RoundPointsCalculator points = new RoundPointsCalculator("ns", "Valtiton", 3, 2, "Yli", "Normaali", "Vaaraton");;
        assertEquals(100, points.countNoTrumpPointsUnderLine());
    }

    @Test
    public void returnsNoTrumpPointsUnderLine2() {
        RoundPointsCalculator points = new RoundPointsCalculator("ns", "Valtiton", 1, 2, "Yli", "Normaali", "Vaaraton");;
        assertEquals(40, points.countNoTrumpPointsUnderLine());
    }

    @Test
    public void returnsNoTrumpPointsUnderLine3() {
        assertEquals(0, roundpoints1.countNoTrumpPointsUnderLine());
    }

    @Test
    public void returnsNoTrumpPointsOverLine1() {
        RoundPointsCalculator points = new RoundPointsCalculator("ns", "Valtiton", 0, 0, "Yli", "Normaali", "Vaaraton");;
        assertEquals(0, points.countNoTrumpPointsOverLine());
    }

    @Test
    public void returnsNoTrumpPointsOverLine2() {
        RoundPointsCalculator points = new RoundPointsCalculator("ns", "Pata", 0, 0, "Yli", "Normaali", "Vaaraton");;
        assertEquals(0, points.countNoTrumpPointsOverLine());
    }

    @Test
    public void returnsNoTrumpPointsOverLine3() {
        RoundPointsCalculator points = new RoundPointsCalculator("ns", "Valtiton", 1, 1, "Yli", "Normaali", "Vaaraton");;
        assertEquals(40, points.countNoTrumpPointsOverLine());
    }

    @Test
    public void returnsNoTrumpPointsOverLine4() {
        RoundPointsCalculator points = new RoundPointsCalculator("ns", "Valtiton", 3, 3, "Yli", "Normaali", "Vaaraton");;
        assertEquals(100, points.countNoTrumpPointsOverLine());
    }

    @Test
    public void retunrsPointsUnderLine1() {
        assertEquals(90, roundpoints1.countPointsUnderLine());
    }

    @Test
    public void retunrsPointsUnderLine2() {
        RoundPointsCalculator points = new RoundPointsCalculator("ns", "Valtiton", 1, 1, "Yli", "Normaali", "Vaaraton");;
        assertEquals(40, points.countPointsUnderLine());
    }

    @Test
    public void retunrsPointsOverLine1() {
        assertEquals(60, roundpoints1.countPointsOverLine());
    }

    @Test
    public void retunrsPointsOverLine2() {
        RoundPointsCalculator points = new RoundPointsCalculator("ns", "Valtiton", 1, 1, "Yli", "Normaali", "Vaaraton");;
        assertEquals(40, points.countPointsOverLine());
    }

    @Test
    public void retunrsPointsOverLineWithConditions1() {
        RoundPointsCalculator points = new RoundPointsCalculator("ns", "Valtiton", 1, 1, "Yli", "Normaali", "Vaaraton");;
        assertEquals(40, points.countPointsOverLineWithConditions());
    }

    @Test
    public void retunrsPointsOverLineWithConditions2() {
        RoundPointsCalculator points = new RoundPointsCalculator("ns", "Valtiton", 1, 1, "Yli", "Kahdennettu", "Vaaraton");;
        assertEquals(100, points.countPointsOverLineWithConditions());
    }

    @Test
    public void retunrsPointsOverLineWithConditions3() {
        RoundPointsCalculator points = new RoundPointsCalculator("ns", "Valtiton", 1, 1, "Yli", "Kahdennettu", "Vaarassa");;
        assertEquals(200, points.countPointsOverLineWithConditions());
    }

    @Test
    public void retunrsPointsOverLineWithConditions4() {
        RoundPointsCalculator points = new RoundPointsCalculator("ns", "Valtiton", 1, 1, "Yli", "Vastakahdennettu", "Vaaraton");;
        assertEquals(200, points.countPointsOverLineWithConditions());
    }

    @Test
    public void retunrsPointsOverLineWithConditions5() {
        RoundPointsCalculator points = new RoundPointsCalculator("ns", "Valtiton", 1, 1, "Yli", "Vastakahdennettu", "Vaarassa");;
        assertEquals(400, points.countPointsOverLineWithConditions());
    }

    @Test
    public void retunrsUnVulnerableLostPoints1() {
        RoundPointsCalculator points = new RoundPointsCalculator("ns", "Valtiton", 1, 1, "Ali", "Normaali", "Vaaraton");;
        assertEquals(100, points.countUnVulnerableLostPoints());
    }

    @Test
    public void retunrsUnVulnerableLostPoints2() {
        RoundPointsCalculator points = new RoundPointsCalculator("ns", "Valtiton", 2, 2, "Ali", "Normaali", "Vaaraton");;
        assertEquals(300, points.countUnVulnerableLostPoints());
    }

    @Test
    public void retunrsUnVulnerableLostPoints3() {
        RoundPointsCalculator points = new RoundPointsCalculator("ns", "Valtiton", 4, 4, "Ali", "Normaali", "Vaaraton");;
        assertEquals(800, points.countUnVulnerableLostPoints());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
