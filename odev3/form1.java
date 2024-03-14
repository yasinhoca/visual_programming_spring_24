package odev3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class form1 extends JFrame {
    private JComboBox tb;
    private JComboBox rb;
    private JComboBox gb;
    private JComboBox bb;
    private JButton btn;
    private JPanel panel;
    DefaultComboBoxModel mr = new DefaultComboBoxModel<>();
    DefaultComboBoxModel mg = new DefaultComboBoxModel<>();
    DefaultComboBoxModel mb = new DefaultComboBoxModel<>();
    int r, g, b;

    form1() {
        add(panel);
        setTitle("ComboBox ödevi - 2100510007 - Yasin Sağlam");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        for (int i = 0; i < 256; i++) {
            mr.addElement(i);
            mg.addElement(i);
            mb.addElement(i);
        }

        rb.setModel(mr);
        gb.setModel(mg);
        bb.setModel(mb);


        rb.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                rb.setBackground(new Color(rb.getSelectedIndex(),0,0));
                renkDegistir();
            }
        });
        gb.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                gb.setBackground(new Color(0,gb.getSelectedIndex(),0));
                renkDegistir();
            }
        });
        bb.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                bb.setBackground(new Color(0,0,bb.getSelectedIndex()));
                renkDegistir();
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

    void renkDegistir() {
        r = rb.getSelectedIndex();
        g = gb.getSelectedIndex();
        b = bb.getSelectedIndex();
        if (tb.getSelectedIndex() == 0) {
            btn.setForeground(new Color(r, g, b));
        } else {
            btn.setBackground(new Color(r, g, b));
        }
    }

}
