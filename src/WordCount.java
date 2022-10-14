import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import java.awt.*;

public class WordCount extends JFrame implements DocumentListener {
    JLabel stateBar;

    public WordCount(){

        //狀態列
        stateBar=new JLabel("Characters:"+0);

        stateBar.setHorizontalAlignment(SwingConstants.LEFT);
        stateBar.setBorder(
                BorderFactory.createEtchedBorder()
        );

    }


    public void recalculateWords(DocumentEvent e) {
        Document doc=e.getDocument();

        int count=doc.getLength();
        System.out.println(count);
        stateBar.setText("Characters:"+count);



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
}
