package hafta06;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class form1 extends JFrame {
    private JPanel panel;
    private JTextField textField1;
    private JButton button1;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JButton button2;
    private JRadioButton radioButton3;
    private JPanel panelsari;
    private JPanel panelmavi;
    private JTabbedPane tabbedPane1;
    private JButton button3;
    private JTextField textField2;
    boolean durum = true;

    form1(){
        add(panel);
        setSize(500,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(durum){
                    panelsari.setVisible(false);
                    durum = false;
                } else {
                    panelsari.setVisible(true);
                    durum = true;
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
