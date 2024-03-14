package odev5;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class form1 extends JFrame{
    private JPanel panel;
    private JSlider vs;
    private JSlider os;
    private JSlider fs;
    private JSlider orts;
    private JLabel vl;
    private JLabel ol;
    private JLabel fl;
    private JLabel ortl;
    int v,o,f;
    float ort;

    form1(){
        add(panel);
        setSize(500,300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        vs.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                v = vs.getValue();
                vl.setText(Integer.toString(v));
                o = os.getValue();
                f = fs.getValue();
                ort = ((float)v+o+f)/2;
                orts.setValue(Math.round(ort));
                ortl.setText(Integer.toString(Math.round(ort)));
                if(Math.round(ort)>=60){
                    orts.setBackground(Color.GREEN);
                } else if(Math.round(ort)>=55 && Math.round(ort)<60){
                    orts.setBackground(Color.ORANGE);
                } else if(Math.round(ort)<55){
                    orts.setBackground(Color.RED);
                }
            }
        });
        os.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                v = vs.getValue();

                o = os.getValue();
                ol.setText(Integer.toString(o));
                f = fs.getValue();
                ort = ((float)v+o+f)/2;
                orts.setValue(Math.round(ort));
                ortl.setText(Integer.toString(Math.round(ort)));
                if(Math.round(ort)>=60){
                    orts.setBackground(Color.GREEN);
                } else if(Math.round(ort)>=55 && Math.round(ort)<60){
                    orts.setBackground(Color.ORANGE);
                } else if(Math.round(ort)<55){
                    orts.setBackground(Color.RED);
                }
            }
        });
        fs.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                v = vs.getValue();

                o = os.getValue();

                f = fs.getValue();
                fl.setText(Integer.toString(f));
                ort = ((float)v+o+f)/2;
                orts.setValue(Math.round(ort));
                ortl.setText(Integer.toString(Math.round(ort)));
                if(Math.round(ort)>=60){
                    orts.setBackground(Color.GREEN);
                } else if(Math.round(ort)>=55 && Math.round(ort)<60){
                    orts.setBackground(Color.ORANGE);
                } else if(Math.round(ort)<55){
                    orts.setBackground(Color.RED);
                }
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
