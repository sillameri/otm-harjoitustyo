/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bridgecalculator.dao;

import bridgecalculator.domain.Result;
import bridgecalculator.domain.Winner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Meri
 */
public class FileBridgeCalculatorDao {

    List<Winner> winners = new ArrayList<>();
    private String file;

    public FileBridgeCalculatorDao(String file) {
        this.file = file;
    }

    public void addWinner(Winner winner) {
        winners.add(winner);
    }

    public void save(Result result) throws IOException {
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(result.toString());

        }
    }

    public void load()  {

        try {
            Scanner reader = new Scanner(new FileInputStream(this.file));
            while (reader.hasNextLine()) {
                
                String line = reader.nextLine();
                String[] parts = line.split(":");
                if (parts.length >= 3) {
                    Winner winner = new Winner(parts[0], Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
                    winners.add(winner);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileBridgeCalculatorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Winner> getTop(int a) {
        List<Winner> toplist = new ArrayList();

        Collections.sort(winners, (Winner o1, Winner o2) -> o2.getWinnerPoints() - o1.getWinnerPoints());

        int counter = 0;
        for (Winner winner : winners) {
            if (counter >= a) {
                break;
            }
            toplist.add(winner);
            counter++;
        }

        return toplist;
    }

}
