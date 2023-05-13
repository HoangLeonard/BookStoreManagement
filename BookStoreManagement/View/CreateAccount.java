/*
 * Created by JFormDesigner on Mon Dec 19 19:13:22 ICT 2022
 */

package View;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;

/**
 * @author unknown
 */
public class CreateAccount extends JFrame {
    public CreateAccount() {
        this.setLocationRelativeTo(null);
        initComponents();
        ActionListener listener = new Controller.CreateAccount(this);
        this.setActionListener(listener);
        this.setVisible(true);
    }

    private void setActionListener(ActionListener l) {
        button_SignIn.addActionListener(l);
        button_Done.addActionListener(l);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel1 = new JPanel();
        label_Account = new JLabel();
        label_Password = new JLabel();
        textField_Account = new JTextField();
        textField_Password = new JPasswordField();
        button_SignIn = new JButton();
        textField_Warning = new JLabel();
        label_CreateAccount = new JLabel();
        comboBox_Type = new JComboBox<>();
        label_Type = new JLabel();
        label_UserName = new JLabel();
        textField_Phone = new JTextField();
        textField_UserName = new JTextField();
        label_Phone = new JLabel();
        label_Address = new JLabel();
        textField_Address = new JTextField();
        label_Email = new JLabel();
        textField_Email = new JTextField();
        TextArea_Noti = new JTextArea();
        button_Done = new JButton();

        //======== this ========
        setVisible(true);
        setBackground(new Color(0x666666));
        setForeground(SystemColor.controlHighlight);
        var contentPane = getContentPane();
        contentPane.setLayout(new GridLayout());

        //======== panel1 ========
        {
            panel1.setBackground(new Color(0x333333));
            panel1.setForeground(Color.white);

            //---- label_Account ----
            label_Account.setText("UserAccount(*)");
            label_Account.setFont(new Font("Calibri Light", Font.PLAIN, 20));
            label_Account.setForeground(new Color(0xcccccc));

            //---- label_Password ----
            label_Password.setText("Password(*)");
            label_Password.setFont(new Font("Calibri Light", Font.PLAIN, 20));
            label_Password.setForeground(new Color(0xcccccc));

            //---- textField_Account ----
            textField_Account.setFont(new Font("Arial", Font.BOLD, 16));
            textField_Account.setForeground(new Color(0xcccccc));
            textField_Account.setBackground(Color.darkGray);

            //---- textField_Password ----
            textField_Password.setFont(new Font("Arial", Font.BOLD, 16));
            textField_Password.setForeground(new Color(0xcccccc));
            textField_Password.setBackground(Color.darkGray);

            //---- button_SignIn ----
            button_SignIn.setText("create account");
            button_SignIn.setFont(new Font("Calibri", Font.BOLD, 14));
            button_SignIn.setForeground(Color.white);
            button_SignIn.setBackground(Color.darkGray);

            //---- textField_Warning ----
            textField_Warning.setFont(new Font("Arial", Font.ITALIC, 14));
            textField_Warning.setText("(*) not null field");
            textField_Warning.setForeground(new Color(0x666666));
            textField_Warning.setOpaque(true);
            textField_Warning.setBackground(new Color(0x333333));
            textField_Warning.setEnabled(false);

            //---- label_CreateAccount ----
            label_CreateAccount.setText("Create new Account:");
            label_CreateAccount.setFont(new Font("Calibri Light", Font.PLAIN, 20));
            label_CreateAccount.setForeground(new Color(0xcccccc));

            //---- comboBox_Type ----
            comboBox_Type.setModel(new DefaultComboBoxModel<>(new String[] {
                "client",
                "staff",
                "admin"
            }));
            comboBox_Type.setFont(new Font("Calibri", Font.PLAIN, 14));
            comboBox_Type.setBackground(new Color(0x999999));
            comboBox_Type.setForeground(Color.black);
            comboBox_Type.setEnabled(false);

            //---- label_Type ----
            label_Type.setText("Type");
            label_Type.setFont(new Font("Calibri Light", Font.PLAIN, 20));
            label_Type.setForeground(new Color(0xcccccc));

            //---- label_UserName ----
            label_UserName.setText("User name(*)");
            label_UserName.setFont(new Font("Calibri Light", Font.PLAIN, 20));
            label_UserName.setForeground(new Color(0xcccccc));

            //---- textField_Phone ----
            textField_Phone.setFont(new Font("Arial", Font.BOLD, 16));
            textField_Phone.setForeground(new Color(0xcccccc));
            textField_Phone.setBackground(Color.darkGray);

            //---- textField_UserName ----
            textField_UserName.setFont(new Font("Arial", Font.BOLD, 16));
            textField_UserName.setForeground(new Color(0xcccccc));
            textField_UserName.setBackground(Color.darkGray);

            //---- label_Phone ----
            label_Phone.setText("Phone(*)");
            label_Phone.setFont(new Font("Calibri Light", Font.PLAIN, 20));
            label_Phone.setForeground(new Color(0xcccccc));

            //---- label_Address ----
            label_Address.setText("Address(*)");
            label_Address.setFont(new Font("Calibri Light", Font.PLAIN, 20));
            label_Address.setForeground(new Color(0xcccccc));

            //---- textField_Address ----
            textField_Address.setFont(new Font("Arial", Font.BOLD, 16));
            textField_Address.setForeground(new Color(0xcccccc));
            textField_Address.setBackground(Color.darkGray);

            //---- label_Email ----
            label_Email.setText("Email");
            label_Email.setFont(new Font("Calibri Light", Font.PLAIN, 20));
            label_Email.setForeground(new Color(0xcccccc));

            //---- textField_Email ----
            textField_Email.setFont(new Font("Arial", Font.BOLD, 16));
            textField_Email.setForeground(new Color(0xcccccc));
            textField_Email.setBackground(Color.darkGray);

            //---- TextArea_Noti ----
            TextArea_Noti.setForeground(new Color(0xcccccc));
            TextArea_Noti.setFont(new Font("Calibri", Font.ITALIC, 14));
            TextArea_Noti.setBackground(Color.darkGray);

            //---- button_Done ----
            button_Done.setText("Done");
            button_Done.setFont(new Font("Calibri", Font.BOLD, 14));
            button_Done.setForeground(Color.white);
            button_Done.setBackground(Color.darkGray);

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGroup(panel1Layout.createParallelGroup()
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(TextArea_Noti))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(label_Email, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(textField_Email, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                            .addComponent(label_Address, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(label_Phone, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(panel1Layout.createParallelGroup()
                                            .addComponent(textField_Address, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textField_Phone, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(label_Account, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(label_Password, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(label_UserName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(label_Type, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                            .addComponent(textField_UserName, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                                            .addComponent(textField_Password, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                                            .addComponent(textField_Account, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                                            .addComponent(comboBox_Type, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(panel1Layout.createSequentialGroup()
                                        .addComponent(textField_Warning, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(button_SignIn, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(button_Done)
                                        .addGap(20, 20, 20)))
                                .addGap(0, 16, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addGap(0, 139, Short.MAX_VALUE)
                        .addComponent(label_CreateAccount, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
                        .addGap(112, 112, 112))
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(label_CreateAccount, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addComponent(label_Account, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField_Account, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(label_Password, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField_Password, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label_Type, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBox_Type, GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(label_UserName, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField_UserName, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label_Phone, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField_Phone, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label_Address, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField_Address, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label_Email, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textField_Email, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(textField_Warning, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_SignIn)
                            .addComponent(button_Done))
                        .addGap(18, 18, 18)
                        .addComponent(TextArea_Noti, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(16, Short.MAX_VALUE))
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
    private JButton button_SignIn;
    private JLabel textField_Warning;
    private JLabel label_CreateAccount;
    private JComboBox<String> comboBox_Type;
    private JLabel label_Type;
    private JLabel label_UserName;
    private JTextField textField_Phone;
    private JTextField textField_UserName;
    private JLabel label_Phone;
    private JLabel label_Address;
    private JTextField textField_Address;
    private JLabel label_Email;
    private JTextField textField_Email;
    private JTextArea TextArea_Noti;
    private JButton button_Done;
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

    public JButton getButton_SignIn() {
        return button_SignIn;
    }

    public void setButton_SignIn(JButton button_SignIn) {
        this.button_SignIn = button_SignIn;
    }

    public JLabel getTextField_Warning() {
        return textField_Warning;
    }

    public void setTextField_Warning(JLabel textField_Warning) {
        this.textField_Warning = textField_Warning;
    }

    public JLabel getLabel_CreateAccount() {
        return label_CreateAccount;
    }

    public void setLabel_CreateAccount(JLabel label_CreateAccount) {
        this.label_CreateAccount = label_CreateAccount;
    }

    public JComboBox<String> getComboBox_Type() {
        return comboBox_Type;
    }

    public void setComboBox_Type(JComboBox<String> comboBox_Type) {
        this.comboBox_Type = comboBox_Type;
    }

    public JLabel getLabel_Type() {
        return label_Type;
    }

    public void setLabel_Type(JLabel label_Type) {
        this.label_Type = label_Type;
    }

    public JLabel getLabel_UserName() {
        return label_UserName;
    }

    public void setLabel_UserName(JLabel label_UserName) {
        this.label_UserName = label_UserName;
    }

    public JTextField getTextField_Phone() {
        return textField_Phone;
    }

    public void setTextField_Phone(JTextField textField_Phone) {
        this.textField_Phone = textField_Phone;
    }

    public JTextField getTextField_UserName() {
        return textField_UserName;
    }

    public void setTextField_UserName(JTextField textField_UserName) {
        this.textField_UserName = textField_UserName;
    }

    public JLabel getLabel_Phone() {
        return label_Phone;
    }

    public void setLabel_Phone(JLabel label_Phone) {
        this.label_Phone = label_Phone;
    }

    public JLabel getLabel_Address() {
        return label_Address;
    }

    public void setLabel_Address(JLabel label_Address) {
        this.label_Address = label_Address;
    }

    public JTextField getTextField_Address() {
        return textField_Address;
    }

    public void setTextField_Address(JTextField textField_Address) {
        this.textField_Address = textField_Address;
    }

    public JLabel getLabel_Email() {
        return label_Email;
    }

    public void setLabel_Email(JLabel label_Email) {
        this.label_Email = label_Email;
    }

    public JTextField getTextField_Email() {
        return textField_Email;
    }

    public void setTextField_Email(JTextField textField_Email) {
        this.textField_Email = textField_Email;
    }

    public JTextArea getTextArea_Noti() {
        return TextArea_Noti;
    }

    public void setTextArea_Noti(JTextArea textArea_Noti) {
        TextArea_Noti = textArea_Noti;
    }
}
