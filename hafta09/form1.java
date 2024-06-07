package hafta09;

import javax.swing.*;
import java.util.TimerTask;
import java.util.Timer;

public class form1 extends JFrame{
    private JButton button1;
    private JPanel panel;
    private JButton button2;
    Timer t = new Timer();
    static int hiz1x,hiz1y,hiz2x,hiz2y;
    static int x1,y1,x2,y2;

    form1(){
        add(panel);
        setSize(500,500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //button1.setSize(50,50);
        button1.setBounds(0,0,50,50);
        button2.setBounds(200,200,50,50);
        hiz1x=5;
        hiz1y=8;
        x1=y1=0;
        hiz2x=4;
        hiz2y=3;
        x2=y2=0;

        TimerTask g = new TimerTask() {
            @Override
            public void run() {
                    x1+=hiz1x;
                    y1+=hiz1y;
                    x2+=hiz2x;
                    y2+=hiz2y;
                    button1.setBounds(x1, y1, 50, 50);
                    button2.setBounds(x2, y2, 50, 50);
                if (button1.getBounds().x>430 || button1.getBounds().x<0) {
                    hiz1x*=-1;
                }
                if (button1.getBounds().y>420 || button1.getBounds().y<0) {
                    hiz1y*=-1;
                }
                if (button2.getBounds().x>430 || button2.getBounds().x<0) {
                    hiz2x*=-1;
                }
                if (button2.getBounds().y>420 || button2.getBounds().y<0) {
                    hiz2y*=-1;
                }
            }
        };

        t.schedule(g,0,10);


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
