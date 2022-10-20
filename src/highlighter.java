
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextPane;
import javax.swing.text.*;

public  class highlighter implements ActionListener {

    JTextPane textPane;

    public highlighter(JTextPane jtextPane) {
        textPane = jtextPane;
    }

    StyleContext context = new StyleContext();
    StyledDocument document = new DefaultStyledDocument(context);


    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("黃色")) {
            MutableAttributeSet attr = new SimpleAttributeSet();
            StyleConstants.setBackground(attr, Color.yellow);
            FontEdit.setCharacterAttributes(textPane, attr, false);

        }else if(s.equals("綠色")){
            MutableAttributeSet attr = new SimpleAttributeSet();
            StyleConstants.setBackground(attr, Color.green);
            FontEdit.setCharacterAttributes(textPane, attr, false);
        }else if(s.equals("橘色")){
            MutableAttributeSet attr = new SimpleAttributeSet();
            StyleConstants.setBackground(attr, Color.orange);
            FontEdit.setCharacterAttributes(textPane, attr, false);
        }

    }
}