package hafta04;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.*;
import java.text.ParseException;

public class form1 extends JFrame {
    private JPanel panel;
    private JCheckBox cb1;
    private JCheckBox cb2;
    private JCheckBox cb3;
    private JCheckBox cb4;
    private JButton button1;
    private JRadioButton aRadioButton;
    private JRadioButton bRadioButton;
    private JRadioButton cRadioButton;
    private JRadioButton dRadioButton;
    private JPasswordField passwordField1;
    private JButton button2;
    private JFormattedTextField formattedTextField1;
    private JTextArea textArea1;

    form1(){
        add(panel);
        setTitle("checkbox ve radiobutton");
        setSize(500,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        //radiobutton gruplama
        ButtonGroup bg = new ButtonGroup();
        bg.add(aRadioButton);
        bg.add(bRadioButton);
        bg.add(cRadioButton);
        bg.add(dRadioButton);

        //formatted textfield
        try {
            MaskFormatter mf = new MaskFormatter("(5##) UUU LL AA");
            mf.install(formattedTextField1);
            // Sadece sayı girişi için #
            // Sadece büyük harf için U  (upper)
            // Sadece küçük harf için L  (Lower)
            // Alphanumeric sayı ve harf girişi için A
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


        //textarea
        textArea1.setText("Bugün hava çok güzel \n\tKonya'yı çok seviyoruz\nHas Gonyalı");


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cb1.isSelected()) System.out.println("Müzik seçildi");
                if(cb2.isSelected()) System.out.println("Resim seçildi");
                if(cb3.isSelected()) System.out.println("Spor seçildi");
                if(cb4.isSelected()) System.out.println("Kitap seçildi");
            }
        });

        aRadioButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println("A şıkkı seçildi");
            }
        });

        bRadioButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println("B şıkkı seçildi");
            }
        });

        cRadioButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println("C şıkkı seçildi");
            }
        });

        dRadioButton.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println("D şıkkı seçildi");
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                char[] ps = passwordField1.getPassword();
                //passwordField1.getText();
                button2.setText(ps.toString());
            }
        });
        textArea1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                textArea1.setEnabled(true); //placeholder için
                textArea1.setText("");
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
