/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bridgecalculator.dao;

import bridgecalculator.domain.GamePointsCalculator;
import bridgecalculator.domain.Winner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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
//    public Winner winner;
    private String file;

    public FileBridgeCalculatorDao(String file) {
        this.file = file;
//        this.winner = winner;
    }

    public void addWinner(Winner winner) {
        winners.add(winner);
    }

    public void save(Winner winner) throws IOException {
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(winner.toString());

        }
    }

    public void load()  {

        try {
            Scanner reader = new Scanner(new FileInputStream(this.file));
            while (reader.hasNextLine()) {
                
                String line = reader.nextLine();
                String[] parts = line.split(":");
                System.out.println(Arrays.toString(parts));
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

        Collections.sort(winners, new Comparator<Winner>() {
            @Override
            public int compare(Winner o1, Winner o2) {
                return o2.getPoints() - o1.getPoints();
            }

        });

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

//        try {
//            Files.lines(Paths.get(file))
//                    .map(row -> row.split(":"))
//                    .map(part -> new Winner(part[0], Integer.parseInt(part[1])))
//                    .forEach(winner -> topPoints.add(winner));
//
//        } catch (IOException ex) {
//            System.out.println("Tiedoston " + file + " lukeminen epäonnistui.");
//        }
//        String print = "";
//        topPoints.stream().sorted((p1, p2) -> {
//            return p1.getPoints() - p2.getPoints();
//        }).forEach(points -> System.out.println(points.getWinner() + " " + points.getPoints()));
//}
}
