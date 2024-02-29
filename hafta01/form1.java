package hafta01;

import javax.swing.*;

public class form1 extends JFrame {
    private JTextField textField1;
    private JButton işlemYapButton;
    private JPanel panel;


    form1(){
        add(panel);
        setSize(500,500);
        setTitle("İlk form uygulamamız");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
