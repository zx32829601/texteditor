import javax.swing.*;
import javax.swing.text.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Numberlist extends JFrame {
    StringBuffer Output = new StringBuffer();
    public Numberlist(String input_text) {
        JTextPane textPane = new JTextPane();
        textPane.setText( "original text" );
        StringBuffer doc = new StringBuffer();
        String ip[];
        ip = input_text.split("\n");
        for(int i = 0;i<ip.length;i++){
            doc.append(ip[i]);
            String s = Integer.toString(i+1);
            doc.insert(0,s+".");
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