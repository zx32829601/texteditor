import javax.swing.*;
import javax.swing.text.Document;

public class Originator {


    private String text;


    public Originator(String text) {
        this.text=text;
    }

    public void setText(String text) {
        this.text=text;
    }

    public String getText() {
        return  text;
    }

    public History createHistory() {
        return new History(text);

    }

    public void restoreHistory(History history) {
        this.text=history.getText();
    }
}
