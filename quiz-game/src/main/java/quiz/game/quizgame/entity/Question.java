package quiz.game.quizgame.entity;

import java.util.List;

public class Question { 
    private String question;
    private int correct;
    private List<Option> options;
    
    public Question(String question, int correct, List<Option> options) {
        this.question = question;
        this.correct = correct;
        this.options = options;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(char correct) {
        this.correct = correct;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }
}
