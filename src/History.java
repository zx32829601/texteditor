import javax.print.Doc;
import javax.swing.*;
import javax.swing.text.Document;

public class History {


    private String text;
    private JTextPane textPane;

    public History(String text) {
        this.text = text;
    }

    public String  getText() {
        return text;
    }
}
