import javax.swing.*;
import javax.swing.text.DefaultStyledDocument;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;

public  class NewFile implements ActionListener {
    private UI ui;
    public NewFile(UI u){
        this.ui=u;
    }
    JTextPane textPane = new JTextPane(); //文字窗格，編輯視窗

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
       if(s.equals("OpenNewWindows")) {
            ui.textPane.setDocument(new DefaultStyledDocument()); //清空文件
            new UI().setVisible(true);
        }
    }
}

