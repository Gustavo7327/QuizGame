package quiz.game.quizgame.controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ResultController implements Initializable{

    @FXML
    private Button next;

    @FXML
    private Button restart;

    @FXML
    private Label result;
    
    @FXML
    private HBox buttonContainer;

    @FXML
    private ImageView imageContainer;

    private Parent root;
    private Stage stage;
    private Scene scene;

    private BufferedReader br;

    @FXML
    void nextQuestion(ActionEvent event) {
        loadScreen(event);
    }

    @FXML
    void restartQuiz(ActionEvent event) {
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/java/quiz/game/quizgame/controllers/control.csv"));
            String newValues = 0 + "," + 0 + "," + false;
            bw.write(newValues);
            bw.flush();
            bw.close();
            loadScreen(event);
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    private void loadScreen(ActionEvent event){
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
            int current = Integer.parseInt(params[0]);
            boolean correct = Boolean.parseBoolean(params[2]);
            if(correct){
                imageContainer.setImage(new Image(getClass().getResourceAsStream("/quiz/game/quizgame/resources/imgs/sabo.jpeg")));
                result.setText("Acertou! Pontuação: "+params[1]);  
            } 
            else{
                imageContainer.setImage(new Image(getClass().getResourceAsStream("/quiz/game/quizgame/resources/imgs/burro.jpeg")));
                result.setText("Errou! Pontuação: "+params[1]); 
            }  
            if (current == 12) {
                buttonContainer.getChildren().remove(next);
            }      
            br.close();
            animarImagem();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void animarImagem() {
        FadeTransition fadeTransition = new FadeTransition();
        fadeTransition.setNode(imageContainer);
        fadeTransition.setDuration(Duration.seconds(2.5)); 
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.play();
    }

}
