import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author zx328
 */
public class UI extends JFrame implements ActionListener {

    private static JTextArea area;


    JMenuBar menuBar;
    JToolBar toolBar;
    JMenu menuFile,menuEdit,menuFind,menuAbout,menuColor,menuText;
    JButton newButton,undoButton,redoButton;
    JMenuItem openFile,saveFile,saveFileAs,cut,paste,copy,blue,red,pink,new_Windows,ye,or,ge;

    JLabel stateBar;

    StyleContext sc=new StyleContext();
    DefaultStyledDocument doc=new DefaultStyledDocument(sc);
    JTextPane textPane=new JTextPane(doc);

    JTextArea textAreaOutput;

    //定義圖片
    Image image=new ImageIcon("src/icons/new.png").getImage();
    Image nImage=image.getScaledInstance(20,20, Image.SCALE_AREA_AVERAGING);
    ImageIcon newIcon=new ImageIcon(nImage);
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
        //word-count-listener
    }

    private void setUpUIComponent() {
        setSize(640, 480);
        toolBar=new JToolBar();
        menuBar=new JMenuBar();
        //menuFile
        menuFile=new JMenu("檔案");
        openFile=new JMenuItem("開啟舊檔");
        saveFile=new JMenuItem("儲存檔案");
        saveFileAs=new JMenuItem("另存新檔");
        new_Windows = new JMenuItem("OpenNewWindows");
        new_Windows.addActionListener (new NewFile(this));// 設置監聽

        menuFile.add(openFile);
        menuFile.addSeparator();
        menuFile.add(saveFile);
        menuFile.add(saveFileAs);
        menuFile.add(new_Windows);

        //menuEdit
        menuEdit=new JMenu("編輯");
        cut=new JMenuItem("剪下");
        copy=new JMenuItem("複製");
        paste=new JMenuItem("貼上");
        menuEdit.add(cut);
        menuEdit.add(copy);
        menuEdit.add(paste);



        //menuFind
        menuFind=new JMenu("尋找");

        //提醒

        menuText = new JMenu("醒目提示");
        ye=new JMenuItem("黃色");
        or=new JMenuItem("橘色");
        ge=new JMenuItem("綠色");
        menuText.add(ye);
        menuText.add(or);
        menuText.add(ge);
        ye.addActionListener(new highlighter(textPane));
        or.addActionListener(new highlighter(textPane));
        ge.addActionListener(new highlighter(textPane));



        //menuAbout
        menuAbout=new JMenu("關於");





        //menuColor
        menuColor=new JMenu("字體顏色");
        blue=new JMenuItem("藍色");
        red=new JMenuItem("紅色");
        pink=new JMenuItem("粉紅色");
        blue.addActionListener(new FontEdit(textPane));
        red.addActionListener(new FontEdit(textPane));
        pink.addActionListener(new FontEdit(textPane));
        menuColor.add(blue);
        menuColor.add(red);
        menuColor.add(pink);




        menuBar.add(menuFile);
        menuBar.add(menuEdit);
        menuBar.add(menuFind);
        menuBar.add(menuColor);
        menuBar.add(menuText);
        menuBar.add(menuAbout);


        //建立新檔
        newButton=new JButton(newIcon);

        //上一步
        undoButton=new JButton(undoIcon);

        //文字編輯區
        textPane.setFont(new Font("細明體",Font.PLAIN,16));


        JScrollPane panel=new JScrollPane(textPane,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Container contentPane=getContentPane();
        contentPane.add(panel,BorderLayout.CENTER);

        //顯示字數
        stateBar=new JLabel("Characters:"+0);
        stateBar.setHorizontalAlignment(SwingConstants.LEFT);
        textPane.getDocument().addDocumentListener(new WordCountListener(stateBar));
        contentPane.add(stateBar,BorderLayout.SOUTH);




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
