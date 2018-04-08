package com.mycompany.bridgepointcalculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLController implements Initializable {
    
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
    private void handleButtonAction(ActionEvent event) {
       int x = Integer.parseInt(trikkiAlue.getText());
       int y = Integer.parseInt(MaaAlue.getText());
       
       String tulos = String.valueOf(x+y);
        label.setText("Tulos on " + tulos);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
