//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//import java.io.*;
//
//public class FileEditor implements ActionListener {
//    private UI u;
//    private JFileChooser fileChooser = new JFileChooser();
//
//    public FileEditor(UI ui) {
//        this.u = ui;
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//            String s =e.getActionCommand();
//            if(s.equals("開啟舊檔")){
//                openFile();
//            }else if(s.equals("儲存檔案")){
//                saveFile();
//            }else if(s.equals("另存新檔")){
//                saveFileAs();
//            }
//        };
//
//
//
//
//    private void openFile() {
//        if(isCurrentFileSaved()) { // 文件是否為儲存狀態
//            open(); // 開啟舊檔
//        }
//        else {
//            // 顯示對話方塊
//            int option = JOptionPane.showConfirmDialog(
//                    null, "檔案已修改，是否儲存？",
//                    "儲存檔案？", JOptionPane.YES_NO_OPTION,
//                    JOptionPane.WARNING_MESSAGE, null);
//            switch(option) {
//                // 確認檔案儲存
//                case JOptionPane.YES_OPTION:
//                    saveFile(); // 儲存檔案
//                    break;
//                // 放棄檔案儲存
//                case JOptionPane.NO_OPTION:
//                    open();
//                    break;
//            }
//        }
//    }
//    private void open() {
//        // fileChooser 是 JFileChooser 的實例
//        // 顯示檔案選取的對話方塊
//        int option = fileChooser.showDialog(null, null);
//
//        // 使用者按下確認鍵
//        if(option == JFileChooser.APPROVE_OPTION) {
//            try {
//                // 開啟選取的檔案
//                BufferedReader buf =
//                        new BufferedReader(
//                                new FileReader(
//                                        fileChooser.getSelectedFile()));
//                // 設定文件標題
//                u.setTitle(fileChooser.getSelectedFile().toString());
//                // 清除前一次文件
//                u.textPane.setText("");
//                // 設定狀態列
//                u.stateBar.setText("未修改");
//                // 取得系統相依的換行字元
//                String lineSeparator = System.getProperty("line.separator");
//                // 讀取檔案並附加至文字編輯區
//                String text;
//                while((text = buf.readLine()) != null) {
//                    u.textPane.setText(text);
//                    u.textPane.setText(lineSeparator);
//                }
//                buf.close();
//            }
//            catch(IOException e) {
//                JOptionPane.showMessageDialog(null, e.toString(),
//                        "開啟檔案失敗", JOptionPane.ERROR_MESSAGE);
//            }
//        }
//    }
//
//    //儲存檔案
//    private void saveFile() {
//        // 從標題列取得檔案名稱
//        File file =new File(u.getTitle());
//        // 若指定的檔案不存在
//        if(!file.exists()) {
//            // 執行另存新檔
//            saveFileAs();
//        }
//        else {
//            try {
//                // 開啟指定的檔案
//                BufferedWriter buf =
//                        new BufferedWriter(
//                                new FileWriter(file));
//                // 將文字編輯區的文字寫入檔案
//                buf.write(u.textPane.getText());
//                buf.close();
//                // 設定狀態列為未修改
//                u.stateBar.setText("未修改");
//            }
//            catch(IOException e) {
//                JOptionPane.showMessageDialog(null, e.toString(),
//                        "寫入檔案失敗", JOptionPane.ERROR_MESSAGE);
//            }
//        }
//    }
//
//    private void saveFileAs() {
//        // 顯示檔案對話方塊
//        int option = fileChooser.showDialog(null, null);
//        // 如果確認選取檔案
//        if(option == JFileChooser.APPROVE_OPTION) {
//            // 取得選擇的檔案
//            File file = fileChooser.getSelectedFile();
//
//            // 在標題列上設定檔案名稱
//            u.setTitle(file.toString());
//
//            try {
//                // 建立檔案
//                file.createNewFile();
//                // 進行檔案儲存
//                saveFile();
//            }
//            catch(IOException e) {
//                JOptionPane.showMessageDialog(null, e.toString(),
//                        "無法建立新檔", JOptionPane.ERROR_MESSAGE);
//            }
//        }
//    }
//
//
//    private boolean isCurrentFileSaved() {
//        if(u.stateBar.getText().equals("未修改")) {
//            return false;
//        }
//        else {
//            return true;
//        }
//    }
//}
//
//
//
//
//
//
