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
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class QuestionOneController implements Initializable{

    String resposta;

    String[] questions = {
        "Quantos elementos possuem os gases nobres e quais são eles?",

        "Em que ano o gás Hélio foi descoberto? Como ele foi descoberto?",

        "Qual o número atômico do Neônio e sua principal característica, respectivamente?",

        "Qual dessas aplicações não corresponde ao Argônio?",

        "Qual a principal característica dos Gases Nobres?",

        "Qual a utilidade do Criptônio em lasers?",

        "O Xenônio foi descoberto por William Ramsay e Morris Travers em 1898. Ramsay propôs o nome 'xenônio' derivado da palavra grega 'xenos' que significa:",

        "Certo isótopo do Radônio possui 86 prótons, 86 eletróns e número de massa 222, logo, o número atômico desse elemento é: ",

        "O Oganessônio foi alocado no grupo dos gases nobres. Com isso, muito se especulou se tal elemento apresentaria grande estabilidade, característica desse grupo. A alocação do Og no grupo 18 se deu por:",

        "Temos, abaixo, as configurações eletrônicas de alguns elementos no estado fundamental. A configuração eletrônica que corresponde a um gás nobre é: "
    };
    
    String[] responses = {
        "a",
        "b",
        "d",
        "a",
        "c",
        "b",
        "b",
        "d",
        "c",
        "a"
    };

    String[] questionOneOptions = {
        "7: Hélio, Neônio, Argônio, Criptônio, Xenônio, Radônio e Oganessônio.",
        "6: Hélio, Neônio, Argônio, Criptônio, Xenônio e Radônio.",
        "6: Hélio, Neônio, Argônio, Criptônio, Oganessônio e Radônio.",
        "7: Hélio, Neônio, Argônio, Criptônio, Radônio, Oganessônio e Urânio."
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
        questionOne();

        panequestion.setStyle("-fx-background-color:rgb(11, 96, 192);");
        labelpergunta.setStyle("-fx-text-fill:#00ff00");
        resposta1.setStyle("-fx-text-fill:#00ff00");
        resposta2.setStyle("-fx-text-fill:#00ff00");
        resposta3.setStyle("-fx-text-fill:#00ff00");
        resposta4.setStyle("-fx-text-fill:#00ff00");
        buttonverificar.setStyle("-fx-background-color:white;");
        buttonverificar.setStyle("-fx-text-fill:black;");


        //labelpergunta.setBackground(new Background(new BackgroundFill(Color.ORANGE, CornerRadii.EMPTY, Insets.EMPTY)));
        //resposta1.setBackground(new Background(new BackgroundFill(Color.ORANGE, CornerRadii.EMPTY, Insets.EMPTY)));
        //resposta2.setBackground(new Background(new BackgroundFill(Color.ORANGE, CornerRadii.EMPTY, Insets.EMPTY)));
        //resposta3.setBackground(new Background(new BackgroundFill(Color.ORANGE, CornerRadii.EMPTY, Insets.EMPTY)));
        //resposta4.setBackground(new Background(new BackgroundFill(Color.ORANGE, CornerRadii.EMPTY, Insets.EMPTY)));

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

        if(resposta.equals(responses[0])){
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

    public void questionOne(){
        labelpergunta.setText(questions[0]);
        resposta1.setText(questionOneOptions[0]);
        resposta2.setText(questionOneOptions[1]);
        resposta3.setText(questionOneOptions[2]);
        resposta4.setText(questionOneOptions[3]);
    }

}