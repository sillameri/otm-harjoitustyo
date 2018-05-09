package bridgecalculator.ui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        highScoreLabel.setText(setTopPoints("data.txt"));
    }

    public Button getCloseGameButton() {
        return this.closeButton;
    }

    public String setTopPoints(String file) {
        List<String> lines = new ArrayList<>();
        try {
            Files.lines(Paths.get(file))
                    .forEach(row -> lines.add(row));
                    
        } catch (IOException ex) {
            System.out.println("Tiedoston " + file + " lukeminen epäonnistui.");
        }
        
        String points = "";
        for (int i = 0; i < lines.size(); i++) {
            points += "" + lines.get(i) + "\n";
        }
        return points;
        
    }

    @FXML
    private void handleCloseButtonAction(ActionEvent event) {
    }

}
