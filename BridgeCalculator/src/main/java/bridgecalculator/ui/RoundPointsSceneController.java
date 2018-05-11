package bridgecalculator.ui;

import bridgecalculator.domain.RoundPointsCalculator;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class RoundPointsSceneController implements Initializable {

    ObservableList suits = FXCollections.observableArrayList();
    ObservableList contractTricks = FXCollections.observableArrayList();
    ObservableList resultTricks = FXCollections.observableArrayList();

    private RoundPointsCalculator roundPoints;
//    private GamePointsCalculator gamePoints;

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

    public RoundPointsCalculator getRoundPointsCalculator() {
        return roundPoints;
    }

    public Button getBackButton() {
        return this.getBack;
    }

    @FXML
    private void handleCalculateAction(ActionEvent event) {
        String team = selectedTeam(event);
        String suit = (String) suitSelected.getValue();
        Integer contractTrick = (Integer) contractTrickSelected.getValue();
        Integer resultTrick = (Integer) resultTrickSelected.getValue();
        String resultOption = selectedResult(event);
        String normalOption = selectedNormalOption(event);
        String vulnerableOption = selectedVunerableOption(event);

        if (suit == null || contractTrick == null || resultTrick == null) {
            label.setText("Täytä kaikki kentät");

        } else {
            roundPoints = new RoundPointsCalculator(team, suit, contractTrick, resultTrick, resultOption, normalOption, vulnerableOption);
            label.setText(roundPoints.toString());
        }

    }

    public void clearWindow() {
        ns.setSelected(true);
        normal.setSelected(true);
        over.setSelected(true);
        unVulnerable.setSelected(true);
        suitSelected.setValue(null);
        contractTrickSelected.setValue(null);
        resultTrickSelected.setValue(null);
        roundPoints = null;
        label.setText(null);

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
