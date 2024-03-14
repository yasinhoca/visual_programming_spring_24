package hafta03;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class form1 extends JFrame {
    private JPanel panel;
    private JSpinner spinner1;
    private JLabel lbl1;
    private JSlider rs;
    private JSlider gs;
    private JSlider bs;
    private JButton button1;
    int r,g,b;

    form1(){
        add(panel);
        setSize(500,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        spinner1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                lbl1.setText(Integer.toString((int)spinner1.getValue()));
            }
        });
        rs.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
               renkDegistir();
               rs.setBackground(new Color(rs.getValue(),0,0));
            }
        });
        gs.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                renkDegistir();
                gs.setBackground(new Color(0,gs.getValue(),0));

            }
        });
        bs.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                renkDegistir();
                bs.setBackground(new Color(0,0,bs.getValue()));

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

    void renkDegistir(){
        r = rs.getValue();
        g = gs.getValue();
        b = bs.getValue();
        button1.setBackground(new Color(r,g,b));
    }
}
