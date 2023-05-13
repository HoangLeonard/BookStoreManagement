package Test;

import javax.swing.*;

public class TestCreateAccount {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new View.CreateAccount();
        } catch (Exception e) {

        }
    }
}
