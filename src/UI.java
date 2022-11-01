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

    JButton newButton, undoButton, listButton, numberlistButton,rhombusButton;
    JMenuItem cut, paste, copy, normalModel, darkModel, replace, FIND;


    JLabel stateBar;

    StyleContext sc = new StyleContext();
    DefaultStyledDocument doc = new DefaultStyledDocument(sc);
    JTextPane textPane = new JTextPane(doc);


    DefineImageButton defineImageButton = new DefineImageButton();
    AdjustFontSize adjustFontSize = new AdjustFontSize();

    //按鈕class
    TextFontComponent bold;
    TextFontComponent italics;
    TextFontComponent bottomline;

    WordCountListener wordCountListener;

    FileEditor fileEditor;

    FontEdit fontEdit;
    Align align;
    Undo undo;

    Window_change window_change;

    HighLighter highLighter;

    TextEdit textEdit;
    TestDecorator testDecorator;

    Find find = new Find();
    Replace rp = new Replace();
    Fuc_visitor visitor = new Fuc_visitor();
    int count = 0;

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
        FIND = new JMenuItem("尋找");
        FIND.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                visitor.inputtext(textPane.getText());
                find.accept(visitor);  //開啟視窗
            }
        });
        replace = new JMenuItem("取代");
        replace.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (count == 0)
                    visitor.inputtext(textPane.getText());
                else
                    visitor.inputtext(rp.getop());
                rp.accept(visitor);
                count++;
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
        highLighter = new HighLighter(textPane);
        menuHighLighter = highLighter.menuHighLighter;

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
        undo = new Undo(textPane);

        //斜體
        //textUnderLine
        //粗體
        testDecorator = new TestDecorator(textPane);



        //對齊
        align = new Align(this,textPane);

        //TODO-等待全域變數的出現
        //圓形
        listButton = new JButton(defineImageButton.listIcon);
        listButton.setToolTipText("圓形符號");
        listButton.setText("list");
        listButton.setFont(new Font("list", 0, 0));
        listButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (listState == true) {
                    Sign a = SignFactory.BuildSign("圓形");
                    a.Input(textPane.getText(), listState);
                    textPane.setText(a.Changed_text());
                    listState = false;
                    System.out.println(listState);
                } else {
                    Sign a = SignFactory.BuildSign("圓形");
                    a.Input(textPane.getText(), listState);
                    textPane.setText(a.Changed_text());
                    listState = true;
                }

            }
        });
        //菱形
        rhombusButton = new JButton(defineImageButton.rhombusIcon);
        rhombusButton.setToolTipText("菱形符號");
        rhombusButton.setText("rhombussing");
        rhombusButton.setFont(new Font("rhombussing", 0, 0));
        rhombusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (listState == true) {
                    Sign a = SignFactory.BuildSign("菱形");
                    a.Input(textPane.getText(), listState);
                    textPane.setText(a.Changed_text());
                    listState = false;
                } else {
                    Sign a = SignFactory.BuildSign("菱形");
                    a.Input(textPane.getText(), listState);
                    textPane.setText(a.Changed_text());
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
        menuBar.add(menuHighLighter);
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
        wordCountListener = new WordCountListener(textPane);
        contentPane.add(wordCountListener.stateBar, BorderLayout.SOUTH);


        toolBar.add(newButton);
        toolBar.add(undo.undoButton);
        toolBar.add(undo.saveButton);
        toolBar.add(testDecorator.boldButton);
        toolBar.add(testDecorator.italicsButton);
        toolBar.add(testDecorator.bottomlineButton);
        toolBar.add(listButton);
        toolBar.add(rhombusButton);
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