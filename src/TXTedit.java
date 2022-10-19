import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TXTedit implements ActionListener {
    private UI u;
    private JPopupMenu popUpMenu;
    public TXTedit(UI ui) {
        this.u = ui;
    }
    private void cut() {
        u.textPane.cut();
        u.stateBar.setText("已修改");
        popUpMenu.setVisible(false);
    }
    private void copy() {
        u.textPane.copy();
        popUpMenu.setVisible(false);
    }
    private void paste() {
        u.textPane.paste();
        u.stateBar.setText("已修改");
        popUpMenu.setVisible(false);
    }
    private void processTextArea() {
        u.stateBar.setText("已修改");
    }

    public void actionPerformed(ActionEvent e) {
        String s =e.getActionCommand();
        if(s.equals("剪下")){
            cut();
        }else if(s.equals("複製")){
            copy();
        }else if(s.equals("貼上")){
            paste();
        }
    }

}
