import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestDecorator implements ActionListener {
    JButton italicsButton,bottomlineButton,boldButton;
        JTextPane textPane;
        DefineImageButton defineImageButton;
        TextFontComponent TFC;
        Bold bold;
        Italics italics;
        Bottomline bottomline;
        public TestDecorator(JTextPane textPane){
            this.textPane=textPane;
            defineImageButton=new DefineImageButton();
             TFC = new TextFontComponent(textPane);
             bold=new Bold(TFC);
             italics=new Italics(TFC);
             bottomline=new Bottomline(TFC);
             createButton();
        }
        public void createButton(){
            //斜體
            italicsButton = new JButton(defineImageButton.italicsIcon);
            italicsButton.setToolTipText("斜體");
            italicsButton.setText("italics");
            italicsButton.setFont(new Font("italics", 0, 0));
            italicsButton.addActionListener(this);
            //底線
            bottomlineButton = new JButton(defineImageButton.bottomlineIcon);
            bottomlineButton.setToolTipText("底線");
            bottomlineButton.setText("bottomline");
            bottomlineButton.setFont(new Font("bottomline", 0, 0));
            bottomlineButton.addActionListener(this);
            //粗體
            boldButton = new JButton(defineImageButton.boldIcon);
            boldButton.setToolTipText("粗體");
            boldButton.setText("bold");
            boldButton.setFont(new Font("bold",0,0));
            boldButton.addActionListener(this);
        }
    public void actionPerformed(ActionEvent e) {
        String s =e.getActionCommand();

        switch(s){
            case "italics":
                italics.changeStyle();
                break;
            case "bold":
                bold.changeStyle();
                break;
            case "bottomline" :
                bottomline.changeStyle();
                break;
        }

    }
}
