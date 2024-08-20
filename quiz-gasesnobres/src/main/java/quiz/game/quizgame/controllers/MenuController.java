package quiz.game.quizgame.controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MenuController implements Initializable{

    private Parent root;
    private Scene scene;
    private Stage stage;
    private MediaPlayer mp;
    private Media media;
    private File file;

    @FXML
    private AnchorPane menu;

    @FXML
    private Button start;

    @FXML
    private Text title;

    @FXML
    void startGame(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("../fxmls/Quiz.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        mp.dispose();
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        file = new File("src/main/java/quiz/game/quizgame/resources/audios/omfg.mp3");
        media = new Media(file.toURI().toString());
        mp = new MediaPlayer(media);
        mp.play();

        TranslateTransition tt = new TranslateTransition();
        tt.setNode(title);
        tt.setByX(716);
        tt.setDuration(Duration.millis(3000));
        tt.setCycleCount(1);
        tt.play();
    }

}
