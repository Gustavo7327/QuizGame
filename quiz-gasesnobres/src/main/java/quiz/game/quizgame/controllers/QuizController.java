package quiz.game.quizgame.controllers;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public class QuizController implements Initializable{

    @FXML
    private ToggleGroup op;

    @FXML
    private RadioButton option1;

    @FXML
    private RadioButton option2;

    @FXML
    private RadioButton option3;

    @FXML
    private RadioButton option4;

    @FXML
    private Label question;

    @FXML
    private AnchorPane quiz;

    @FXML
    private Button responder;

    @FXML
    private Label timer;

    @FXML
    private VBox options;

    private MediaPlayer mp;
    private Media media;
    private File file;


    @FXML
    void verificar(ActionEvent event) {
        mp.dispose();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        file = new File("src/main/java/quiz/game/quizgame/resources/audios/LThemePianoCover.mp3");
        media = new Media(file.toURI().toString());
        mp = new MediaPlayer(media);
        mp.play();

        String text = "texto muto grande texto muito grande texto muto grande texto muito grande texto muto grande texto muito grande texto muto grande texto muito grande texto muto grande texto muito grande texto muto grande texto muito grande";

        Timeline timeline = new Timeline();

        int durationPerChar = 30; 
        for (int i = 0; i <= text.length(); i++) {
            final String subString = text.substring(0, i);
            KeyFrame keyFrame = new KeyFrame(Duration.millis(i * durationPerChar),
                    event -> question.setText(subString));
            timeline.getKeyFrames().add(keyFrame);
        }

        Timeline tlOptions = new Timeline();
        for(int i = 0; i < 4; i++){

            HBox option = (HBox) options.getChildren().get(i);

            KeyFrame kf = new KeyFrame(Duration.millis(i*300), event -> {
                FadeTransition transition = new FadeTransition(Duration.millis(500), option);
                transition.setFromValue(0);
                transition.setToValue(1);
                transition.play();
            });
            tlOptions.getKeyFrames().add(kf);
        }

        timeline.play();
        timeline.setOnFinished(event -> tlOptions.play());

    }

}
