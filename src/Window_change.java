import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window_change implements ActionListener{

    UI co;
    JMenu menuModel;
    JMenuItem normalModel, darkModel;
    public Window_change(UI co) {
        this.co = co;
        createButtum();
    }
    public void createButtum(){
        //深淺色背景
        menuModel = new JMenu("背景模式");
        normalModel = new JMenuItem("一般模式");
        normalModel.addActionListener(this);
        darkModel = new JMenuItem("深色模式");
        darkModel.addActionListener(this);
        menuModel.add(normalModel);
        menuModel.add(darkModel);
    }
    public void setWindowsBackground(Color c){
        this.co.textPane.setBackground(c);
        this.co.menuBar.setBackground(c);
    }
    public void setTextColor(Color c){
        this.co.textPane.setForeground(c);
        this.co.menuFile.setForeground(c);
        this.co.menuEdit.setForeground(c);
        this.co.menuFind.setForeground(c);
        this.co.menuAbout.setForeground(c);
        this.co.menuColor.setForeground(c);
        this.co.menuFont.setForeground(c);
        this.co.menuText.setForeground(c);
        this.menuModel.setForeground(c);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if(s.equals("一般模式")){
            setWindowsBackground(Color.white);
            setTextColor(Color.black);
        }else if(s.equals("深色模式")){
            setWindowsBackground(Color.darkGray);
            setTextColor(Color.white);
        }

    }
}

