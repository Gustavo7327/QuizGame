package quiz.game.quizgame.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MenuController {

    private Parent root;
    private Scene scene;
    private Stage stage;

    @FXML
    private AnchorPane menu;

    @FXML
    private Button start;

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
        stage.show();

    }

}
