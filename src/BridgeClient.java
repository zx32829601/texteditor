
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.text.*;

public  class BridgeClient  implements ActionListener {

    JTextPane textPane;
    JMenu menuHighLighter;

    JMenuItem tmpMenuItem;
    RefindFontColor fontColor;
    RefindHighLighter highLighterColor;
    ImplementorColor yellow= new ConcreteImplementorYellow();
    ImplementorColor green = new ConcreteImplementorGreen();


    public BridgeClient(JTextPane jtextPane) {
        textPane = jtextPane;
        menuHighLighter = new JMenu("醒目提示");
        highLighterColor = new RefindHighLighter();
        fontColor = new RefindFontColor();
//        createItem();
    }

    StyleContext context = new StyleContext();
    StyledDocument document = new DefaultStyledDocument(context);

    //    public void createItem(){
//        addColor("黃色");
//        addColor("綠色");
//    }
    public void addColor(String newColor){
        tmpMenuItem = new JMenuItem(newColor);
        tmpMenuItem.addActionListener(this);
        menuHighLighter.add(tmpMenuItem);
    }
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        if (s.equals("黃色")) {
            highLighterColor.setColor(yellow.getColor());
            highLighterColor.highLighterColor(textPane);
        }else if(s.equals("綠色")){
            highLighterColor.setColor(green.getColor());
            highLighterColor.highLighterColor(textPane);

        }else if(s.equals("yello")){
            fontColor.setColor(yellow.getColor());
            fontColor.fontColor(textPane);

        }else if(s.equals("green")){
            fontColor.setColor(green.getColor());
            fontColor.fontColor(textPane);
        }
    }
}
