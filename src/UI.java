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


    JMenuBar menuBar;
    JToolBar toolBar;
    JMenu menuFile, menuEdit, menuFind, menuAbout, menuColor,menuFont;
    JButton newButton, undoButton, redoButton;
    JMenuItem openFile, saveFile, saveFileAs, cut, paste, copy, blue, red, pink,standard,microsoftBold ,newDetail;

    JLabel stateBar;

    StyleContext sc = new StyleContext();
    DefaultStyledDocument doc = new DefaultStyledDocument(sc);
    JTextPane textPane = new JTextPane(doc);


    //定義圖片
    Image image = new ImageIcon("src/icons/new.png").getImage();
    Image nImage = image.getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING);
    ImageIcon newIcon = new ImageIcon(nImage);
    Image undoImage = new ImageIcon("src/icons/undo.png").getImage();
    Image uImage = undoImage.getScaledInstance(20, 20, Image.SCALE_AREA_AVERAGING);
    ImageIcon undoIcon = new ImageIcon(uImage);


    public UI() {
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
        toolBar = new JToolBar();
        menuBar = new JMenuBar();
        //menuFile
        menuFile = new JMenu("檔案");

        openFile = new JMenuItem("開啟舊檔");
        openFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));

        saveFile = new JMenuItem("儲存檔案");
        saveFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));

        saveFileAs = new JMenuItem("另存新檔");
        saveFileAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F12, InputEvent.CTRL_DOWN_MASK));

        menuFile.add(openFile);
        menuFile.addSeparator();
        menuFile.add(saveFile);
        menuFile.add(saveFileAs);


        //menuEdit
        menuEdit = new JMenu("編輯");
        cut = new JMenuItem("剪下");
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,InputEvent.CTRL_DOWN_MASK));
        copy = new JMenuItem("複製");
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_DOWN_MASK));
        paste = new JMenuItem("貼上");
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,InputEvent.CTRL_DOWN_MASK));
        menuEdit.add(cut);
        menuEdit.add(copy);
        menuEdit.add(paste);


        //menuFind
        menuFind = new JMenu("尋找");


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

        //menuFont
        menuFont=new JMenu("字體");

        standard=new JMenuItem("標楷體");
        standard.addActionListener(new FontEdit(textPane));
        menuFont.add(standard);

        microsoftBold=new JMenuItem("微軟正黑體");
        microsoftBold.addActionListener(new FontEdit(textPane));
        menuFont.add(microsoftBold);

        newDetail=new JMenuItem("新細明體");
        newDetail.addActionListener(new FontEdit(textPane));
        menuFont.add(newDetail);


        menuBar.add(menuFile);
        menuBar.add(menuEdit);
        menuBar.add(menuFind);
        menuBar.add(menuFont);
        menuBar.add(menuColor);
        menuBar.add(menuAbout);

        //建立新檔
        newButton = new JButton(newIcon);

        //上一步
        undoButton = new JButton(undoIcon);

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
        toolBar.addSeparator();
        setJMenuBar(menuBar);
        this.add(toolBar, BorderLayout.NORTH);
    }


    @Override
    public void actionPerformed(ActionEvent e) {


    }
}
