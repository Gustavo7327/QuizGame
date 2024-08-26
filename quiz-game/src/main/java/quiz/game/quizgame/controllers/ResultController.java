package quiz.game.quizgame.controllers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ResultController implements Initializable{

    @FXML
    private Button next;

    @FXML
    private Label result;

    private Parent root;
    private Stage stage;
    private Scene scene;

    private BufferedReader br;

    @FXML
    void nextQuestion(ActionEvent event) {
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            br = new BufferedReader(new FileReader("src/main/java/quiz/game/quizgame/controllers/control.csv"));
            String line = br.readLine();
            String[] params = line.split(",");
            boolean correct = Boolean.parseBoolean(params[2]);
            if(correct) result.setText("Acertou");  
            else result.setText("Errou");        
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
