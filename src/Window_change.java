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
    @Override
    public void actionPerformed(ActionEvent e) {
        ModelFactory m;
        String s = e.getActionCommand();
        if(s.equals("一般模式")){
            m = new NormalModel(this.co);
            m.setWindowsBackground();
            m.setTextColor();
        }else if(s.equals("深色模式")){
            m = new DarkModel(this.co);
            m.setWindowsBackground();
            m.setTextColor();
        }

    }
}

abstract class ModelFactory{
    public abstract void setWindowsBackground();
    public abstract void setTextColor();
}

class NormalModel extends ModelFactory {
    UI ui;
    public NormalModel(UI ui){
        this.ui = ui;
    }
    @Override
    public void setWindowsBackground() {
        Color c = Color.white;
        ui.textPane.setBackground(c);
        ui.menuBar.setBackground(c);
    }

    @Override
    public void setTextColor() {
        Color c = Color.black;
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

class DarkModel extends ModelFactory {
    UI ui;
    public DarkModel(UI ui) {
        this.ui = ui;
    }

    @Override
    public void setWindowsBackground() {
        Color c = Color.darkGray;
        ui.textPane.setBackground(c);
        ui.menuBar.setBackground(c);
    }

    @Override
    public void setTextColor() {
        Color c = Color.white;
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
