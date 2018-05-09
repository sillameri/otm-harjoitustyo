/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bridgecalculator.dao;

import bridgecalculator.domain.GamePointsCalculator;
import bridgecalculator.domain.Winner;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * @author Meri
 */
public class FileBridgeCalculatorDao {

    public Winner winner;
    private String file;

    public FileBridgeCalculatorDao(String file, Winner winner) {
        this.file = file;
        this.winner = winner;
    }

   

    public void save() throws Exception {
        try (FileWriter writer = new FileWriter(file, true)) {
                
                writer.write(winner.toString());
            
        }
    }

}
