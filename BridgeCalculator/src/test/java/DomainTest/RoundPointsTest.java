/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainTest;

import bridgecalculator.domain.RoundPointsCalculator;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Meri
 */
public class RoundPointsTest {

    public RoundPointsTest() {
    }

    RoundPointsCalculator roundpoints1;
    RoundPointsCalculator roundpoints2;

    @Before
    public void setUp() {
        roundpoints1 = new RoundPointsCalculator("ns", "Pata", 3, 2, "Yli", "Normaali", "Vaaraton");
        roundpoints2 = new RoundPointsCalculator("ew", "Ruutu", 3, 2, "Ali", "Normaali", "Vaaraton");

    }

    @Test
    public void calculatorExist() {
        assertTrue(roundpoints1 != null);
    }

    @Test
    public void retunrsGame() {
        roundpoints1.setGame(1);
        assertEquals(1, roundpoints1.getGame());
    }

    @Test
    public void returnsContractTrick() {
        assertEquals(3, roundpoints1.getContractTrick());
    }

    @Test
    public void returnsResultTrick() {
        assertEquals(2, roundpoints1.getResultTrick());
    }

    @Test
    public void returnsTeam() {
        assertEquals("ns", roundpoints1.getTeam());
    }

    @Test
    public void returnsSuitCoefficient1() {
        assertEquals(30, roundpoints1.getSuitCoefficient());
    }

    @Test
    public void returnsSuitCoefficient2() {
        assertEquals(20, roundpoints2.getSuitCoefficient());
    }

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

    @Test
    public void retunrsUnVulnerableLostPoints4() {
        RoundPointsCalculator points = new RoundPointsCalculator("ns", "Valtiton", 4, 4, "Yli", "Normaali", "Vaaraton");;
        assertEquals(0, points.countUnVulnerableLostPoints());
    }

    @Test
    public void retunrsVulnerableLostPoints1() {
        RoundPointsCalculator points = new RoundPointsCalculator("ns", "Valtiton", 1, 1, "Ali", "Normaali", "Vaaraton");;
        assertEquals(200, points.countVulnerableLostPoints());
    }

    @Test
    public void retunrsVulnerableLostPoints2() {
        RoundPointsCalculator points = new RoundPointsCalculator("ns", "Valtiton", 3, 3, "Ali", "Normaali", "Vaaraton");;
        assertEquals(800, points.countVulnerableLostPoints());
    }

    @Test
    public void retunrsVulnerableLostPoints3() {
        RoundPointsCalculator points = new RoundPointsCalculator("ns", "Valtiton", 4, 4, "Yli", "Normaali", "Vaaraton");;
        assertEquals(0, points.countUnVulnerableLostPoints());
    }

    @Test
    public void retunrsLostPointsWithConditions1() {
        RoundPointsCalculator points = new RoundPointsCalculator("ns", "Valtiton", 1, 1, "Ali", "Normaali", "Vaaraton");;
        assertEquals(50, points.countLostPointsWithConditions());
    }

    @Test
    public void retunrsLostPointsWithConditions2() {
        RoundPointsCalculator points = new RoundPointsCalculator("ns", "Valtiton", 1, 1, "Ali", "Kahdennettu", "Vaaraton");;
        assertEquals(100, points.countLostPointsWithConditions());
    }

    @Test
    public void retunrsLostPointsWithConditions3() {
        RoundPointsCalculator points = new RoundPointsCalculator("ns", "Valtiton", 1, 1, "Ali", "Vastakahdennettu", "Vaaraton");;
        assertEquals(200, points.countLostPointsWithConditions());
    }

    @Test
    public void retunrsLostPointsWithConditions4() {
        RoundPointsCalculator points = new RoundPointsCalculator("ns", "Valtiton", 1, 1, "Ali", "Normaali", "Vaarassa");;
        assertEquals(100, points.countLostPointsWithConditions());
    }

    @Test
    public void retunrsLostPointsWithConditions5() {
        RoundPointsCalculator points = new RoundPointsCalculator("ns", "Valtiton", 1, 1, "Ali", "Kahdennettu", "Vaarassa");;
        assertEquals(200, points.countLostPointsWithConditions());
    }

    @Test
    public void retunrsLostPointsWithConditions6() {
        RoundPointsCalculator points = new RoundPointsCalculator("ns", "Valtiton", 1, 1, "Ali", "Vastakahdennettu", "Vaarassa");;
        assertEquals(400, points.countLostPointsWithConditions());
    }

    @Test
    public void retunrsLostPointsWithConditions7() {
        RoundPointsCalculator points = new RoundPointsCalculator("ns", "Valtiton", 1, 1, "Yli", "Vastakahdennettu", "Vaarassa");;
        assertEquals(0, points.countLostPointsWithConditions());
    }


}
