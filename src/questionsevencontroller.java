package src;

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
import javafx.stage.Stage;

public class questionsevencontroller implements Initializable{

    String resposta;
    String quest = "O Xenônio foi descoberto por William Ramsay e Morris Travers em 1898. Ramsay propôs o nome 'xenônio' derivado da palavra grega 'xenos' que significa:";
    String correctquest = "b";

    String[] questionSevenOptions = {
        "Oculto.",
        "Estranho ou convidado.",
        "Inativo.",
        "Novo."
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        questionSeven();
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
            } else {
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
            
        }   
             
     }

     public void questionSeven(){
        labelpergunta.setText(quest);
        resposta1.setText(questionSevenOptions[0]);
        resposta2.setText(questionSevenOptions[1]);
        resposta3.setText(questionSevenOptions[2]);
        resposta4.setText(questionSevenOptions[3]);
    }
}

