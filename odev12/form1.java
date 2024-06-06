package odev12;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class form1 extends JFrame{
    private JPanel panel;

    private JTextArea textArea1;
    private JButton btn;
    private JProgressBar p1;
    private JTextField textField1;
    private JProgressBar p2;
    private JProgressBar p3;
    private JProgressBar p4;
    private JProgressBar p5;
    private JProgressBar p6;
    private JProgressBar progressBar1;
    ArrayList<Integer> l = new ArrayList<>();
    int a = 0;
    int s = 0;
    int c1,c2,c3,c4,c5,c6,t;
    Random r = new Random();

    form1(){
        add(panel);
        setSize(500,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sifirla();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        a = Integer.parseInt(textField1.getText());
                        progressBar1.setMaximum(a);
                        for (int i=0;i<a;i++){
                            s = r.nextInt(6)+1;
                            textArea1.setText(textArea1.getText()+s+"-");
                            l.add(s);
                            progressBar1.setValue(i+1);

                            c1 = Collections.frequency(l,1);
                            c2 = Collections.frequency(l,2);
                            c3 = Collections.frequency(l,3);
                            c4 = Collections.frequency(l,4);
                            c5 = Collections.frequency(l,5);
                            c6 = Collections.frequency(l,6);
                            t = c1 + c2 + c3 + c4 + c5 + c6;

                            p1.setValue((100*c1)/t);
                            p2.setValue((100*c2)/t);
                            p3.setValue((100*c3)/t);
                            p4.setValue((100*c4)/t);
                            p5.setValue((100*c5)/t);
                            p6.setValue((100*c6)/t);

                        }
                        progressBar1.setString("İŞLEM TAMAMLANDI!");


                    }
                }).start();
            }
        });
    }

    void sifirla(){
        l.clear();
        textArea1.setText("");
        p1.setValue(0);
        p2.setValue(0);
        p3.setValue(0);
        p4.setValue(0);
        p5.setValue(0);
        p6.setValue(0);
        t=0;
        c1=c2=c3=c4=c5=c6=0;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                form1 f = new form1();
                f.setVisible(true);
            }
        });
    }

}
