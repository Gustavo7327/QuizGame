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

public class questionninecontroller implements Initializable{

    String resposta;
    String quest = "O Oganessônio foi alocado no grupo dos gases nobres. Com isso, muito se especulou se tal elemento apresentaria grande estabilidade, característica desse grupo. A alocação do Og no grupo 18 se deu por:";
    String correctquest = "c";

    String[] questionNineOptions = {
        "Esse elemento ser altamente estável.",
        "Esse elemento ter as mesmas propriedades químicas dos demais gases nobres.",
        "Esse elemento possuir oito elétrons em sua camada de valência.",
        "Esse elemento possuir uma alta energia de ionização."
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
        questionNine();
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
        //     System.out.println();
        //     FXMLLoader loader = new FXMLLoader(getClass().getResource("imageviewer.fxml")); 
        //     try {
        //         root = loader.load();
        //     } catch (IOException e) {
        //         e.printStackTrace();
        //     }
        //     stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        //     scene = new Scene(root);
        //     stage.setScene(scene);
        //     stage.show();
            
        // }   
             
     }

     public void questionNine(){
        labelpergunta.setText(quest);
        resposta1.setText(questionNineOptions[0]);
        resposta2.setText(questionNineOptions[1]);
        resposta3.setText(questionNineOptions[2]);
        resposta4.setText(questionNineOptions[3]);
    }
}

