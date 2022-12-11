package View;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;

public class Home extends JFrame {
    public Home() {
        this.setTitle("Book store application v1.0.0");
        Dimension scr = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) scr.getWidth();
        int height = (int) scr.getHeight();
        this.setSize(width*98/100, height*90/100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JTextField jtex = new JTextField("hello", 100);
        JPanel jp = new JPanel();
        jp.setLayout(new BorderLayout());
        jp.add(jtex, BorderLayout.CENTER);

        JButton bt0 = new JButton("0");
        JButton bt1 = new JButton("1");
        JButton bt2 = new JButton("2");
        JButton bt3 = new JButton("3");
        JButton bt4 = new JButton("4");
        JButton bt5 = new JButton("5");
        JButton bt6 = new JButton("6");
        JButton bt7 = new JButton("7");
        JButton bt8 = new JButton("8");
        JButton bt9 = new JButton("9");
        JButton btplus = new JButton("+");
        JButton btminus = new JButton("-");
        JButton btmul = new JButton("*");
        JButton btdiv = new JButton("/");
        JButton bteq = new JButton("=");
        JPanel jbt = new JPanel(new GridLayout(5,3));
        jbt.add(bt0);
        jbt.add(bt1);
        jbt.add(bt2);
        jbt.add(bt3);
        jbt.add(bt4);
        jbt.add(bt5);
        jbt.add(bt6);
        jbt.add(bt7);
        jbt.add(bt8);
        jbt.add(bt9);
        jbt.add(btplus);
        jbt.add(btminus);
        jbt.add(btmul);
        jbt.add(btdiv);
        jbt.add(bteq);

        this.setLayout(new BorderLayout());
        this.add(jp, BorderLayout.NORTH);
        this.add(jbt, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            Home test = new Home();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
