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

    private Random random = new Random();

    String[] people = {
        "Allicia",
        "Ana Grazielly",
        "Anahellen",
        "André Vasco",
        "Mateus",
        "Gustavo(Augusto)",
        "Daniel",
        "Davi",
        "Emilly Izabely",
        "Emilly Vitoria",
        "Erick Maycon",
        "Alyson",
        "Junior",
        "Gabriella",
        "Gianne Karine",
        "Guilherme",
        "Isabelle",
        "Jamilly",
        "Jose italo",
        "Joyce",
        "Julio Cesar",
        "Kaua Rodrigues",
        "Pikao",
        "Diogo",
        "Beatriz",
        "Bianca",
        "Gloria",
        "Eduarda Silva",
        "Eduarda Lopes",
        "Maria Luisa",
        "Mario",
        "Miguel",
        "Murilo",
        "Nicollas",
        "Pedro Italo",
        "Pedro Lucas",
        "Vinicius",
        "Washington",
        "Willian"
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
         
        imageverification.setImage(image);
        for(int i = 0; i < 39; i++){
            int lucky = random.nextInt(39);
            labelname.setText(people[lucky]);
            System.out.println(lucky);
            try {
                Thread.sleep(90);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    void nextQuestion(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("questiontwoscene.fxml")); 
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

