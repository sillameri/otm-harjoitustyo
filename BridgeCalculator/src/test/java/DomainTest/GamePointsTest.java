/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainTest;

import bridgecalculator.domain.GamePointsCalculator;
import bridgecalculator.domain.RoundPointsCalculator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Meri
 */
public class GamePointsTest {

    public GamePointsTest() {
    }

    GamePointsCalculator gamepoints;
    RoundPointsCalculator roundpoints;
    RoundPointsCalculator roundpoints2;
    RoundPointsCalculator roundpoints3;

    @Before
    public void setUp() {
        gamepoints = new GamePointsCalculator();
        roundpoints = new RoundPointsCalculator("ns", "Pata", 1, 1, "Yli", "Normaali", "Vaaraton");
    }

    @Test
    public void retunrsgetWin1() {
        assertEquals(0, gamepoints.getWin("ns"));
    }

    @Test
    public void retunrsgetWin2() {
        assertEquals(0, gamepoints.getWin("ew"));
    }

    @Test
    public void retunrsGetOverLine1() {
        gamepoints.addrpc(roundpoints);
        gamepoints.updateSumNsPoints();
        assertEquals("30", gamepoints.getOverLine("ns"));
    }

    @Test
    public void retunrsGetOverLine2() {
        roundpoints2 = new RoundPointsCalculator("ew", "Pata", 1, 1, "Yli", "Normaali", "Vaaraton");
        gamepoints.addrpc(roundpoints2);
        gamepoints.updateSumEwPoints();
        assertEquals("30", gamepoints.getOverLine("ew"));
    }

    @Test
    public void retunrsGetUnderLineString1() {
        roundpoints2 = new RoundPointsCalculator("ew", "Pata", 2, 2, "Yli", "Normaali", "Vaaraton");
        gamepoints.addrpc(roundpoints2);
        gamepoints.updateSumEwPoints();
        assertEquals("60", gamepoints.getUnderLineString("ew"));
    }

    @Test
    public void retunrsGetUnderLineString2() {
        gamepoints.addrpc(roundpoints);
        gamepoints.updateSumNsPoints();
        assertEquals("30", gamepoints.getUnderLineString("ns"));
    }

    @Test
    public void returnsGetTotalPoints() {
        roundpoints2 = new RoundPointsCalculator("ns", "Pata", 2, 2, "Yli", "Normaali", "Vaaraton");
        roundpoints3 = new RoundPointsCalculator("ew", "Hertta", 4, 3, "Ali", "Normaali", "Vaarassa");
        gamepoints.addrpc(roundpoints2);
        gamepoints.addrpc(roundpoints3);

        assertEquals(420, gamepoints.getTotalPoints("ns", "ew"));
    }
    
    
     @Test
    public void returnsGetTotalPoints2() {
        roundpoints2 = new RoundPointsCalculator("ns", "Valtiton", 4, 0, "Yli", "Normaali", "Vaaraton");
        roundpoints3 = new RoundPointsCalculator("ew", "Hertta", 2, 1, "Yli", "Normaali", "Vaarassa");
        gamepoints.addrpc(roundpoints2);
        gamepoints.addrpc(roundpoints3);

        assertEquals(90, gamepoints.getTotalPoints("ew", "ns"));
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
