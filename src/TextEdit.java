import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Objects;

public class TextEdit implements ActionListener {
    private JTextPane textPane;
    JMenu menuEdit;
    JMenuItem tmpMenuItem;
    ReceiverCommand receiver;
    InvokerCommand invoker;

    public TextEdit(JTextPane textPane) {
        menuEdit=new JMenu("編輯");
        this.textPane=textPane;
        addItem("剪下");
        addItem("複製");
        addItem("貼上");
        receiver = new ReceiverCommand();
        invoker = new InvokerCommand();
        receiver.setTextPane(textPane);
    }
    public void addItem(String newItem){
        tmpMenuItem = new JMenuItem(newItem);
        tmpMenuItem.addActionListener(this);
        if (Objects.equals(newItem, "剪下")) {
            tmpMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));

        }else if (Objects.equals(newItem, "複製")) {
            tmpMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));

        }else if (Objects.equals(newItem, "貼上")) {
            tmpMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_DOWN_MASK));

        }
        menuEdit.add(tmpMenuItem);

    }



    public void actionPerformed(ActionEvent e) {

        String s =e.getActionCommand();
        if(s.equals("剪下")){
            Command cut = new CutCommand(receiver);
            invoker.addCommend(cut);
            invoker.execute();
        }else if(s.equals("複製")){
            Command copy = new CopyCommand(receiver);
            invoker.addCommend(copy);
            invoker.execute();
        }else if(s.equals("貼上")){
            Command paste = new PasteCommand(receiver);
            invoker.addCommend(paste);
            invoker.execute();
        }
    }

}
