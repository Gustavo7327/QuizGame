package src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

public class QuestionFiveController implements Initializable{

    String resposta;
    String quest = "Qual a principal característica dos Gases Nobres?";
    String correctquest = "c";

    String[] questionFiveOptions = {
        "Precisam associar-se a outro elemento para ficar estável.",
        "Pertencem ao grupo 17 da tabela periódica.",
        "Possuem baixa reatividade química, devido à sua camada externa de valência completa.",
        "O Hélio é o único que não possue 8 életrons em sua camada de valência."
    };

    @FXML
    private Button buttonverificar;

    @FXML
    private Label labelpergunta;

    @FXML
    private AnchorPane panequestion;

    @FXML
    private RadioButton resposta1;

    @FXML
    private RadioButton resposta2;

    @FXML
    private RadioButton resposta3;

    @FXML
    private RadioButton resposta4;

    private Parent root;
    private Stage stage;
    private Scene scene;
    private MediaPlayer mediaplayer;
    private Media media;
    private File file;
    private FileWriter filetxt;
    int perguntasRespondidas;
    int score;
    boolean verification;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        questionFive();
        panequestion.setStyle("-fx-background-color:rgb(11, 96, 192);");
        labelpergunta.setStyle("-fx-text-fill:#00ff00");
        resposta1.setStyle("-fx-text-fill:#00ff00");
        resposta2.setStyle("-fx-text-fill:#00ff00");
        resposta3.setStyle("-fx-text-fill:#00ff00");
        resposta4.setStyle("-fx-text-fill:#00ff00");
        buttonverificar.setStyle("-fx-background-color:white;");
        buttonverificar.setStyle("-fx-text-fill:black;");
        
        file = new File("src/LThemePianoCover.mp3");
        media = new Media(file.toURI().toString());
        mediaplayer = new MediaPlayer(media);
        mediaplayer.setOnEndOfMedia(new Runnable(){
            @Override
            public void run(){
                mediaplayer.seek(Duration.ZERO);
                mediaplayer.play();
            }
         });
         mediaplayer.play();
    }

    @FXML
    void displayoptions(ActionEvent event) {
        if(resposta1.isSelected()){
            resposta = "a";
        }
        else if(resposta2.isSelected()){
            resposta = "b";
        }
        else if(resposta3.isSelected()){
            resposta = "c";
        }
        else if(resposta4.isSelected()){
            resposta = "d";
        }
    }

    @FXML
    void verificar(ActionEvent event) {
        String directory = System.getProperty("user.dir");
        String caminho = directory + "/" + "src" + "/" + "perguntasRespondidas.csv";
        
        try{
            BufferedReader bfr = new BufferedReader(new FileReader(caminho));
            String line;
            while((line = bfr.readLine()) != null){
                String[] nums = line.split(",");

                perguntasRespondidas = Integer.parseInt(nums[0]);

                score = Integer.parseInt(nums[1]);

                verification = Boolean.parseBoolean(nums[2]);
            }
            bfr.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }

        if(resposta.equals(correctquest)){
            score++;
            verification = true;
        } else{
            verification = false;
        } 

        perguntasRespondidas++;
        try{
            filetxt = new FileWriter(caminho);
            BufferedWriter bfw = new BufferedWriter(filetxt);
            String newValues = perguntasRespondidas + "," + score + "," + verification;
            bfw.write(newValues);
            bfw.flush();
            bfw.close();

        }catch(IOException e){
            e.printStackTrace();
        }
           
        FXMLLoader loader = new FXMLLoader(getClass().getResource("imageviewer.fxml")); 
            try {
                root = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            mediaplayer.stop();

     }

     public void questionFive(){
        labelpergunta.setText(quest);
        resposta1.setText(questionFiveOptions[0]);
        resposta2.setText(questionFiveOptions[1]);
        resposta3.setText(questionFiveOptions[2]);
        resposta4.setText(questionFiveOptions[3]);
    }
}
