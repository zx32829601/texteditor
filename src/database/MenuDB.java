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
        menuDB.add(menuAbout = new JMenuItem("About"));
        menuAbout.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        if (s.equals("About")) {
            JTextArea jTextArea = new JTextArea();
            JFrame jFrame = new JFrame();
            JDialog jDialog = new JDialog(jFrame);
            jDialog.setLayout(new BorderLayout());
            jDialog.setBounds(500, 300, 1000, 300);
            TextEnitity textEnitity = dbConnect.em.find(TextEnitity.class, 1);

            jTextArea.setText(textEnitity.getText());
            JScrollPane panel = new JScrollPane(jTextArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            jTextArea.setLayout(new BorderLayout());
            jTextArea.setLineWrap(true);
            jTextArea.setEnabled(false);
            jDialog.add(jTextArea);
            jDialog.setVisible(true);

        }
    }

    public JMenu getMenuDB() {
        return menuDB;
    }
}