import javax.swing.*;
import javax.swing.text.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class List extends JFrame {
    StringBuffer Output = new StringBuffer();
    public List(String input_text) {
        JTextPane textPane = new JTextPane();
        textPane.setText( "original text" );
        StringBuffer doc = new StringBuffer();
        String ip[];
        ip = input_text.split("\n");
        for(int i = 0;i<ip.length;i++){
            doc.append(ip[i]);
            doc.insert(0,"●");
            Output.append(doc);
            Output.append("\n");
            doc.setLength(0);
        }
    }
    public void print(){
        System.out.println(Output.toString());
    }
    public String Changed_text(){
        return Output.toString();
    }

}


