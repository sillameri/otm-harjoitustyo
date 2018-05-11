/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WinnerResutTest;

import bridgecalculator.domain.Result;
import bridgecalculator.domain.Winner;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Meri
 */
public class WinnerTest {

    public WinnerTest() {
    }

    Winner winner1;
    Winner winner2;
    Result result1;
    Result result2;

    @Before
    public void setUp() {
        winner1 = new Winner("ns", 120, 50);
        winner2 = new Winner("ew", 200, 45);
        result1 = new Result(400, 15);
        result2 = new Result(120, 1340);

    }

    @Test
    public void returnWinner1() {
        assertEquals("ns", winner1.getWinner());

    }

    @Test
    public void returnWinner2() {
        assertEquals("ew", winner2.getWinner());
    }

    @Test
    public void returnLoserPoints() {
        assertEquals(50, winner1.getLoserPoints());
    }

    @Test
    public void returnWinnerPoints() {
        assertEquals(120, winner1.getWinnerPoints());
    }

    @Test
    public void returnWinnerPrint() {
        assertEquals("ew:200:45\n", winner2.toString());
    }

    @Test
    public void returnResultWinner1() {
        assertEquals("NS", result1.getWinner());
    }
    
     @Test
    public void returnResultWinner2() {
        assertEquals("EW", result2.getWinner());
    }
    
     @Test
    public void returnResultPrint1() {
        assertEquals("NS:400:15\n", result1.toString());
    }
    
     @Test
    public void returnResultPrint2() {
        assertEquals("EW:1340:120\n", result2.toString());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
