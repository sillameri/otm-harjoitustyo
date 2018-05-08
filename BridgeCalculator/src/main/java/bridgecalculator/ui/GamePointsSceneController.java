/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bridgecalculator.ui;

import bridgecalculator.domain.GamePointsCalculator;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

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
    private VBox vbox;
    private VBox overLineVBox;
    private VBox underLineVBox;
    private int game = 0;

    private int nOverLine = 0;
    private int nUnderLine = 0;
    @FXML
    private Button exit;
    @FXML
    private Button restart;
    @FXML
    private Button highscore;
    @FXML
    private Button save;
    @FXML
    private Label totalPointsNs;
    @FXML
    private Label totalPointsEw;
    @FXML
    private Label infoLabel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        overLineVBox = new VBox();
        ScrollPane scroll = new ScrollPane(overLineVBox);
        vbox.getChildren().add(scroll);

        underLineVBox = createUnderLine();
        vbox.getChildren().add(underLineVBox);

    }

    public void setGamePointsCalculator(GamePointsCalculator gamePoints) {
        this.gamePoints = gamePoints;
    }

    public Button getBackButton() {
        return this.siirry;
    }
    
    public Button getEndGameButton(){
        return this.exit;
    }

    public void updatePoints() {
        gamePoints.updateSumNsPoints();
        gamePoints.updateSumEwPoints();

        addItemOverLine();
        addItemUnderLine();

        totalPointsNs.setText("" + gamePoints.getTotalPoints("ns"));
        totalPointsEw.setText("" + gamePoints.getTotalPoints("ew"));
       
        if (gamePoints.getUnderLineEw() >= 100 || gamePoints.getUnderLineNs() >= 100) {

            underLineVBox = createUnderLine();
            gamePoints.setCurrentGame(++game);
        }
    }

    private void winnerPopUp(String winner, int pointsNs, int pointsEw) {
        try {
            Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/EndGameScene.fxml"));
            final Parent mainLayout = loader.load();
            final EndGameSceneController controller = loader.getController();
            controller.setWinner(winner);
            controller.setPointsNs(pointsNs);
            controller.setPointsEw(pointsEw);

            Scene scene = new Scene(mainLayout);
            scene.getStylesheets().add("/styles/Styles.css");
            dialog.setTitle("Bridge Calculator");
            dialog.setScene(scene);
            dialog.show();
        } catch (IOException ex) {
            Logger.getLogger(GamePointsSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void addItemOverLine() {
        HBox overLineItem = new HBox();
        overLineItem.setSpacing(50);

        Label nsLabel = new Label(gamePoints.getOverLineNs());
        Label ewLabel = new Label(gamePoints.getOverLineEw());

        Separator sep = new Separator();
        sep.setOrientation(Orientation.VERTICAL);

        overLineItem.getChildren().addAll(nsLabel, sep, ewLabel);

        overLineItem.setHgrow(nsLabel, Priority.ALWAYS);
        overLineItem.setHgrow(ewLabel, Priority.ALWAYS);
        overLineItem.setHgrow(sep, Priority.ALWAYS);

        overLineVBox.getChildren().add(0, overLineItem);
        nOverLine++;
    }

    private void addItemUnderLine() {
        HBox underLineItem = new HBox();
        underLineItem.setSpacing(50);

        Label nsLabel = new Label("" + gamePoints.getUnderLineNs());
        Label ewLabel = new Label("" + gamePoints.getUnderLineEw());

        Separator sep = new Separator();
        sep.setOrientation(Orientation.VERTICAL);

        underLineItem.getChildren().addAll(nsLabel, sep, ewLabel);

        underLineVBox.getChildren().add(underLineItem);
        nUnderLine++;
    }

    private VBox createUnderLine() {
        VBox container = new VBox();
        container.setPadding(new Insets(10, 0, 0, 0));
        container.getChildren().add(new Separator());

        VBox underLineBox = new VBox();
        ScrollPane scroll = new ScrollPane(underLineBox);
        scroll.setStyle("-fx-background-color:transparent;");
        container.getChildren().add(scroll);

        vbox.getChildren().add(container);

        return underLineBox;
    }

    @FXML
    private void handleExitAction(ActionEvent event) {
    }

    @FXML
    private void handleRestartAction(ActionEvent event) {
    }

    @FXML
    private void handleHighscoreAction(ActionEvent event) {
        winnerPopUp("ns", 0, 0);
    }

    @FXML
    private void handleSaveAction(ActionEvent event) {
    }

}
