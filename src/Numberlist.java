import javax.swing.*;
import javax.swing.text.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Numberlist extends JFrame {
    StringBuffer Output = new StringBuffer();
    public Numberlist(String input_text,Boolean state) {
        JTextPane textPane = new JTextPane();
        StringBuffer doc = new StringBuffer();
        String ip[];
        if (state) {
            ip = input_text.split("\n");
            for(int i = 0;i<ip.length;i++){
                doc.append(ip[i]);
                String s = Integer.toString(i+1);
                doc.insert(0,s+".");
                Output.append(doc);
                Output.append("\n");
                doc.setLength(0);


            }
        }else {
            ip = input_text.split("\n");
            for(int i = 0;i<ip.length;i++) {
                doc.append(ip[i]);
                doc.deleteCharAt(0);
                doc.deleteCharAt(0);
                Output.append(doc);
                Output.append("\n");
                doc.setLength(0);
            }

        }
    }
    public void print(){
        System.out.println(Output.toString());
    }
    public String Changed_text(){
        return Output.toString();
    }

}