/*
 * Created by JFormDesigner on Mon Dec 19 11:22:27 ICT 2022
 */

package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;

public class SignIn extends JFrame {
    public SignIn() {
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        initComponents();
        ActionListener listener = new Controller.SignIn(this);
        this.setActionListener(listener);
        this.setVisible(true);
    }

    private void setActionListener(ActionListener l) {
        this.button_CreateAccount.addActionListener(l);
        this.button_SignIn.addActionListener(l);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel1 = new JPanel();
        label_Account = new JLabel();
        label_Password = new JLabel();
        textField_Account = new JTextField();
        textField_Password = new JPasswordField();
        button_CreateAccount = new JButton();
        button_SignIn = new JButton();
        textField_Noti = new JLabel();

        //======== this ========
        setVisible(true);
        setTitle("Sign In");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new Color(0x666666));
        setForeground(SystemColor.controlHighlight);
        var contentPane = getContentPane();
        contentPane.setLayout(new GridLayout());

        //======== panel1 ========
        {
            panel1.setBackground(new Color(0x333333));
            panel1.setForeground(Color.white);

            //---- label_Account ----
            label_Account.setText("Account");
            label_Account.setFont(new Font("Calibri", Font.BOLD, 20));
            label_Account.setForeground(new Color(0xcccccc));

            //---- label_Password ----
            label_Password.setText("Password");
            label_Password.setFont(new Font("Calibri", Font.BOLD, 20));
            label_Password.setForeground(new Color(0xcccccc));

            //---- button_CreateAccount ----
            button_CreateAccount.setText("Create new Client Account");
            button_CreateAccount.setFont(new Font("Calibri", Font.BOLD, 14));
            button_CreateAccount.setForeground(new Color(0x333333));
            button_CreateAccount.setBackground(Color.darkGray);

            //---- button_SignIn ----
            button_SignIn.setText("Sign in");
            button_SignIn.setFont(new Font("Calibri", Font.BOLD, 14));
            button_SignIn.setForeground(new Color(0x333333));
            button_SignIn.setBackground(Color.darkGray);

            //---- textField_Noti ----
            textField_Noti.setFont(new Font("Arial", Font.ITALIC, 14));

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                                .addComponent(label_Account, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textField_Account))
                            .addGroup(GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                                .addComponent(label_Password, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textField_Password))
                            .addGroup(GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                                .addComponent(button_CreateAccount)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                                .addComponent(button_SignIn, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                            .addComponent(textField_Noti, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(43, 43, 43))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label_Account, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField_Account, GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label_Password, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField_Password, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(button_CreateAccount)
                            .addComponent(button_SignIn))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textField_Noti, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(37, Short.MAX_VALUE))
            );
        }
        contentPane.add(panel1);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel1;
    private JLabel label_Account;
    private JLabel label_Password;
    private JTextField textField_Account;
    private JPasswordField textField_Password;
    private JButton button_CreateAccount;
    private JButton button_SignIn;
    private JLabel textField_Noti;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on


    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JLabel getLabel_Account() {
        return label_Account;
    }

    public void setLabel_Account(JLabel label_Account) {
        this.label_Account = label_Account;
    }

    public JLabel getLabel_Password() {
        return label_Password;
    }

    public void setLabel_Password(JLabel label_Password) {
        this.label_Password = label_Password;
    }

    public JTextField getTextField_Account() {
        return textField_Account;
    }

    public void setTextField_Account(JTextField textField_Account) {
        this.textField_Account = textField_Account;
    }

    public JPasswordField getTextField_Password() {
        return textField_Password;
    }

    public void setTextField_Password(JPasswordField textField_Password) {
        this.textField_Password = textField_Password;
    }

    public JButton getButton_CreateAccount() {
        return button_CreateAccount;
    }

    public void setButton_CreateAccount(JButton button_CreateAccount) {
        this.button_CreateAccount = button_CreateAccount;
    }

    public JButton getButton_SignIn() {
        return button_SignIn;
    }

    public void setButton_SignIn(JButton button_SignIn) {
        this.button_SignIn = button_SignIn;
    }

    public JLabel getTextField_Noti() {
        return textField_Noti;
    }

    public void setTextField_Noti(JLabel textField_Noti) {
        this.textField_Noti = textField_Noti;
    }
}
