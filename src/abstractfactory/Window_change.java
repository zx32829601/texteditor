package abstractfactory;

import main.UI;

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

    public JMenu getMenuModel() {
        return menuModel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Model_Factory m;
        String s = e.getActionCommand();
        if(s.equals("一般模式")){
            m = new Normal_Factory(this.co);
            m.setBackgroundColor(Color.white);
            m.setTextColor(Color.black);
        }else if(s.equals("深色模式")){
            m = new Dark_Factory(this.co);
            m.setBackgroundColor(Color.darkGray);
            m.setTextColor(Color.white);
        }
    }
}

abstract class Model_Factory{
    UI ui;
    Model_Factory(UI ui){
        this.ui = ui;
    }
    abstract public void setTextColor(Color c);
    abstract public void setBackgroundColor(Color c);
}

class Normal_Factory extends Model_Factory{
    Normal_Factory(UI ui) {
        super(ui);
    }
    @Override
    public void setBackgroundColor(Color c) {
        ui.textPane.setBackground(c);
        ui.menuBar.setBackground(c);
    }
    @Override
    public void setTextColor(Color c) {
        ui.menuText.setForeground(c);
        ui.textPane.setForeground(c);
        ui.menuFile.setForeground(c);
        ui.menuEdit.setForeground(c);
        ui.menuFind.setForeground(c);
        ui.menuAbout.setForeground(c);
        ui.menuColor.setForeground(c);
        ui.menuFont.setForeground(c);
        ui.menuHighLighter.setForeground(c);
        ui.menuModel.setForeground(c);
    }
}

class Dark_Factory extends Model_Factory{
    Dark_Factory(UI ui) {
        super(ui);
    }
    @Override
    public void setBackgroundColor(Color c) {
        ui.textPane.setBackground(c);
        ui.menuBar.setBackground(c);
    }
    @Override
    public void setTextColor(Color c) {
        ui.menuText.setForeground(c);
        ui.textPane.setForeground(c);
        ui.menuFile.setForeground(c);
        ui.menuEdit.setForeground(c);
        ui.menuFind.setForeground(c);
        ui.menuAbout.setForeground(c);
        ui.menuColor.setForeground(c);
        ui.menuFont.setForeground(c);
        ui.menuHighLighter.setForeground(c);
        ui.menuModel.setForeground(c);
    }
}