package quiz.game.quizgame.entity;

public class Option {
    private String text;
    
    public Option(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
