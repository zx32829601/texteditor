import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * @author zx328
 */
public class UI extends JFrame implements ActionListener {


    private static JTextArea area;

    boolean listState = true;

    JMenuBar menuBar;
    JToolBar toolBar;
    JMenu menuFile, menuEdit, menuFind, menuAbout, menuColor, menuModel, menuFont, menuText;
    JButton newButton, undoButton, redoButton, boldButton, italicsButton, bottomlineButton, listButton, numberlistButton;
    JMenuItem openFile, saveFile, saveFileAs, cut, paste, copy, blue, red, pink, normalModel, darkModel, standard, microsoftBold, newDetail, new_Windows, ye, or, ge,replace,FIND;
    JTextArea textAreaOutput;

    JLabel stateBar;

    StyleContext sc = new StyleContext();
    DefaultStyledDocument doc = new DefaultStyledDocument(sc);
    JTextPane textPane = new JTextPane(doc);


    DefineImageButton defineImageButton = new DefineImageButton();
    AdjustFontSize adjustFontSize = new AdjustFontSize();


    public UI() {
        super("新增文字檔案");
        this.setIconImage(new ImageIcon("./assets/image/mainicon/nick.jpg").getImage());
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
        toolBar = new JToolBar();
        menuBar = new JMenuBar();
        //menuFile
        menuFile = new JMenu("檔案");

        openFile = new JMenuItem("開啟舊檔");
        openFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
//        openFile.addActionListener(new FileEditor(this));

        saveFile = new JMenuItem("儲存檔案");
        saveFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
//        saveFile.addActionListener(new FileEditor(this));

        saveFileAs = new JMenuItem("另存新檔");
        saveFileAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F12, InputEvent.CTRL_DOWN_MASK));
//        saveFileAs.addActionListener(new FileEditor(this));
        //新視窗
        new_Windows = new JMenuItem("OpenNewWindows");
        new_Windows.addActionListener (new NewFile(this));
        menuFile.add(openFile);
        menuFile.addSeparator();
        menuFile.add(saveFile);
        menuFile.add(saveFileAs);
        menuFile.add(new_Windows);


        //menuEdit
        menuEdit = new JMenu("編輯");
        cut = new JMenuItem("剪下");
        copy = new JMenuItem("複製");
        paste = new JMenuItem("貼上");
        menuEdit.add(cut);
        menuEdit.add(copy);
        menuEdit.add(paste);


        //menuFind
        menuFind = new JMenu("功能");
        FIND= new JMenuItem("尋找");
        FIND.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                Find ff = new Find(textPane.getText());  //開啟視窗
            }
        });
        replace = new JMenuItem("取代");
        replace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        menuFind.add(FIND);

        //提醒

        menuText = new JMenu("醒目提示");
        ye = new JMenuItem("黃色");
        or = new JMenuItem("橘色");
        ge = new JMenuItem("綠色");
        menuText.add(ye);
        menuText.add(or);
        menuText.add(ge);
        ye.addActionListener(new highlighter(textPane));
        or.addActionListener(new highlighter(textPane));
        ge.addActionListener(new highlighter(textPane));


        //menuAbout
        menuAbout = new JMenu("關於");


        //menuColor
        menuColor = new JMenu("字體顏色");
        blue = new JMenuItem("藍色");
        red = new JMenuItem("紅色");
        pink = new JMenuItem("粉紅色");
        blue.addActionListener(new FontEdit(textPane));
        red.addActionListener(new FontEdit(textPane));
        pink.addActionListener(new FontEdit(textPane));
        menuColor.add(blue);
        menuColor.add(red);
        menuColor.add(pink);


        menuFont = new JMenu("字體");

        standard = new JMenuItem("標楷體");
        standard.addActionListener(new FontEdit(textPane));
        menuFont.add(standard);

        microsoftBold = new JMenuItem("微軟正黑體");
        microsoftBold.addActionListener(new FontEdit(textPane));
        menuFont.add(microsoftBold);

        newDetail = new JMenuItem("新細明體");
        newDetail.addActionListener(new FontEdit(textPane));
        menuFont.add(newDetail);

        //建立新檔
        newButton = new JButton(defineImageButton.newIcon);

        //上一步
        undoButton = new JButton(defineImageButton.undoIcon);

        //粗體
        boldButton = new JButton(defineImageButton.boldIcon);
        boldButton.setToolTipText("粗體");
        boldButton.setText("bold");
        boldButton.setFont(new Font("bold", 0, 0));
        boldButton.addActionListener(new Bold(textPane));

        //斜體
        italicsButton = new JButton(defineImageButton.italicsIcon);
        italicsButton.setToolTipText("斜體");
        italicsButton.setText("italics");
        italicsButton.setFont(new Font("italics", 0, 0));
        italicsButton.addActionListener(new Italics(textPane));

        //textUnderLine
        bottomlineButton = new JButton(defineImageButton.bottomlineIcon);
        bottomlineButton.setToolTipText("底線");
        bottomlineButton.setText("bottomline");
        bottomlineButton.setFont(new Font("bottomline", 0, 0));
        bottomlineButton.addActionListener(new Bottomline(textPane));


        //項目清單
        listButton = new JButton(defineImageButton.listIcon);
        listButton.setToolTipText("項目清單");
        listButton.setText("list");
        listButton.setFont(new Font("list", 0, 0));
        listButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(listState == true){
                    List l = new List(textPane.getText(),listState);
                    textPane.setText(l.Changed_text());
                    listState = false;
                }else{
                    List l = new List(textPane.getText(),listState);
                    textPane.setText(l.Changed_text());
                    listState = true;
                }

            }
        });

        //數字清單
        numberlistButton = new JButton(defineImageButton.numberlistIcon);
        numberlistButton.setToolTipText("數字清單");
        numberlistButton.setText("numberlist");
        numberlistButton.setFont(new Font("numberlist", 0, 0));
        numberlistButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(listState == true){
                    Numberlist nl = new Numberlist(textPane.getText(),listState);
                    textPane.setText(nl.Changed_text());
                    listState = false;
                }else{
                    Numberlist l = new Numberlist(textPane.getText(),listState);
                    textPane.setText(l.Changed_text());
                    listState = true;
                }

            }
        });

        //深淺色背景
        menuModel = new JMenu("背景模式");
        normalModel = new JMenuItem("一般模式");
        normalModel.addActionListener(new Window_change(this));
        darkModel = new JMenuItem("深色模式");
        darkModel.addActionListener(new Window_change(this));
        menuModel.add(normalModel);
        menuModel.add(darkModel);


        menuBar.add(menuFile);
        menuBar.add(menuEdit);
        menuBar.add(menuFind);
        menuBar.add(menuFont);
        menuBar.add(menuColor);
        menuBar.add(menuText);
        menuBar.add(menuAbout);
        menuBar.add(menuModel);


        //建立新檔
        newButton = new JButton(defineImageButton.newIcon);

        //上一步
        undoButton = new JButton(defineImageButton.undoIcon);


        //文字編輯區
        textPane.setFont(new Font("細明體", Font.PLAIN, 16));


        JScrollPane panel = new JScrollPane(textPane, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Container contentPane = getContentPane();
        contentPane.add(panel, BorderLayout.CENTER);

        //顯示字數
        stateBar = new JLabel("Characters:" + 0);
        stateBar.setHorizontalAlignment(SwingConstants.LEFT);
        textPane.getDocument().addDocumentListener(new WordCountListener(stateBar));

        contentPane.add(stateBar, BorderLayout.SOUTH);


        toolBar.add(newButton);
        toolBar.add(undoButton);
        toolBar.add(boldButton);
        toolBar.add(italicsButton);
        toolBar.add(bottomlineButton);
        toolBar.add(listButton);
        toolBar.add(numberlistButton);
        toolBar.add(adjustFontSize.comboBox);
        toolBar.addSeparator();
        setJMenuBar(menuBar);
        this.add(toolBar, BorderLayout.NORTH);
    }


    @Override
    public void actionPerformed(ActionEvent e) {


    }

}
