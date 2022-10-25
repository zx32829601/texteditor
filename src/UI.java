import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author zx328
 */
public class UI extends JFrame implements ActionListener {


    boolean listState = true;
    JMenuBar menuBar;
    JToolBar toolBar;
    JMenu menuFile, menuEdit, menuFind, menuAbout, menuColor, menuModel, menuFont, menuHighLighter;

    JButton newButton, undoButton, listButton, numberlistButton;
    JMenuItem cut, paste, copy, normalModel, darkModel;


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
    Find find;
    //    Replace replace;
    FontEdit fontEdit;
    Align align;

    Window_change window_change;

//    HighLighter highLighter;

    TextEdit textEdit;

    Undo undo;

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
        menuFile = new JMenu("檔案");

        //把openNewWindow併進FileEditor了
        fileEditor = new FileEditor(this);
        menuFile = fileEditor.menuFile;

        //menuEdit
        textEdit = new TextEdit(this.textPane);
        menuEdit = textEdit.menuEdit;

        //TODO-待修改
        //menuFind
        menuFind = new JMenu("功能");
        find = new Find(textPane);
        menuFind.add(Find.findText);
//        replace = new Replace(textPane);
//        menuFind.add(replace.replaceText);

        //提醒
//        highLighter = new HighLighter(textPane);
//        menuHighLighter = highLighter.menuHighLighter;

        //menuAbout
        menuAbout = new JMenu("關於");

        //字體顏色、字體樣式
        fontEdit = new FontEdit(textPane);
        menuColor = fontEdit.menuColor;
        menuFont = fontEdit.menuFont;

        //建立新檔
        newButton = new JButton(defineImageButton.newIcon);

        //上一步
        undoButton = new JButton(defineImageButton.undoIcon);

        //粗體
        bold = new Bold(textPane);

        //斜體
        italics = new Italics(textPane);

        //textUnderLine
        bottomline = new Bottomline(textPane);

        //對齊
        align = new Align(textPane);

        //TODO-等待全域變數的出現
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

        //TODO-等待全域變數的出現
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

        //深淺色背景
        window_change = new Window_change(this);
        menuModel = window_change.menuModel;


        menuBar.add(menuFile);
        menuBar.add(menuEdit);
        menuBar.add(menuFind);
        menuBar.add(menuFont);
        menuBar.add(menuColor);
//        menuBar.add(menuHighLighter);
        menuBar.add(menuAbout);
        menuBar.add(menuModel);


        //建立新檔
        newButton = new JButton(defineImageButton.newIcon);

        //上一步
        undo = new Undo(textPane);


        //文字編輯區
        textPane.setFont(new Font("細明體", Font.PLAIN, 16));


        JScrollPane panel = new JScrollPane(textPane, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Container contentPane = getContentPane();
        contentPane.add(panel, BorderLayout.CENTER);

        //顯示字數
        wordCountListener = new WordCountListener(textPane);
        contentPane.add(wordCountListener.stateBar, BorderLayout.SOUTH);


        toolBar.add(newButton);
        toolBar.add(undo.undoButton);
        toolBar.add(undo.saveButton);
        toolBar.add(bold.boldButton);
        toolBar.add(italics.italicsButton);
        toolBar.add(bottomline.bottomlineButton);
        toolBar.add(listButton);
        toolBar.add(numberlistButton);
        toolBar.add(adjustFontSize.comboBox);
        toolBar.add(align.leftAlignButton);
        toolBar.add(align.centerButton);
        toolBar.add(align.rightAlignButton);
        toolBar.addSeparator();
        setJMenuBar(menuBar);
        this.add(toolBar, BorderLayout.NORTH);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

}