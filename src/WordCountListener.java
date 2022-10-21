import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;

public class WordCountListener implements DocumentListener {
    JTextPane textPane;
    static JLabel stateBar;
    public WordCountListener(JTextPane textPane){
    this.textPane=textPane;
        createWordCount();


    }
    public void createWordCount(){
        stateBar = new JLabel("Characters:" + 0);
        stateBar.setHorizontalAlignment(SwingConstants.LEFT);
        textPane.getDocument().addDocumentListener(this);

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
        Document document=e.getDocument();
        int count=document.getLength();


        System.out.println(count);
        stateBar.setText("Characters:"+count);



    }
}
