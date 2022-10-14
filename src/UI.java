import javax.swing.*;
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


