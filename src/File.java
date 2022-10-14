import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class File implements ActionListener {
    private JMenuItem FileOpen;
    private JMenuItem FileSave;
    private JMenuItem FileSaveAs;

    //開啟檔案




    // 選單 - 另存新檔
        public void saveFileAs(){
            FileSaveAs.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    saveFileAs();
                }
            });
        }

    //儲存檔案
        public void saveFile(){
            FileSave.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    saveFile();
                }
            });
        }


    @Override
    public void actionPerformed(ActionEvent e) {
        FileOpen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openFile();
            }
        });
    }

    private void openFile() {
    }

}
