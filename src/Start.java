package src;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Start implements Initializable{

    @FXML
    private Button startbutton;

    @FXML
    private AnchorPane panestart;

    @FXML
    private Label labelstart;
   
    @FXML
    private ImageView imagestart;

    @FXML
    private ImageView imagetwo;

    @FXML
    private ImageView imageone;
    
    @FXML
    private ImageView imagethree;
      
    @FXML
    private ImageView imagefour;

    private Parent root;
    private Stage stage;
    private Scene scene;
    private Media media;
    private MediaPlayer mediaplayer;
    private File file;
    
    Image imagemas = new Image(getClass().getResourceAsStream("masss.png"));
    Image image1 = new Image(getClass().getResourceAsStream("atmosferaatomica.png"));
    Image image2 = new Image(getClass().getResourceAsStream("pocaoesquentando.png"));
    Image image3 = new Image(getClass().getResourceAsStream("reacaoquimica.png"));
    Image image4 = new Image(getClass().getResourceAsStream("pocoes.png"));

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        imageone.setImage(image1);
        imagetwo.setImage(image2);
        imagethree.setImage(image3);
        imagefour.setImage(image4);

        labelstart.setStyle("-fx-text-fill:yellow;");
        panestart.setStyle("-fx-background-color:rgb(11, 96, 192);");
        startbutton.setStyle("-fx-background-color:white;");
        startbutton.setStyle("-fx-text-fill:black;");

        file = new File("src/pou.mp3");
        imagestart.setImage(imagemas);
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(labelstart);
        translate.setByX(293);
        translate.setDuration(Duration.millis(3000));
        translate.setCycleCount(1);
        translate.play();
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
    void startGame(ActionEvent event) throws IOException {
            System.out.println("funcionou");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("questiononescene.fxml")); 
            root = loader.load();
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
            mediaplayer.stop();
    }

}

