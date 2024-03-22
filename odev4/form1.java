package odev4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class form1 extends JFrame {
    private JPanel panel;
    private JLabel lbl;
    boolean durum = true;

    form1(){
        add(panel);
        setTitle("Toggle Button ödevi - 22000510007 - Yasin Sağlam");
        setSize(400,400);
        Image onbutton = new ImageIcon(this.getClass().getResource("/on.png")).getImage();
        lbl.setIcon(new ImageIcon(onbutton));
        Image offbutton = new ImageIcon(this.getClass().getResource("/off.png")).getImage();


        lbl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(durum) {
                    lbl.setIcon(new ImageIcon(offbutton));
                    durum=false;
                } else {
                    lbl.setIcon(new ImageIcon(onbutton));
                    durum=true;
                }

                super.mouseClicked(e);
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
