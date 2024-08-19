package quiz.game.quizgame.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

public class QuizController {

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
    void verificar(ActionEvent event) {

    }

}
