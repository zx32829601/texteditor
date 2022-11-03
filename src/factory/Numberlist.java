package factory;

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
        String s;
        int n = 0;
        if (state) {
            ip = input_text.split("\n");
            for(int i = 0;i<ip.length;i++){
                doc.append(ip[i]);
                s = Integer.toString(i+1);
                doc.insert(0,s+".");
                Output.append(doc);
                Output.append("\n");
                doc.setLength(0);
            }
        }else {
            ip = input_text.split("\n");
            for(int i = 0;i<ip.length;i++) {
                doc.append(ip[i]);
                if(n<9)
                doc.replace(0,2,"");
                else
                doc.replace(0,3,"");
                Output.append(doc);
                Output.append("\n");
                doc.setLength(0);
                n++;
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