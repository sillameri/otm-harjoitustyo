package bridgecalculator.ui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import bridgecalculator.dao.FileBridgeCalculatorDao;
import bridgecalculator.domain.Winner;
import java.net.URL;
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
            print += (i + 1) + ". " + w.getWinner() + "  " + w.getPoints() + " (" + w.getLoserPoints() + ")" + "\n";
        }

        highScoreLabel.setText(print);
    }

    public Button getCloseGameButton() {
        return this.closeButton;
    }

    @FXML
    private void handleCloseButtonAction(ActionEvent event) {
    }

}
