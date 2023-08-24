package src;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
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
import javafx.stage.Stage;

public class imagecontroller implements Initializable{

    Random random = new Random();

    String[] people = {

    };

    private Parent root;
    private Stage stage;
    private Scene scene;

    @FXML
    private Button buttonimage;

    @FXML
    private ImageView imageverification;

    @FXML
    private Label labelname;

    @FXML
    private Label msglabel;

    @FXML
    private AnchorPane paneimage;

    Image image = new Image(getClass().getResourceAsStream("sabomuito.jpg"));
    Image image2 = new Image(getClass().getResourceAsStream("mas.jpg"));
    questionscontroller questionscontroller = new questionscontroller();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
         
         if(questionscontroller.questionone == true){
         imageverification.setImage(image);
         } else{
            imageverification.setImage(image2);
         }
    }

    @FXML
    void nextQuestion(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("questionsscene.fxml")); 
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

