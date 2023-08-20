package src;

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
import javafx.stage.Stage;
import javafx.util.Duration;

public class start implements Initializable{

    @FXML
    private Button startbutton;

    @FXML
    private AnchorPane panestart;

    @FXML
    private Label labelstart;
   
    @FXML
    private ImageView imagestart;

    private Parent root;
    private Stage stage;
    private Scene scene;

    Image image = new Image(getClass().getResourceAsStream("mas.jpg"));

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        imagestart.setImage(image);
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(labelstart);
        translate.setByX(293);
        translate.setDuration(Duration.millis(3000));
        translate.setCycleCount(1);
        translate.play();
    }
    
    @FXML
    void startGame(ActionEvent event) throws IOException {
            System.out.println("funcionou");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("questionsscene.fxml")); 
            root = loader.load();
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }

    

}

