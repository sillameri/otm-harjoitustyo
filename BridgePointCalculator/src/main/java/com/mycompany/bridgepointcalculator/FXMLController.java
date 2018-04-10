package com.mycompany.bridgepointcalculator;

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
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class FXMLController implements Initializable {

    ObservableList maat = FXCollections.observableArrayList();
    ObservableList trikit = FXCollections.observableArrayList();
    ObservableList tulosTikit = FXCollections.observableArrayList();
    private Laskin laskin;

    @FXML
    private Label label;
    @FXML
    private Button button;
    @FXML
    private Button tyhja;
    @FXML
    private TextField trikkiAlue;
    @FXML
    private TextField MaaAlue;
    @FXML
    private ChoiceBox<Integer> trikkiValinta;
    @FXML
    private ChoiceBox<String> maaValinta;
    @FXML
    private RadioButton normaali;
    @FXML
    private ToggleGroup tuplaus;
    @FXML
    private RadioButton kahdenettu;
    @FXML
    private RadioButton vasta;
    @FXML
    private RadioButton vaaraton;
    @FXML
    private ToggleGroup vaara;
    @FXML
    private RadioButton vaarassa;
    @FXML
    private ChoiceBox<Integer> tulosTikki;
    @FXML
    private RadioButton tulosYli;
    @FXML
    private ToggleGroup tulos;
    @FXML
    private RadioButton tulosAli;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        String maa = (String) maaValinta.getValue();
        int trikki = (Integer) trikkiValinta.getValue();
        int tikki = (Integer) tulosTikki.getValue();
        String tulos = tulosValittu(event);
       
        Laskin laskin = new Laskin(maa,trikki,tikki,tulos);
        label.setText(laskin.toString());
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lataaMaat();
        lataaTrikit();
        lataaTulosTikit();
        
    }
    
    public String tulosValittu(ActionEvent event){
        String viesti = "";
        if(tulosAli.isSelected()){
            viesti += tulosAli.getText() + "\n";
        }if(tulosYli.isSelected()){
            viesti += tulosYli.getText() + "\n";
        }
        return viesti;
    }

    private void lataaMaat() {
        maat.removeAll(maat);
        String a = "Pata";
        String b = "Hertta";
        String c = "Ruutu";
        String d = "Risti";
        String e = "Valtiton";
        maat.addAll(a, b, c, d, e);
        maaValinta.getItems().addAll(maat);
    }

    private void lataaTrikit() {
        trikit.removeAll(trikit);
        int a = 1;
        int b = 2;
        int c = 3;
        int d = 4;
        int e = 5;
        int f = 6;
        int g = 7;
        trikit.addAll(a, b, c, d, e, f, g);
        trikkiValinta.getItems().addAll(trikit);

    }

    private void lataaTulosTikit() {
        tulosTikit.removeAll(trikit);
        int x = 0;
        int a = 1;
        int b = 2;
        int c = 3;
        int d = 4;
        int e = 5;
        int f = 6;
        int g = 7;
        tulosTikit.addAll(x, a, b, c, d, e, f, g);
        tulosTikki.getItems().addAll(tulosTikit);

    }
}
