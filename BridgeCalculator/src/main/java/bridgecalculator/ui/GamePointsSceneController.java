/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bridgecalculator.ui;

import bridgecalculator.domain.GamePointsCalculator;
import java.net.URL;
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
public class GamePointsSceneController implements Initializable {

    private GamePointsCalculator gamePoints;

    @FXML
    private Button siirry;
    @FXML
    private Label labelONS1;
    @FXML
    private Label labelOEW1;
    @FXML
    private Label labelDNS1;
    @FXML
    private Label labelDNS2;
    @FXML
    private Label labelDEW1;
    @FXML
    private Label labelDEW2;
    @FXML
    private Button updatePoints;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void setGamePointsCalculator(GamePointsCalculator gamePoints) {
        this.gamePoints = gamePoints;
    }

    public Button getBackButton() {
        return this.siirry;
    }

    @FXML
    private void handelUpdatePointsAction(ActionEvent event) {
        gamePoints.updateSumNsPoints();
        gamePoints.updateSumEwPoints();
        labelONS1.setText(gamePoints.getOverLineNs());
        labelOEW1.setText(gamePoints.getOverLineEw());
        labelDNS1.setText(gamePoints.getUnderLineNs());
        labelDEW1.setText(gamePoints.getUnderLineEw());
        labelDNS2.setText(gamePoints.getUnderLineNs2());
        labelDEW2.setText(gamePoints.getUnderLineEw2());

    }

}
