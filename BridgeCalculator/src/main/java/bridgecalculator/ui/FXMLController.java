package bridgecalculator.ui;

import bridgecalculator.domain.GamePoints;
import bridgecalculator.domain.RoundPoints;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class FXMLController implements Initializable {

    ObservableList suits = FXCollections.observableArrayList();
    ObservableList contractTricks = FXCollections.observableArrayList();
    ObservableList resultTricks = FXCollections.observableArrayList();
    private RoundPoints laskin;
    private GamePoints gamePoints;

    @FXML
    private Label label;
    @FXML
    private RadioButton down;
    @FXML
    private RadioButton over;
    @FXML
    private ChoiceBox<?> resultTrickSelected;
    @FXML
    private RadioButton vulnerable;
    @FXML
    private RadioButton unVulnerable;
    @FXML
    private RadioButton reDoubled;
    @FXML
    private RadioButton doubled;
    @FXML
    private RadioButton normal;
    @FXML
    private ChoiceBox<?> suitSelected;
    @FXML
    private ChoiceBox<?> contractTrickSelected;
    @FXML
    private Button calculate;
    @FXML
    private Button addPoints;
    @FXML
    private RadioButton ns;
    @FXML
    private RadioButton ew;
    @FXML
    private ToggleGroup tulos;
    @FXML
    private ToggleGroup vaara;
    @FXML
    private ToggleGroup tuplaus;
    @FXML
    private ToggleGroup team;
    @FXML
    private Button getBack;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        String team = selectedTeam(event);
        String suit = (String) suitSelected.getValue();
        Integer contractTrick = (Integer) contractTrickSelected.getValue();
        Integer resultTrick = (Integer) resultTrickSelected.getValue();
        String resultOption = selectedResult(event);
        String normalOption = selectedNormalOption(event);
        String vulnerableOption = selectedVunerableOption(event);

        if (suit == null || contractTrick == null || resultTrick == null) {
            
            label.setText("Täytä kaikki kentät");
            label.setTextFill(Color.web("#f91408"));

            
        } else {

            RoundPoints laskin = new RoundPoints(team, suit, contractTrick, resultTrick, resultOption, normalOption, vulnerableOption);
            label.setText(laskin.toString());
        }
//        GamePoints points = new GamePoints(team, laskin.countPointsOverLineWithConditions(), laskin.countPointsUnderLine(), laskin.countLostPointsWithConditions());

    }

    @FXML
    private void addCalculatedPoints(ActionEvent event) {

    }

    @FXML
    private void handleGetBackAction(ActionEvent event) throws IOException {
        Parent aloitusSivuParent = FXMLLoader.load(getClass().getResource("/fxml/AloitusSivu.fxml"));
        Scene aloitusSivuScene = new Scene(aloitusSivuParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(aloitusSivuScene);
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setSuits();
        setContractTricks();
        setResultTricks();

    }

    public String selectedTeam(ActionEvent event) {
        String text = "";
        if (ns.isSelected()) {
            text += ns.getText();
        }
        if (ew.isSelected()) {
            text += ew.getText();
        }
        return text;
    }

    public String selectedResult(ActionEvent event) {
        String text = "";
        if (over.isSelected()) {
            text += over.getText();
        }
        if (down.isSelected()) {
            text += down.getText();
        }
        return text;
    }

    public String selectedNormalOption(ActionEvent event) {
        String text = "";
        if (normal.isSelected()) {
            text += normal.getText();
        }
        if (doubled.isSelected()) {
            text += doubled.getText();
        }
        if (reDoubled.isSelected()) {
            text += reDoubled.getText();
        }
        return text;
    }

    public String selectedVunerableOption(ActionEvent event) {
        String text = "";
        if (vulnerable.isSelected()) {
            text += vulnerable.getText();
        }
        if (unVulnerable.isSelected()) {
            text += unVulnerable.getText();
        }
        return text;
    }

    private void setSuits() {
        suits.removeAll(suits);
        String a = "Pata";
        String b = "Hertta";
        String c = "Ruutu";
        String d = "Risti";
        String e = "Valtiton";
        suits.addAll(a, b, c, d, e);
        suitSelected.getItems().addAll(suits);
    }

    private void setContractTricks() {
        contractTricks.removeAll(contractTricks);
        int a = 1;
        int b = 2;
        int c = 3;
        int d = 4;
        int e = 5;
        int f = 6;
        int g = 7;
        contractTricks.addAll(a, b, c, d, e, f, g);
        contractTrickSelected.getItems().addAll(contractTricks);

    }

    private void setResultTricks() {
        resultTricks.removeAll(resultTricks);
        int x = 0;
        int a = 1;
        int b = 2;
        int c = 3;
        int d = 4;
        int e = 5;
        int f = 6;
        int g = 7;
        resultTricks.addAll(x, a, b, c, d, e, f, g);
        resultTrickSelected.getItems().addAll(resultTricks);

    }

}
