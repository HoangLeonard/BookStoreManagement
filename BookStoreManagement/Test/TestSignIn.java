package Test;

import javax.swing.*;

public class TestSignIn {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new View.SignIn();
        } catch (Exception e) {

        }
    }
}
