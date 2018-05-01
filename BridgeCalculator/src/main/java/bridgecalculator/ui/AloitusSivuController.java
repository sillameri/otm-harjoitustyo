/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bridgecalculator.ui;

import bridgecalculator.domain.GamePoints;
import bridgecalculator.domain.RoundPoints;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Meri
 */
public class AloitusSivuController implements Initializable {

    private GamePoints gamePoints;
    private RoundPoints laskin;

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

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        Parent aloitusSivuParent = FXMLLoader.load(getClass().getResource("/fxml/Scene.fxml"));
        Scene aloitusSivuScene = new Scene(aloitusSivuParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(aloitusSivuScene);
        window.show();

    }

//    
    @FXML
    private void handelUpdatePointsAction(ActionEvent event) {
        
//        GamePoints gemePoints = new GamePoints(laskin.getTeam(), laskin.laskeYliLinjan(), laskin.laskeAlleLinjan(), laskin.laskeHavitytPisteet());

        labelONS1.setText(gamePoints.PointsNsOverLine());
        labelOEW1.setText(gamePoints.PointsEwOverLine());
        labelDNS1.setText(gamePoints.PointsNsUnderLine());
        labelDEW1.setText(gamePoints.PointsEwUnderLine());

    }

}
