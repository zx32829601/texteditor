
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.text.*;

public  class HighLighter implements ActionListener {

    JTextPane textPane;
    JMenuItem yellow,orange,green;

    public HighLighter(JTextPane jtextPane) {
        textPane = jtextPane;
        createItem();
    }

    StyleContext context = new StyleContext();
    StyledDocument document = new DefaultStyledDocument(context);

public void createItem(){
    yellow = new JMenuItem("黃色");
    orange = new JMenuItem("橘色");
    green = new JMenuItem("綠色");
    yellow.addActionListener(this);
    orange.addActionListener(this);
    green.addActionListener(this);
}
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