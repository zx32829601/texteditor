import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class File extends UI implements ActionListener {
    private JMenuItem menuOpen;
    private JMenuItem menuSave;
    private JMenuItem menuSaveAs;
    private JLabel stateBar;
    private JTextArea textArea;
    private JFileChooser fileChooser=new JFileChooser();

    //開啟檔案




    // 選單 - 另存新檔
        public void saveFileAs(){
            menuSaveAs.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    saveFileAs();
                }
            });
        }

    //儲存檔案
        public void saveFile(){
            menuSave.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    saveFile();
                }
            });
        }


    @Override
    public void actionPerformed(ActionEvent e) {
        menuOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFile();
            }
        });
    }

    private boolean isCurrentFileSaved() {
        if (stateBar.getText().equals("未修改")) {
            return false;
        } else {
            return true;
        }
    }

    private void openFile() {
        if(isCurrentFileSaved()){
            open();
        }else {
            int option=JOptionPane.showConfirmDialog(
                    null,"檔案已修改，是否儲存?","儲存檔案?",JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE,null);
            switch (option){
                case JOptionPane.YES_OPTION:
                    saveFile();
                    break;
                case JOptionPane.NO_OPTION:
                    open();
                    break;
            }
        }
    }

    private void open() {
        int option=fileChooser.showDialog(null,null);
        if(option==JFileChooser.APPROVE_OPTION){
            try{
                BufferedReader buf= new BufferedReader(new FileReader(fileChooser.getSelectedFile()));
                setTitle(fileChooser.getSelectedFile().toString());
                textArea.setText("");
                stateBar.setText("未修改");
                String lineSeparator=System.getProperty("line.separator");
                String text;
                while ((text=buf.readLine())!=null){
                    textArea.append(text);
                    textArea.append(lineSeparator);
                }
                buf.close();
            }  catch (IOException e) {
                JOptionPane.showMessageDialog(null,e.toString(),"開啟檔案失敗",JOptionPane.ERROR_MESSAGE);
            }
        }
    }




}


