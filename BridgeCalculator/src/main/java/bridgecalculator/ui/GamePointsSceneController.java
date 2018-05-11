/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bridgecalculator.ui;

import bridgecalculator.dao.FileBridgeCalculatorDao;
import bridgecalculator.domain.GamePointsCalculator;
import bridgecalculator.domain.Result;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
    private FileBridgeCalculatorDao fileDao;

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
    @FXML
    private Button moveToRoundPoints;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        overLineVBox = new VBox();
        ScrollPane scroll = new ScrollPane(overLineVBox);
        vbox.getChildren().add(scroll);

        underLineVBox = createUnderLine();
        vbox.getChildren().add(underLineVBox);
        save.setDisable(true);

    }

    public void setGamePointsCalculator(GamePointsCalculator gamePoints) {
        this.gamePoints = gamePoints;
    }

    public Button getBackButton() {
        return this.moveToRoundPoints;
    }

    public Button getEndGameButton() {
        return this.exit;
    }

    public Button getReStartButton() {
        return this.restart;
    }

    @FXML
    private void handleHighscoreAction(ActionEvent event) {
        try {
            Stage dialog = new Stage();
            dialog.initModality(Modality.APPLICATION_MODAL);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/HighScoreScene.fxml"));
            final Parent mainLayout = loader.load();
            final HighScoreSceneController controller = loader.getController();

            controller.getCloseGameButton().setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    dialog.close();
                }
            });

            Scene scene = new Scene(mainLayout);
            scene.getStylesheets().add("/styles/Styles.css");
            dialog.setTitle("Bridge Calculator");
            dialog.setScene(scene);
            dialog.show();
        } catch (IOException ex) {
            Logger.getLogger(GamePointsSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handleSaveAction(ActionEvent event) throws Exception {

        Result result = new Result(gamePoints.getTotalPoints("ns", "ew"), gamePoints.getTotalPoints("ew", "ns"));
        fileDao = new FileBridgeCalculatorDao("data.txt");
        fileDao.save(result);

    }


    public void addUpdatedPoints() {

        gamePoints.updateSumNsPoints();
        gamePoints.updateSumEwPoints();

        addItemOverLine();
        addItemUnderLine();

        totalPointsNs.setText("" + gamePoints.getTotalPoints("ns", "ew"));
        totalPointsEw.setText("" + gamePoints.getTotalPoints("ew", "ns"));

        if (gamePoints.getUnderLine("ew") >= 100 || gamePoints.getUnderLine("ns") >= 100) {

            underLineVBox = createUnderLine();
            gamePoints.setCurrentGame(++game);
        }

    }

    public void addGameOverInfo() {
        save.setDisable(gamePoints.gameGoing());
        moveToRoundPoints.setDisable(!gamePoints.gameGoing());

        if (gamePoints.gameGoing() == false) {
            infoLabel.setText("Peli loppui!");
        }
    }
    
    
    private void addItemOverLine() {
        HBox overLineItem = new HBox();
        overLineItem.setSpacing(60);

        Label nsLabel = new Label(gamePoints.getOverLine("ns"));
        Label ewLabel = new Label(gamePoints.getOverLine("ew"));

        Separator sep = new Separator();
        sep.setOrientation(Orientation.VERTICAL);

        overLineItem.getChildren().addAll(nsLabel, sep, ewLabel);

        overLineVBox.getChildren().add(0, overLineItem);
        nOverLine++;
    }

    private void addItemUnderLine() {
        HBox underLineItem = new HBox();
        underLineItem.setSpacing(60);

        Label nsLabel = new Label(gamePoints.getUnderLineString("ns"));
        Label ewLabel = new Label(gamePoints.getUnderLineString("ew"));

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

}
