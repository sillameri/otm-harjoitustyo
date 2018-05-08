package bridgecalculator.ui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Meri
 */
public class EndGameSceneController implements Initializable {

    @FXML
    private Label winner;
    @FXML
    private Label pointsNs;
    @FXML
    private Label pointsEw;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void setWinner(String winner) {
        this.winner.setText(winner);
    }

    public void setPointsNs(int pointsNs) {
        this.pointsNs.setText("" + pointsNs);
    }

    public void setPointsEw(int pointsEw) {
        this.pointsEw.setText("" + pointsEw);
    }

}
