import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author zx328
 */
public class UI extends JFrame implements ActionListener {

     JMenuBar menuBar;
     JToolBar toolBar;
      JMenu menuFile,menuEdit,menuFind,menuAbout;
     JButton newButton,undoButton,redoButton;
     JMenuItem openFile,saveFile,saveFileAs,cut,paste,copy;

     JLabel stateBar;

    JTextArea textArea=new JTextArea();



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
        menuFile.add(openFile);
        menuFile.addSeparator();
        menuFile.add(saveFile);
        menuFile.add(saveFileAs);


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


        //menuAbout
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
        textArea.setFont(new Font("細明體",Font.PLAIN,16));
        textArea.setLineWrap(true);
        JScrollPane panel=new JScrollPane(textArea,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Container contentPane=getContentPane();
        contentPane.add(panel,BorderLayout.CENTER);

        //計算字數
        textArea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                recalculateWords();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                recalculateWords();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                recalculateWords();
            }
        });


        //狀態列
         stateBar=new JLabel("Characters:"+0);
        stateBar.setHorizontalAlignment(SwingConstants.LEFT);
        stateBar.setBorder(
                BorderFactory.createEtchedBorder()
        );
        contentPane.add(stateBar,BorderLayout.SOUTH);

        toolBar.add(newButton);
        toolBar.add(undoButton);
        toolBar.addSeparator();
        setJMenuBar(menuBar);
        this.add(toolBar, BorderLayout.NORTH);
    }

    //計算字數


    private void recalculateWords() {
        String text=textArea.getText();
        stateBar.setText("Characters:"+text.length());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
