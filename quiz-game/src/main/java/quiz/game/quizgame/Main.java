package quiz.game.quizgame;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class Main extends Application{
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("fxmls/Menu.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Quiz Game");
        stage.setResizable(false);
        stage.show();
        stage.setOnCloseRequest(event -> {
            event.consume();
            logout(stage);
        });
    }

    public void logout(Stage stage){

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to logout!");
        alert.setContentText("Are you sure you want to leave?");

        if(alert.showAndWait().get() == ButtonType.OK){
            int current = 0;
            int score = 0;
            boolean verification = false;

            try{
                BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/java/quiz/game/quizgame/controllers/control.csv"));    
                String newValues = current + "," + score + "," + verification;
                bw.write(newValues);
                bw.flush();
                bw.close(); 

        }catch(IOException e){
            e.printStackTrace();
        }
            stage.close();
        }
    }
}
