package odev11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class form1 extends JFrame {
    private JTextField textField1;
    private JSpinner spinner1;
    private JButton button1;

    private JTextField textField2;
    private JPanel panel;
    private JLabel sezar;
    static Timer t;
    static TimerTask g;
    Random r = new Random();


    form1() {
        add(panel);
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        spinner1.setValue(3);

        t = new Timer();

        g = new TimerTask() {
            @Override
            public void run() {
                sezar.setForeground(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
            }
        };

        t.schedule(g,0,1000);


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int k = (int) spinner1.getValue();
                String a = "abcçdefgğhıijklmnoöprsştuüvyz";
                String m = textField1.getText();
                int i, j;
                String s = "";
                for (i = 0; i < m.length(); i++) {
                    if (m.charAt(i) == ' ') s += " ";
                    else {
                        for (j = 0; j < a.length(); j++) {
                            if (m.charAt(i) == a.charAt(j)) {
                                s += a.charAt((j + k) % a.length());
                            }
                        }
                    }
                }
                textField2.setText(s);
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
