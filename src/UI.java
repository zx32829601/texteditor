import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author zx328
 */
public class UI extends JFrame implements ActionListener {


    private static JTextArea area;

    boolean listState = true;
    JMenuBar menuBar;
    JToolBar toolBar;
    JMenu menuFile, menuEdit, menuFind, menuAbout, menuColor, menuModel, menuFont, menuText;

    JMenu array[] = new JMenu[8];

    JButton newButton, undoButton, redoButton, boldButton, italicsButton, bottomlineButton, listButton, numberlistButton,centerButton,leftalignButton,rightalignButton;
    JMenuItem openFile, saveFile, saveFileAs, cut, paste, copy, blue, red, pink, normalModel, darkModel, standard, microsoftBold, newDetail, new_Windows, ye, or, ge,replace,FIND;
    JTextArea textAreaOutput;

    JLabel stateBar;



    StyleContext sc = new StyleContext();
    DefaultStyledDocument doc = new DefaultStyledDocument(sc);
    JTextPane textPane = new JTextPane(doc);


    DefineImageButton defineImageButton = new DefineImageButton();
    AdjustFontSize adjustFontSize = new AdjustFontSize();

    //按鈕class
    Bold bold;
    Italics italics;
    Bottomline bottomline;

    WordCountListener wordCountListener;

    FileEditor fileEditor;

    FontEdit fontEdit;

    Align align;
    TXTedit txTedit;

    Highlighter highlighter;

    NewFile newFile;


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

        fileEditor=new FileEditor(this);
        newFile=new NewFile(this);
        menuFile.add(fileEditor.openFile);
        menuFile.addSeparator();
        menuFile.add(fileEditor.saveFile);
        menuFile.add(fileEditor.saveFileAs);
        menuFile.add(newFile.new_Windows);


        //menuEdit
        menuEdit = new JMenu("編輯");
        txTedit=new TXTedit(this);
        menuEdit.add(txTedit.cut);
        menuEdit.add(txTedit.copy);
        menuEdit.add(txTedit.paste);


        //menuFind
        menuFind = new JMenu("功能");
        FIND = new JMenuItem("尋找");
        FIND.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Find ff = new Find(textPane.getText());  //開啟視窗
            }
        });
        replace = new JMenuItem("取代");
        replace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                replace rp = new replace(textPane.getText());


                rp.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        super.windowClosing(e);
                        textPane.setText(rp.getop());
                    }
                });



            }

        });

        menuFind.add(FIND);
        menuFind.add(replace);

        //提醒

        menuText = new JMenu("醒目提示");
        highlighter=new Highlighter(textPane);
        menuText.add(highlighter.yellow);
        menuText.add(highlighter.orange);
        menuText.add(highlighter.green);


        //menuAbout
        menuAbout = new JMenu("關於");


        //menuColor
        menuColor = new JMenu("字體顏色");
        fontEdit=new FontEdit(textPane);
        menuColor.add(fontEdit.blue);
        menuColor.add(fontEdit.red);
        menuColor.add(fontEdit.pink);


        menuFont = new JMenu("字體");
        menuFont.add(fontEdit.standard);
        menuFont.add(fontEdit.microsoftBold);
        menuFont.add(fontEdit.newDetail);

        //建立新檔
        newButton = new JButton(defineImageButton.newIcon);

        //上一步
        undoButton = new JButton(defineImageButton.undoIcon);

        //粗體
        bold = new Bold(textPane);

        //斜體
        italics = new Italics(textPane);

       


        //背景模式
        menuModel = new JMenu("背景模式");
        
        //textUnderLine
        bottomline = new Bottomline(textPane);


//        對齊
        align=new Align(textPane);



        //項目清單
        listButton = new JButton(defineImageButton.listIcon);
        listButton.setToolTipText("項目清單");
        listButton.setText("list");
        listButton.setFont(new Font("list", 0, 0));
        listButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (listState == true) {
                    List l = new List(textPane.getText(), listState);
                    textPane.setText(l.Changed_text());
                    listState = false;
                } else {
                    List l = new List(textPane.getText(), listState);
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
                if (listState == true) {
                    Numberlist nl = new Numberlist(textPane.getText(), listState);
                    textPane.setText(nl.Changed_text());
                    listState = false;
                } else {
                    Numberlist l = new Numberlist(textPane.getText(), listState);
                    textPane.setText(l.Changed_text());
                    listState = true;
                }

            }
        });

        menuBar.add(menuFile);
        menuBar.add(menuEdit);
        menuBar.add(menuFind);
        menuBar.add(menuFont);
        menuBar.add(menuColor);
        menuBar.add(menuText);
        menuBar.add(menuAbout);
        menuBar.add(new Window_change(this).menuModel);


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
        wordCountListener=new WordCountListener(textPane);
        contentPane.add(wordCountListener.stateBar, BorderLayout.SOUTH);


        toolBar.add(newButton);
        toolBar.add(undoButton);
        toolBar.add(bold.boldButton);
        toolBar.add(italics.italicsButton);
        toolBar.add(bottomline.bottomlineButton);
        toolBar.add(listButton);
        toolBar.add(numberlistButton);
        toolBar.add(adjustFontSize.comboBox);
        toolBar.add(align.leftalignButton);
        toolBar.add(align.centerButton);
        toolBar.add(align.rightalignButton);
        toolBar.addSeparator();
        setJMenuBar(menuBar);
        this.add(toolBar, BorderLayout.NORTH);
    }


    @Override
    public void actionPerformed(ActionEvent e) {


    }

}
