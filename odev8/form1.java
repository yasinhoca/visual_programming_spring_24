package odev8;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

public class form1 extends  JFrame{
    private JPanel panel;
    private JTable table1;
    private JTable table2;
    private JTable table3;
    private JSpinner sr;
    private JSpinner sc;
    DefaultTableModel model1 = new DefaultTableModel();
    DefaultTableModel model2 = new DefaultTableModel();
    DefaultTableModel model3 = new DefaultTableModel();
    int r,c;


    form1(){
        add(panel);
        setSize(800,500);
        setTitle("MATRIS Toplama");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        sr.setValue(3);
        sc.setValue(3);

        tablolariSifirla();



        sr.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                tablolariSifirla();
                r = (int) sr.getValue();
                c = (int) sc.getValue();
                model1.setRowCount(r);
                model1.setColumnCount(c);
                table1.setModel(model1);
                model2.setRowCount(r);
                model2.setColumnCount(c);
                table2.setModel(model2);
                model3.setRowCount(r);
                model3.setColumnCount(c);
                table3.setModel(model3);
                int[][] m1 = Matris.uret(r,c);
                int[][] m2 = Matris.uret(r,c);
                int[][] mt = new int[r][c];

                int i,j;
                for(i=0;i<r;i++){
                    for(j=0;j<c;j++){
                        table1.setValueAt(m1[i][j],i,j);
                        table2.setValueAt(m2[i][j],i,j);
                        mt[i][j] = m1[i][j] + m2[i][j];
                        table3.setValueAt(mt[i][j],i,j);
                    }
                }



            }
        });

        sc.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                tablolariSifirla();
                r = (int) sr.getValue();
                c = (int) sc.getValue();
                model1.setRowCount(r);
                model1.setColumnCount(c);
                table1.setModel(model1);
                model2.setRowCount(r);
                model2.setColumnCount(c);
                table2.setModel(model2);
                model3.setRowCount(r);
                model3.setColumnCount(c);
                table3.setModel(model3);
                int[][] m1 = Matris.uret(r,c);
                int[][] m2 = Matris.uret(r,c);
                int[][] mt = new int[r][c];

                int i,j;
                for(i=0;i<r;i++){
                    for(j=0;j<c;j++){
                        table1.setValueAt(m1[i][j],i,j);
                        table2.setValueAt(m2[i][j],i,j);
                        mt[i][j] = m1[i][j] + m2[i][j];
                        table3.setValueAt(mt[i][j],i,j);
                    }
                }
            }
        });
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                form1 f= new form1();
                f.setVisible(true);
            }
        });
    }

    void  tablolariSifirla(){
        model1.setRowCount(0);
        model1.setColumnCount(0);
        table1.setModel(model1);
        table1.setTableHeader(null);
        model2.setRowCount(0);
        model2.setColumnCount(0);
        table2.setModel(model2);
        table2.setTableHeader(null);
        model3.setRowCount(0);
        model3.setColumnCount(0);
        table3.setModel(model3);
        table3.setTableHeader(null);
    }

}
