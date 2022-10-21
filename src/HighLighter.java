
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.text.*;

public  class HighLighter implements ActionListener {

    JTextPane textPane;
    JMenu menuHighLighter;
    JMenuItem yellow,orange,green;
    JMenuItem tmpMenuItem;

    public HighLighter(JTextPane jtextPane) {
        textPane = jtextPane;
        menuHighLighter = new JMenu("醒目提示");
        createItem();
    }

    StyleContext context = new StyleContext();
    StyledDocument document = new DefaultStyledDocument(context);

public void createItem(){
    addColor("黃色");
    addColor("橘色");
    addColor("綠色");
}
    public void addColor(String newColor){
        tmpMenuItem = new JMenuItem(newColor);
        tmpMenuItem.addActionListener(this);
        menuHighLighter.add(tmpMenuItem);
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