import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window_change implements ActionListener{

    UI co;

    public Window_change(UI co) {this.co = co;}
    public void setWindowsBackground(Color c){
        co.textPane.setBackground(c);
        co.menuBar.setBackground(c);
    }
    public void setTextColor(Color c){
        co.textPane.setForeground(c);
        co.menuFile.setForeground(c);
        co.menuEdit.setForeground(c);
        co.menuFind.setForeground(c);
        co.menuAbout.setForeground(c);
        co.menuColor.setForeground(c);
        co.menuFont.setForeground(c);
        co.menuModel.setForeground(c);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if(s.equals("一般模式")){
            setWindowsBackground(Color.lightGray);
            setTextColor(Color.black);
        }else if(s.equals("深色模式")){
            setWindowsBackground(Color.darkGray);
            setTextColor(Color.white);
        }

    }
}

