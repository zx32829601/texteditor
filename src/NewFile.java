import javax.swing.*;
import javax.swing.text.DefaultStyledDocument;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;

public  class NewFile implements ActionListener {
    static JMenuItem new_Windows;
    private UI ui;
    public NewFile(UI u){
        this.ui=u;
        createItem();
    }
    JTextPane textPane = new JTextPane(); //文字窗格，編輯視窗
public void createItem(){
    new_Windows = new JMenuItem("OpenNewWindows");
    new_Windows.addActionListener(this);
}
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
       if(s.equals("OpenNewWindows")) {
            ui.textPane.setDocument(new DefaultStyledDocument()); //清空文件
            new UI().setVisible(true);
        }
    }
}

