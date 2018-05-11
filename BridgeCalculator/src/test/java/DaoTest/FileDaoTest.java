/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DaoTest;

import bridgecalculator.dao.FileBridgeCalculatorDao;
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
public class FileDaoTest {
    
    FileBridgeCalculatorDao dao;
    
    public FileDaoTest() {
    }
    
     @Before
    public void setUp() {
        dao = new FileBridgeCalculatorDao("testdata.txt");
        dao.load();
        
    }
    
    @Test
    public void retunrsTopList() {
        String print = "" + dao.getTop(1).get(0);
        assertEquals("NS:1310:0\n", print);
    }
    
    

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
