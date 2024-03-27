package odev6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class form1 extends JFrame {
    private JPanel panel;
    private JButton btn1;
    private JButton btn2;
    Random rand = new Random();
    int x,y,r,g,b;

    form1(){
        add(panel);
        setSize(500,500);
        btn2.setText("B");

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                r= rand.nextInt(255);
                g= rand.nextInt(255);
                b= rand.nextInt(255);
                btn2.setBackground(new Color(r,g,b));
                btn2.setForeground(new Color(255-r,255-g,255-b));
                x= rand.nextInt(350)+50;
                y= rand.nextInt(350)+50;
                btn2.setBounds(x,y,50,50);
            }
        });
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
