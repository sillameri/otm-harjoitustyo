package bridgecalculator.ui;

import bridgecalculator.domain.GamePointsCalculator;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MainApp extends Application {

    private GamePointsCalculator gamePoints;
//    private FileBridgeCalculatorDao fileDao;

    @Override
    public void start(final Stage stage) throws Exception {

        startGame(stage);
    }

    private void startGame(final Stage stage) throws IOException {
        gamePoints = new GamePointsCalculator();

        FXMLLoader loader2 = new FXMLLoader();
        loader2.setLocation(getClass().getResource("/fxml/RoundPointsScene.fxml"));
        final Parent mainLayout2 = loader2.load();
        final RoundPointsSceneController rpsc = loader2.getController();

        FXMLLoader loader1 = new FXMLLoader();
        loader1.setLocation(getClass().getResource("/fxml/GamePointsScene.fxml"));
        final Parent mainLayout1 = loader1.load();
        final GamePointsSceneController gpsc = loader1.getController();
        gpsc.setGamePointsCalculator(gamePoints);

        gpsc.getBackButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.getScene().setRoot(mainLayout2);
                rpsc.clearWindow();
            }
        });

        rpsc.getBackButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.getScene().setRoot(mainLayout1);
                if (rpsc.getRoundPointsCalculator() != null) {
                    gamePoints.addrpc(rpsc.getRoundPointsCalculator());
                    gpsc.updatePoints();
                    gpsc.updateGame();
                }

            }
        });

        gpsc.getEndGameButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.close();

            }

        });

        gpsc.getReStartButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                restart(stage);

            }
        });

        Scene scene = new Scene(mainLayout1);
        scene.getStylesheets().add("/styles/Styles.css");
        stage.setTitle("Bridge Calculator");
        stage.setScene(scene);
        stage.show();
    }

    public void restart(Stage stage) {
        try {
            startGame(stage);
        } catch (IOException ex) {
            Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
