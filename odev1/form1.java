package odev1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class form1 extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JButton topla;
    private JButton cikar;
    private JButton carp;
    private JButton bol;
    private JLabel sl;
    private JPanel panel;
    float sayi1,sayi2,sonuc;

    form1(){
        add(panel);
        setSize(500,500);
        setTitle("İlk ödevimiz");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        topla.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sayi1 = Float.parseFloat(textField1.getText());
                sayi2 = Float.parseFloat(textField2.getText());
                sonuc = (float)sayi1 + sayi2;
                sl.setText(Float.toString(sonuc));

            }
        });
        cikar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sayi1 = Float.parseFloat(textField1.getText());
                sayi2 = Float.parseFloat(textField2.getText());
                sonuc = (float)sayi1 - sayi2;
                sl.setText(Float.toString(sonuc));
            }
        });
        carp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sayi1 = Float.parseFloat(textField1.getText());
                sayi2 = Float.parseFloat(textField2.getText());
                sonuc = (float)sayi1 * sayi2;
                sl.setText(Float.toString(sonuc));
            }
        });
        bol.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sayi1 = Float.parseFloat(textField1.getText());
                sayi2 = Float.parseFloat(textField2.getText());
                sonuc = (float)sayi1 / sayi2;
                sl.setText(Float.toString(sonuc));
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
