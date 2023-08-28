package src;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class FinalSceneController implements Initializable{

    @FXML
    private AnchorPane finalpane;

    @FXML
    private ImageView imageleftbottom;

    @FXML
    private ImageView imagelefttop;

    @FXML
    private ImageView imagerightbottom;

    @FXML
    private ImageView imagerighttop;

    @FXML
    private MediaView mediaviewer;

    @FXML
    private Button restartbutton;

    @FXML
    private Label scorelabel;

    private Parent root;
    private Stage stage;
    private Scene scene;
    int score;
    int perguntasRespondidas;
    boolean verification;
    String caminho;
    String directory;
    private FileWriter filetxt;

    Image pocao1 = new Image(getClass().getResourceAsStream("radiacao.png"));
    Image pocao2 = new Image(getClass().getResourceAsStream("pocoesvermelha.png"));
    Image pocao3 = new Image(getClass().getResourceAsStream("pocoescoloridas.png"));
    Image pocao4 = new Image(getClass().getResourceAsStream("variaspocoes.png"));

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        imageleftbottom.setImage(pocao1);
        imagelefttop.setImage(pocao2);
        imagerighttop.setImage(pocao3);
        imagerightbottom.setImage(pocao4);

        restartbutton.setStyle("-fx-background-color:white;");
        restartbutton.setStyle("-fx-text-fill:black;");
        finalpane.setStyle("-fx-background-color:rgb(11, 96, 192);");
        
        directory = System.getProperty("user.dir");
        caminho = directory + "/" + "src" + "/" + "perguntasRespondidas.csv";
        
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

        scorelabel.setText("Score: " + score);
    }


    @FXML
    void restartGame(ActionEvent event) {
        perguntasRespondidas = 0;
        score = 0;
        verification = false;

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

        FXMLLoader loader = new FXMLLoader(getClass().getResource("scene.fxml")); 
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

