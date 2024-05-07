package hafta06;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class form2 extends JFrame{
    private JPanel panel;
    private JProgressBar progressBar1;
    private JButton button1;

    form2(){
        add(panel);
        setSize(500,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for(int i=0;i<=100;i++){
                            try {
                                TimeUnit.MILLISECONDS.sleep(50);
                            } catch (InterruptedException ex) {
                                throw new RuntimeException(ex);
                            }

                            progressBar1.setValue(i);
                        }
                    }
                }).start();


            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                form2 f = new form2();
                f.setVisible(true);
            }
        });
    }
}
