import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window_change extends FontEdit implements ActionListener{

    UI co;

    public Window_change(UI co) {
        super(new JTextPane());
        this.co = co;
    }
    public void setWindowsBackground(Color c){
        //co.setBackground(c);
        co.textPane.setBackground(c);
        co.menuBar.setBackground(c);
    }
    public void setTextColor(Color c){

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if(s.equals("一般模式")){
            setWindowsBackground(Color.lightGray);
            MutableAttributeSet blue_Attr = new SimpleAttributeSet();
            StyleConstants.setForeground(blue_Attr, Color.black);
            setCharacterAttributes(textPane, blue_Attr, false);
        }else if(s.equals("深色模式")){
            setWindowsBackground(Color.black);
            MutableAttributeSet blue_Attr = new SimpleAttributeSet();
            StyleConstants.setForeground(blue_Attr, Color.white);
            setCharacterAttributes(textPane, blue_Attr, false);
        }

    }
}

