package hafta02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class form1 extends  JFrame {
    private JButton button1;
    private JPanel panel;
    private JButton button2;
    private JLabel lbl1;
    private JComboBox comboBox1;
    private JLabel lbl2;
    private JComboBox gb;
    private JButton button3;
    private JComboBox rb;
    private JComboBox bb;
    DefaultComboBoxModel modelimg = new DefaultComboBoxModel();
    DefaultComboBoxModel modelimr = new DefaultComboBoxModel();
    DefaultComboBoxModel modelimb = new DefaultComboBoxModel();
    int r,g,b;

    form1(){
        add(panel);
        setSize(500,500);
        setTitle("Mouse Eventler");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Image icon1 = new ImageIcon(this.getClass().getResource("/icon1.png")).getImage();
        button2.setIcon(new ImageIcon(icon1));

        Image kirmizi = new ImageIcon(this.getClass().getResource("/bkirmizi.png")).getImage();
        lbl1.setIcon(new ImageIcon(kirmizi));
        Image mavi = new ImageIcon(this.getClass().getResource("/bmavi.png")).getImage();
        Image yesil = new ImageIcon(this.getClass().getResource("/byesil.png")).getImage();

        for(int i=0;i<256;i++) modelimg.addElement(i);
        gb.setModel(modelimg);
        for(int i=0;i<256;i++) modelimr.addElement(i);
        rb.setModel(modelimr);
        for(int i=0;i<256;i++) modelimb.addElement(i);
        bb.setModel(modelimb);


        button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                button1.setBackground(Color.BLUE);
                super.mouseReleased(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                button1.setBackground(Color.RED);
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button1.setBackground(Color.GREEN);
                super.mouseExited(e);
            }
        });


        lbl1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                lbl1.setIcon(new ImageIcon(yesil));
                super.mouseReleased(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lbl1.setIcon(new ImageIcon(mavi));
                System.out.println("imleç üzerinde");
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lbl1.setIcon(new ImageIcon(kirmizi));
                System.out.println("imleç çıktı");
                super.mouseExited(e);
            }
        });


        comboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                //lbl2.setText(comboBox1.getSelectedItem().toString());
                //lbl2.setText(Integer.toString(comboBox1.getSelectedIndex()));
            }
        });
        rb.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                r = (int) rb.getSelectedItem();
                g = (int) gb.getSelectedItem();
                b = (int) bb.getSelectedItem();
                button3.setBackground(new Color(r,g,b));
                rb.setBackground(new Color(r,0,0));
            }
        });
        gb.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                r = (int) rb.getSelectedItem();
                g = (int) gb.getSelectedItem();
                b = (int) bb.getSelectedItem();
                button3.setBackground(new Color(r,g,b));
                gb.setBackground(new Color(0,g,0));
            }
        });
        bb.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                r = (int) rb.getSelectedItem();
                g = (int) gb.getSelectedItem();
                b = (int) bb.getSelectedItem();
                button3.setBackground(new Color(r,g,b));
                bb.setBackground(new Color(0,0,b));
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
