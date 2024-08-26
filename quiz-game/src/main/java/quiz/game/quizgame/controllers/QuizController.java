package quiz.game.quizgame.controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import quiz.game.quizgame.entity.Question;
import quiz.game.quizgame.entity.QuestionList;

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

    private Parent root;
    private Stage stage;
    private Scene scene;

    private MediaPlayer mp;
    private Media media;
    private File file;

    private Thread timerThread;
    private int time = 30;
    private int current;
    private int correct;
    private int score;
    private boolean verification;

    private BufferedReader br;
    private BufferedWriter bw;

    QuestionList list = new QuestionList();
    Question quest = null;

    @FXML
    void verificar(ActionEvent event) {
        if(timerThread != null){
            timerThread.interrupt();
            System.out.println("chegou aqui");
        }

        if(option1.isSelected()) correct = 1;
        else if(option2.isSelected()) correct = 2;
        else if(option3.isSelected()) correct = 3;
        else if(option4.isSelected()) correct = 4;
        else correct = 0;

        try {
            br = new BufferedReader(new FileReader("src/main/java/quiz/game/quizgame/controllers/control.csv"));
            String line = br.readLine();

            String[] params = line.split(",");
            current = Integer.parseInt(params[0]);
            score = Integer.parseInt(params[1]);
            verification = Boolean.parseBoolean(params[2]);

            if(correct == quest.getCorrect()){
                score++;
                verification = true;
            }
            else{
                verification = false;
            }
            current++;

            bw = new BufferedWriter(new FileWriter("src/main/java/quiz/game/quizgame/controllers/control.csv"));    
            String newValues = current + "," + score + "," + verification;
            bw.write(newValues);
            bw.flush();
            bw.close(); 
            br.close();   

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            root = FXMLLoader.load(getClass().getResource("../fxmls/Result.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        mp.dispose();
        stage.show();

        mp.dispose();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        file = new File("src/main/java/quiz/game/quizgame/resources/audios/LThemePianoCover.mp3");
        media = new Media(file.toURI().toString());
        mp = new MediaPlayer(media);
        mp.play();

        try {
            br = new BufferedReader(new FileReader("src/main/java/quiz/game/quizgame/controllers/control.csv"));
            String line = br.readLine();
            String[] params = line.split(",");
            current = Integer.parseInt(params[0]);
            quest = list.questions.get(current);           
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String text = quest.getQuestion();
        option1.setText(quest.getOptions().get(0).getText());
        option2.setText(quest.getOptions().get(1).getText());
        option3.setText(quest.getOptions().get(2).getText());
        option4.setText(quest.getOptions().get(3).getText());


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

        timerThread = new Thread(() -> {
            while (time > 0 && !timerThread.isInterrupted()) {
                try{
                    Thread.sleep(1000);
                    Platform.runLater(() -> {
                        time--;
                        timer.setText(String.valueOf(time));
                        if(time <= 0){
                            System.out.println("Foi");
                            timerThread.interrupt();
                        }
                    });
                } 
                catch(InterruptedException e){
                    e.printStackTrace();
                    break;
                }
            }
        });

        timeline.play();
        timeline.setOnFinished(event -> tlOptions.play());
        tlOptions.setOnFinished(event -> {
            timerThread.start();
            responder.setDisable(false);
        });
        
    }

}
