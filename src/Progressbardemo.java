
import java.awt.*;
import javax.swing.*;
import javax.swing.text.AttributeSet.FontAttribute;

public class Progressbardemo {
    JFrame frame1 = new JFrame();
    JProgressBar bar = new JProgressBar();
    JLabel lb1 = new JLabel();

    Progressbardemo() {
        bar.setValue(0);
        bar.setBounds(100, 300, 500, 110);
        bar.setStringPainted(true);
        bar.setFont(new Font("MV Boli", Font.BOLD, 25));
        bar.setForeground(Color.blue);
        frame1.add(bar);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(500, 500);
        lb1.setBounds(50, 100, 150, 150);
        lb1.setText("fuck");
        frame1.setLayout(null);
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);
        frame1.add(lb1);
        fill();

    }

    // public static void main(String[] args) {
    // new Progressbardemo();
    // }
    public void fill() {
        int counter = 0;
        while (counter <= 100) {
            bar.setValue(counter);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            counter += 1;
        }
        bar.setString("Done!!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        frame1.dispose();

    }
}