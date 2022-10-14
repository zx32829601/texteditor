import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI extends JFrame implements ActionListener {
    private JMenuBar menuBar;
    private JToolBar toolBar;
    private  JMenu menuFile,menuEdit,menuFind,menuAbout;
    private JButton newButton,undoButton,redoButton;
    private int wordCount;
    JTextArea textArea;

    //定義圖片
    Image image=new ImageIcon("src/icons/new.png").getImage();
    Image nimage=image.getScaledInstance(20,20, Image.SCALE_AREA_AVERAGING);
    ImageIcon newIcon=new ImageIcon(nimage);
    Image undoImage=new ImageIcon("src/icons/undo.png").getImage();
    Image uImage=undoImage.getScaledInstance(20,20,Image.SCALE_AREA_AVERAGING);
    ImageIcon undoIcon=new ImageIcon(uImage);



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
        toolBar=new JToolBar();
        menuBar=new JMenuBar();
        menuFile=new JMenu("檔案");
        menuEdit=new JMenu("編輯");
        menuFind=new JMenu("尋找");
        menuAbout=new JMenu("關於");
        menuBar.add(menuFile);
        menuBar.add(menuEdit);
        menuBar.add(menuFind);
        menuBar.add(menuAbout);

        //建立新檔
        newButton=new JButton(newIcon);

        //上一步
        undoButton=new JButton(undoIcon);

        //文字編輯區
        textArea=new JTextArea();
        textArea.setFont(new Font("細明體",Font.PLAIN,16));
        textArea.setLineWrap(true);
        JScrollPane panel=new JScrollPane(textArea,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Container cotentPane=getContentPane();
        cotentPane.add(panel,BorderLayout.CENTER);


        //狀態列
        JLabel stateBar=new JLabel(String.valueOf(wordCount));
        stateBar.setHorizontalAlignment(SwingConstants.LEFT);
        stateBar.setBorder(
                BorderFactory.createEtchedBorder()
        );
        cotentPane.add(stateBar,BorderLayout.SOUTH);

        toolBar.add(newButton);
        toolBar.add(undoButton);
        toolBar.addSeparator();
        setJMenuBar(menuBar);
        this.add(toolBar, BorderLayout.NORTH);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
