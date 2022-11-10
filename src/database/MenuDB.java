package database;
import model.TextEnitity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuDB implements ActionListener {
    JMenu menuDB;
    JMenuItem menuAbout;
    database.DBConnect dbConnect;

    public MenuDB() {
         dbConnect = new database.DBConnect();
        createMenu();

    }

    public void createMenu() {
        menuDB = new JMenu("DB");
        menuDB.add(menuAbout=new JMenuItem("About"));
        menuAbout.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("About")) {
        JFrame jFrame =new JFrame();
        JDialog jDialog=new JDialog(jFrame);
        jDialog.setLayout(new FlowLayout());
        jDialog.setBounds(500,300,1000,300);
            TextEnitity textEnitity=dbConnect.em.find(TextEnitity.class,1);
        JLabel jLabel=new JLabel(textEnitity.getText());
            jDialog.add(jLabel);
            jDialog.setVisible(true);

        }
    }

    public JMenu getMenuDB() {
        return menuDB;
    }
}