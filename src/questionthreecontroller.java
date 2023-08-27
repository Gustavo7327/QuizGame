package src;

import java.io.File;
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

public class questionthreecontroller implements Initializable{

    String resposta;
    String quest = "Qual o número atômico do Neônio e sua principal característica, respectivamente?";
    String correctquest = "d";

    String[] questionThreeOptions = {
        "Número atômico 2, tem uma densidade menor que o ar e é mais leve que o ar.",
        "Número atômico 36, é mais denso que o ar e é considerado um gás pesado.",
        "Número atômico 54, quando submetido a uma descarga elétrica, emite um brilho azul característico.",
        "Número atômico 10, a emissão de uma luz brilhante quando submetido a uma corrente elétrica."
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        questionThree();
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
        if(resposta.equals(correctquest)){
            System.out.println();
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
            } //else {
            // System.out.println();
            // FXMLLoader loader = new FXMLLoader(getClass().getResource("imageviewer.fxml")); 
            // try {
            //     root = loader.load();
            // } catch (IOException e) {
            //     e.printStackTrace();
            // }
            // stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            // scene = new Scene(root);
            // stage.setScene(scene);
            // stage.show();
            
        //}   
             
     }

     public void questionThree(){
        labelpergunta.setText(quest);
        resposta1.setText(questionThreeOptions[0]);
        resposta2.setText(questionThreeOptions[1]);
        resposta3.setText(questionThreeOptions[2]);
        resposta4.setText(questionThreeOptions[3]);
    }
}

