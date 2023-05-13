package Test;

import View.Home;
import View.SignIn;


import javax.swing.*;

public class Application {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
//            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("Fail to set Look And Feel");
        }
        View.SignIn signIn = new SignIn();
    }
}
