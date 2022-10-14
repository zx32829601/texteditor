import javax.swing.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class UI extends JFrame{
    private final JMenuBar menuBar=new JMenuBar();

    private  JMenu menuFile,menuEdit,menuFind,menuAbout;
    public UI(){
        super("新增文字檔案");
        setUpUIComponent();
        setUpEventListener();
        setVisible(true);
    }

    private void setUpEventListener() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void setUpUIComponent() {
        setSize(640, 480);

        menuFile=new JMenu("檔案");
        JMenuItem open = new JMenuItem("開啟舊檔");
        menuFile.add(open);
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));

        JMenuItem save = new JMenuItem("儲存檔案");
        menuFile.add(save);
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));

        JMenuItem saveAs = new JMenuItem("另存新檔");
        menuFile.add(saveAs);
        saveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F12, InputEvent.CTRL_DOWN_MASK));

        menuEdit=new JMenu("編輯");
        menuFind=new JMenu("尋找");
        menuAbout=new JMenu("關於");
        menuBar.add(menuFile);
        menuBar.add(menuEdit);
        menuBar.add(menuFind);
        menuBar.add(menuAbout);
        setJMenuBar(menuBar);
    }



}


