package odev7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class form1 extends JFrame{
    private JPanel panel;
    private JFormattedTextField formattedTextField1;
    private JLabel lbl1;
    private JTextField textField1;

    form1(){
       add(panel);
       setSize(500,500);
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        lbl1.setOpaque(true);

       textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if(textField1.getText().length()==11){
                    int toplam = 0;
                    String s = textField1.getText();
                    for(int i=0;i<10;i++){
                        toplam += Integer.parseInt(Character.toString(s.charAt(i)));
                    }
                    System.out.println(toplam);
                    if(toplam%2==0 && toplam%10==Integer.parseInt(Character.toString(s.charAt(10)))){
                        lbl1.setText("GEÇERLİ");
                        lbl1.setBackground(Color.GREEN);
                    } else {
                        lbl1.setText("GEÇERSİZ");
                        lbl1.setBackground(Color.RED);
                    }
                }
                super.keyReleased(e);
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
