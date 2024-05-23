package hafta08;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class form1 extends JFrame{
    private JPanel panel;
    private JTable table1;
    private JTextField textField1;
    private JButton button1;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton silButton;
    private JButton ekleButton;
    private JButton güncelleButton;
    DefaultTableModel modelim = new DefaultTableModel();
    Object[] kolonlar = {"No","Ad","Soyad","Email"};
    Object[] satirlar = new Object[4];
    DefaultComboBoxModel cmodel1 = new DefaultComboBoxModel<>();
    DefaultComboBoxModel cmodel2 = new DefaultComboBoxModel<>();


    form1(){
        add(panel);
        setSize(500,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Veritabani.baglan();
        String sql = "select * from ogrenci";

        tabloGuncelle(sql);

        comboBoxDoldur();


        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql = textField1.getText();
                tabloGuncelle(sql);
            }
        });
        comboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String sql = "select * from ogrenci where numara=" + comboBox1.getSelectedItem().toString();
                //System.out.println(sql);
                textField1.setText(sql);
                tabloGuncelle(sql);

            }
        });
        comboBox2.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String sql = "select * from ogrenci where ad='" + comboBox2.getSelectedItem().toString() + "'";
                textField1.setText(sql);
                tabloGuncelle(sql);
            }
        });
        table1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int a = table1.getSelectedRow();
                textField2.setText(table1.getValueAt(a,0).toString());
                textField3.setText(table1.getValueAt(a,1).toString());
                textField4.setText(table1.getValueAt(a,2).toString());
                textField5.setText(table1.getValueAt(a,3).toString());

            }
        });
        silButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql = "delete from ogrenci where numara="+textField2.getText();
                Veritabani.sil(sql);
                sql = "select * from ogrenci";
                tabloGuncelle(sql);

            }
        });
        ekleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql = "insert into ogrenci (numara,ad,soyad,email) values(" +
                        textField2.getText()+"," +
                        "'"+textField3.getText()+"'," +
                        "'"+textField4.getText()+"'," +
                        "'"+textField5.getText()+"')";
                System.out.println(sql);
                Veritabani.ekle(sql);
                sql = "select * from ogrenci";
                tabloGuncelle(sql);

            }
        });
        güncelleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql = "update ogrenci set " +
                        "ad='"+textField3.getText()+"'," +
                        "soyad='"+textField4.getText()+"'," +
                        "email='"+textField5.getText()+"'" +
                        " where numara="+textField2.getText();
                System.out.println(sql);
                Veritabani.guncelle(sql);
                sql = "select * from ogrenci";
                tabloGuncelle(sql);
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

    void tabloGuncelle(String sql){
        ResultSet rs = Veritabani.listele(sql);

        modelim.setColumnCount(0);
        modelim.setRowCount(0);
        modelim.setColumnIdentifiers(kolonlar);

        try{
            while(rs.next()){
                satirlar[0]=rs.getInt("numara");
                satirlar[1]=rs.getString("ad");
                satirlar[2]=rs.getString("soyad");
                satirlar[3]=rs.getString("email");
                modelim.addRow(satirlar);
            }
            table1.setModel(modelim);
        }catch (SQLException e){
            System.out.println("veritabanı hatası");
        }
    }

    void comboBoxDoldur(){
        ResultSet rs = Veritabani.listele("select * from ogrenci");

        try{
            while(rs.next()){
                satirlar[0]=rs.getInt("numara");
                satirlar[1]=rs.getString("ad");
                cmodel1.addElement(satirlar[0]);
                cmodel2.addElement(satirlar[1]);
            }
            comboBox1.setModel(cmodel1);
            comboBox2.setModel(cmodel2);

        }catch (SQLException e){
            System.out.println("veritabanı hatası");
        }
    }


}
