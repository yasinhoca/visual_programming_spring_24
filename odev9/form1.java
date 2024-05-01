package odev9;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class form1 extends JFrame {
    private JPanel panel;
    private JTable table1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    DefaultTableModel model = new DefaultTableModel();
    ArrayList<Integer> l = new ArrayList<>();


    form1() {
        add(panel);
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        model.setRowCount(5);
        model.setColumnCount(5);
        table1.setModel(model);
        table1.setTableHeader(null);
        table1.setRowHeight(65);


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                l = listeUret();
                System.out.println(l);
                listeYerlestir(l);
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Collections.sort(l);
                listeYerlestir(l);
            }
        });
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Collections.sort(l);
                Collections.reverse(l);
                listeYerlestir(l);
            }
        });
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Collections.shuffle(l);
                listeYerlestir(l);
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

    ArrayList<Integer> listeUret() {
        ArrayList<Integer> liste = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i < 25; i++) {
            liste.add(r.nextInt(100));
        }
        return liste;
    }

    void listeYerlestir(ArrayList<Integer> l) {
        tabloSifirla();
        model.setRowCount(5);
        model.setColumnCount(5);
        table1.setModel(model);
        for (int i = 0; i < 5; i++) {
            table1.setValueAt(l.get(i), 0, i);
        }
        for (int i = 5; i < 10; i++) {
            table1.setValueAt(l.get(i), 1, i % 5);
        }
        for (int i = 10; i < 15; i++) {
            table1.setValueAt(l.get(i), 2, i % 5);
        }
        for (int i = 15; i < 20; i++) {
            table1.setValueAt(l.get(i), 3, i % 5);
        }
        for (int i = 20; i < 25; i++) {
            table1.setValueAt(l.get(i), 4, i % 5);
        }
    }

    void tabloSifirla(){
        model.setRowCount(0);
        model.setColumnCount(0);
        table1.setModel(model);
    }

}
