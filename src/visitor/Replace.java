package visitor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Replace extends JFrame implements Function {
    StringBuilder output = new StringBuilder("");
    String message , input_text;
    Fuc_visitor v;
    @Override
    public java.lang.reflect.Type accept(Fuc_visitor v) {
        this.v = v;
        return v.visit(this);
    }
    public Replace(){
        super("取代");
    }

    public void feature(){
        setSize(250,300);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setVisible(true);
        Container pn = getContentPane();
        //設定成FlowLayout
        FlowLayout fy = new FlowLayout();
        pn.setLayout(null);

        JLabel l = new JLabel("將");
        pn.add(l,BorderLayout.CENTER);
        l.setBounds(100,10,100,40);
        //文字輸入欄位//
        JTextField jTextField_f = new JTextField();
        jTextField_f.setColumns(10);
        pn.add(jTextField_f);
        jTextField_f.setBounds(60,50,100,40);

        JLabel l2 = new JLabel("取代成");
        pn.add(l2);
        l2.setBounds(90,90,100,40);
        JTextField jTextField_t = new JTextField();
        jTextField_t.setColumns(10);
        pn.add(jTextField_t);
        jTextField_t.setBounds(60,120,100,40);

        //確定跟取消按鈕//
        JButton confirm = new JButton("確定");


        confirm.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                int count =0;
                String ip[];
                if(count == 0) {
                    ip = input_text.split("\n");
                    output.setLength(0);
                }
                else {
                    ip = v.getText().split("\n");
                    output.setLength(0);
                    System.out.println("output=" + output.toString());
                }
                int n = 0;

                while(n < ip.length){
                    output.append(ip[n].replace(jTextField_f.getText(),jTextField_t.getText()));
                    output.append("\n");
                    n++;
                }
                Replace.super.dispose();
            }
        });
        pn.add(confirm);

        JButton cancel = new JButton("取消");
        pn.add(cancel);
        confirm.setBounds(30,180,60,20);
        cancel.setBounds(130,180,60,20);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Replace.super.dispose();
            }
        });
        setContentPane(pn);

    }
    public void settext(String t){
        this.input_text = t;
    }
    public String getop(){
        System.out.println(output.toString());
        return output.toString();
    }
}
