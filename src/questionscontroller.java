package src;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;

public class questionscontroller implements Initializable{

    String resposta;
    // String respostaOne;
    // String respostaTwo;
    // String respostaThree;
    // String respostaFour;
    // String respostaFive;
    // String respostaSix;
    // String respostaSeven;
    // String respostaEight;
    // String respostaNine;
    // String respostaTen;

    int score;

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

    String[] questionTwoOptions = {
        "Foi descoberto em 1898 a partir da destilação fracionada do ar líquido.",
        "Foi descoberto em 1868 durante um estudo do eclipse solar.",
        "Foi descoberto em 1894 durante um estudo sobre o nitrogênio atmosférico.",
        "Foi descoberto em 1898 durante um estudo do resíduo deixado após a destilação do ar líquido."
    };

    String[] questionThreeOptions = {
        "Número atômico 2, tem uma densidade menor que o ar e é mais leve que o ar.",
        "Número atômico 36, é mais denso que o ar e é considerado um gás pesado.",
        "Número atômico 54, quando submetido a uma descarga elétrica, emite um brilho azul característico.",
        "Número atômico 10, a emissão de uma luz brilhante quando submetido a uma corrente elétrica."
    };

    String[] questionFourOptions = {
        "Criogenia.",
        "Indústria de iluminação.",
        "Indústria de refrigeração.",
        "Medicina."
    };

    String[] questionFiveOptions = {
        "Precisam associar-se a outro elemento para ficar estável.",
        "Pertencem ao grupo 17 da tabela periódica.",
        "Possuem baixa reatividade química, devido à sua camada externa de valência completa.",
        "O Hélio é o único que não possue 8 életrons em sua camada de valência."
    };

    String[] questionSixOptions = {
        "É usado em experimentos científicos e análises espectroscópicas.",
        "Quando energizado por uma descarga elétrica, o criptônio emite uma luz coerente em uma determinada frequência.",
        "Quando adicionado a uma lâmpada incandescente, aumenta a eficiência e prolonga sua vida útil.",
        "É capaz de fornecer temperaturas extremamente baixas."
    };

    String[] questionSevenOptions = {
        "Oculto.",
        "Estranho ou convidado.",
        "Inativo.",
        "Novo."
    };

    String[] questionEightOptions = {
        "Nenhuma das Alternativas.",
        "136.",
        "222.",
        "86."
    };

    String[] questionNineOptions = {
        "Esse elemento ser altamente estável.",
        "Esse elemento ter as mesmas propriedades químicas dos demais gases nobres.",
        "Esse elemento possuir oito elétrons em sua camada de valência.",
        "Esse elemento possuir uma alta energia de ionização."
    };

    String[] questionTenOptions = {
        "1s2 2s2 2p6 3s2 3p6.",
        "1s2 2s2 2p6 3s2 3p2.",
        "1s2 2s2 2p6 3s2 3p3.",
        "1s2 2s2 2p6 3s2 3p6 4s2."
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        questionOne();
    }

    @FXML
    void displayoptions(ActionEvent event) {
        if(resposta1.isSelected()){
            //respostaOne = "a";
            resposta = "a";
        }
        else if(resposta2.isSelected()){
            //respostaOne = "b";
            resposta = "b";
        }
        else if(resposta3.isSelected()){
            //respostaOne = "c";
            resposta = "c";
        }
        else if(resposta4.isSelected()){
            //respostaOne = "d";
            resposta = "d";
        }
    }

    @FXML
    void verificar(ActionEvent event) {
        if(resposta.equals(responses[0])){
            score++;
            System.out.println(score);
            questionTwo();
        } else{
            System.out.println(score);
            score += 0;
            questionTwo();
        }
    }

    public void questionOne(){

        labelpergunta.setText(questions[0]);
        resposta1.setText(questionOneOptions[0]);
        resposta2.setText(questionOneOptions[1]);
        resposta3.setText(questionOneOptions[2]);
        resposta4.setText(questionOneOptions[3]);
       
    }

    public void questionTwo(){
        labelpergunta.setText(questions[1]);
        resposta1.setText(questionTwoOptions[0]);
        resposta2.setText(questionTwoOptions[1]);
        resposta3.setText(questionTwoOptions[2]);
        resposta4.setText(questionTwoOptions[3]);
        if(resposta.equals(responses[1])){
            score++;
            System.out.println(score);
        } else{
            score += 0;
            System.out.println(score);
        }
    }
        
    public void questionThree(){

    }

    public void questionFour(){
        
    }

    public void questionFive(){
        
    }

    public void questionSix(){
        
    }

    public void questionSeven(){
        
    }

    public void questionEight(){
        
    }

    public void questionNine(){
        
    }

    public void questionTen(){
        
    }

}