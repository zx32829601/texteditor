import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class WordCountListener implements DocumentListener {
    JLabel stateBar;

    public WordCountListener(JLabel jLabel) {

        stateBar = jLabel;


    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        recalculateWords(e);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        recalculateWords(e);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        recalculateWords(e);
    }

    public void recalculateWords(DocumentEvent e) {
        Document document = e.getDocument();
        int count = document.getLength();


        System.out.println(count);
        stateBar.setText("Characters:" + count);


    }
}
