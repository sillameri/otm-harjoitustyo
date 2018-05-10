package bridgecalculator.ui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import bridgecalculator.dao.FileBridgeCalculatorDao;
import bridgecalculator.domain.Winner;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Meri
 */
public class HighScoreSceneController implements Initializable {

    @FXML
    private Label highScoreLabel;
    @FXML
    private Button closeButton;

    private FileBridgeCalculatorDao dao;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        dao = new FileBridgeCalculatorDao("data.txt");
        dao.load();
        List<Winner> toplist = dao.getTop(5);
        String print = "";
        for (int i = 0; i < toplist.size(); i++) {
            Winner w = toplist.get(i);
            print += (i + 1) + ". " + w.getWinner() + "  " + w.getPoints() + " ("+ w.getLoserPoints()+ ")"+"\n";
        }

        highScoreLabel.setText(print);
    }

    public Button getCloseGameButton() {
        return this.closeButton;
    }

//    public String setTopPoints(String file) {
////        List<Winner> topPoints = new ArrayList<>();
////        try {
////            Files.lines(Paths.get(file))
////                    .map(row -> row.split(":"))
////                    .map(part -> new Winner(part[0], Integer.parseInt(part[1])))
////                    .forEach(winner -> topPoints.add(winner));
////
////        } catch (IOException ex) {
////            System.out.println("Tiedoston " + file + " lukeminen epäonnistui.");
////        }
////        String print = "";
////        topPoints.stream().sorted((p1, p2) -> {
////            return p1.getPoints() - p2.getPoints();
////        }).forEach(points -> System.out.println(points.getWinner() + " "+ points.getPoints()));
//////
//
//        List<String> points = new ArrayList<>();
//        
//        try {
//            Files.lines(Paths.get(file))
//                    .forEach(rows -> points.add(rows));
//
//        } catch (IOException ex) {
//            System.out.println("Tiedoston " + file + " lukeminen epäonnistui.");
//        }
//    
//        String print = "";
//        for (int i = 0; i < points.size(); i++) {
//            print += (i+1) + ". " + points.get(i) + "\n";
//        }
//        return print;
//    }
    @FXML
    private void handleCloseButtonAction(ActionEvent event) {
    }

}
