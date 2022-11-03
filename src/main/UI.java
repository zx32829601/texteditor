package main;

import abstractfactory.Window_change;
import bridge.BridgeClient;
import command.FontEdit;
import command.TextEdit;
import decorator.TestDecorator;
import decorator.TextFontComponent;
import factory.Numberlist;
import factory.Sign;
import factory.SignFactory;
import image.DefineImageButton;
import memento.Undo;
import nopatternfuntion.AdjustFontSize;
import nopatternfuntion.FileEditor;
import nopatternfuntion.WordCountListener;
import strategy.Align;
import visitor.Find;
import visitor.Fuc_visitor;
import visitor.Replace;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author zx328
 */
public class UI extends JFrame implements ActionListener {


    boolean listState = true;
    public JMenuBar menuBar;
    private JToolBar toolBar;

    public JMenu menuEdit, menuFile, menuFind, menuAbout, menuColor, menuModel, menuFont, menuText, menuHighLighter;

    private JButton listButton, numberlistButton, rhombusButton;
    private JMenuItem replace, FIND, yellow, green1, yellow1, green;


    StyleContext sc = new StyleContext();
    DefaultStyledDocument doc = new DefaultStyledDocument(sc);
    public JTextPane textPane = new JTextPane(doc);


    DefineImageButton defineImageButton = new DefineImageButton();
    AdjustFontSize adjustFontSize = new AdjustFontSize();

    //按鈕class
    TextFontComponent bold;
    TextFontComponent italics;
    TextFontComponent bottomline;

    public WordCountListener wordCountListener;

    FileEditor fileEditor;

    FontEdit fontEdit;
    BridgeClient bridgeClient;
    Align align;
    Undo undo;

    Window_change window_change;

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
        menuFile = fileEditor.getMenuFile();

        //menuEdit
        textEdit = new TextEdit(this.textPane);
        menuEdit = textEdit.getMenuEdit();


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
        menuText = new JMenu("醒目提示");
        yellow = new JMenuItem("黃色");
        green = new JMenuItem("綠色");
        menuText.add(yellow);
        menuText.add(green);
        bridgeClient = new BridgeClient(textPane);
        yellow.addActionListener(new BridgeClient(textPane));
        green.addActionListener(new BridgeClient(textPane));
        menuHighLighter = bridgeClient.getMenuHighLighter();

        //menuColor
        menuColor = new JMenu("字體顏色");
        yellow1 = new JMenuItem("yello");
        green1 = new JMenuItem("green");
        yellow1.addActionListener(new BridgeClient(textPane));
        green1.addActionListener(new BridgeClient(textPane));
        menuColor.add(yellow1);
        menuColor.add(green1);


        //menuAbout
        menuAbout = new JMenu("關於");

        //字體顏色、字體樣式
        fontEdit = new FontEdit(textPane);
        menuFont = fontEdit.getMenuFont();


        //上一步
        undo = new Undo(textPane);

        //斜體
        //textUnderLine
        //粗體
        testDecorator = new TestDecorator(textPane);


        //對齊
        align = new Align(this, textPane);

        //TODO-等待全域變數的出現
        //圓形
        listButton = new JButton(defineImageButton.getListIcon());
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
        rhombusButton = new JButton(defineImageButton.getRhombusIcon());
        rhombusButton.setToolTipText("菱形符號");
        rhombusButton.setText("rhombussing");
        rhombusButton.setFont(new Font("rhombussing", 0, 0));
        rhombusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (listState) {
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
        numberlistButton = new JButton(defineImageButton.getNumberlistIcon());
        numberlistButton.setToolTipText("數字清單");
        numberlistButton.setText("numberlist");
        numberlistButton.setFont(new Font("numberlist", 0, 0));
        numberlistButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (listState) {
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
        menuModel = window_change.getMenuModel();


        menuBar.add(menuFile);
        menuBar.add(menuEdit);
        menuBar.add(menuFind);
        menuBar.add(menuFont);
        menuBar.add(menuColor);
        menuBar.add(menuText);
        menuBar.add(menuAbout);
        menuBar.add(menuModel);


        //文字編輯區
        textPane.setFont(new Font("細明體", Font.PLAIN, 16));


        JScrollPane panel = new JScrollPane(textPane, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        Container contentPane = getContentPane();
        contentPane.add(panel, BorderLayout.CENTER);

        //顯示字數
        wordCountListener = new WordCountListener(textPane);
        contentPane.add(wordCountListener.getStateBar(), BorderLayout.SOUTH);


        toolBar.add(undo.getUndoButton());
        toolBar.add(undo.getSaveButton());
        toolBar.add(testDecorator.getBoldButton());
        toolBar.add(testDecorator.getItalicsButton());
        toolBar.add(testDecorator.getBottomlineButton());
        toolBar.add(listButton);
        toolBar.add(rhombusButton);
        toolBar.add(numberlistButton);
        toolBar.add(adjustFontSize.getComboBox());
        toolBar.add(align.getLeftAlignButton());
        toolBar.add(align.getCenterButton());
        toolBar.add(align.getRightAlignButton());
        toolBar.addSeparator();
        setJMenuBar(menuBar);
        this.add(toolBar, BorderLayout.NORTH);
    }


    @Override
    public void actionPerformed(ActionEvent e) {


    }

}