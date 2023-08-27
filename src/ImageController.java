package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class ImageController implements Initializable{

    private Random random = new Random();

    String[] people = {
        "Allicia",
        "Ana Grazielly",
        "Anahellen",
        "André Vasco",
        "Mateus",
        "Gustavo",
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
    private Button buttonluck;

    @FXML
    private Label msglabel;

    @FXML
    private AnchorPane paneimage;

    private Media media;
    private MediaPlayer mediaplayer;
    private File file;
    int score;
    int perguntasRespondidas;
    boolean verification;

    Image image = new Image(getClass().getResourceAsStream("sabomuito.jpg"));
    Image image2 = new Image(getClass().getResourceAsStream("Perdi.png"));

    @Override
    public void initialize(URL location, ResourceBundle resources) {

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

        if(verification == true){
            imageverification.setImage(image);
            file = new File("src/breakingbadtheme.mp3");
            media = new Media(file.toURI().toString());
            mediaplayer = new MediaPlayer(media);
            mediaplayer.play();
        }
        else if(verification == false){
            imageverification.setImage(image2);
            file = new File("src/supermariogameover.mp3");
            media = new Media(file.toURI().toString());
            mediaplayer = new MediaPlayer(media);
            mediaplayer.play();
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
            mediaplayer.stop();
    }

    @FXML
    void sortear(ActionEvent event){
        
        for(int i = 0; i < 39; i++){
            int lucky = random.nextInt(39);
            labelname.setText(people[lucky]);
            System.out.println(lucky);
            System.out.println(people[lucky]);
            try {
                Thread.sleep(80);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

