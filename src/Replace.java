import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Replace extends JFrame {
    StringBuffer output = new StringBuffer("");
    JTextPane textPane;
    JMenuItem replaceText;
    public Replace(JTextPane jTextPane){
        textPane = jTextPane;
        replaceText = new JMenuItem("取代");
        addFunction();
    }
    public Replace(String input_text){
        super("取代");
        String ip[];
        ip = input_text.split("\n");
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
    public void addFunction(){
        replaceText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Replace rp = new Replace(textPane.getText());


                rp.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosed(WindowEvent e) {
                        super.windowClosing(e);
                        textPane.setText(rp.getop());
                    }
                });



            }

        });
    }
    public String getop(){
        return output.toString();
    }
}