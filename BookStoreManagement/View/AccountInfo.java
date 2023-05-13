package View;

        import Controller.DatabaseConnector;
        import Model.Account;

        import java.awt.*;
        import java.awt.event.*;
        import java.sql.Connection;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import javax.swing.*;
        import javax.swing.GroupLayout;
        import javax.swing.border.EmptyBorder;

public class AccountInfo extends JFrame {

    private DatabaseConnector db;
    private Connection c;
    private Account account;
    private Home home;

    public AccountInfo(DatabaseConnector db, Home home) {
        System.out.println("View: Creating AccountInfo GUI.");
        this.db = new DatabaseConnector("root", "");
        c = db.getConnection();
        this.home = home;
        this.account = home.getAccount();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.initComponents();
        this.textField_AID.setText(account.getAccountID());
        this.textField_Account.setText(account.getUserAccount());
        this.textField_Username.setText(account.getName());
        this.textField_Address.setText(account.getAddress());
        this.textField_Type.setText(account.getType());
        this.textField_Email.setText(account.getEmail());
        this.textField_Phone.setText(account.getPhone());
        this.textField_Password.setText("*************");
        this.setVisible(true);
        System.out.println("View: Created AccountInfo GUI.");
    }

    private void controler(ActionEvent e) {
        // TODO add your code here
        if (e.getActionCommand().equals("update")) {
            System.out.println("click on update");
            String accountID = textField_AID.getText();
            String name = textField_Username.getText();
            String phone = textField_Phone.getText();
            String address = textField_Address.getText();
            String email = textField_Email.getText();
            String query = "UPDATE account SET Name = '" + name + "', Phone = '" + phone + "', Address = '" + address + "', Email = '" + email
                    + "' WHERE AccountID = '" + accountID + "'";
            System.out.println("execute:\n" + query);
            try {
                c.createStatement().execute(query);
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
            this.account.setName(name);
            this.account.setAddress(address);
            this.account.setEmail(email);
            this.account.setPhone(phone);
        } else if (e.getActionCommand().equals("done")) {
            System.out.println("click on done");
            this.dispose();
        } else if (e.getActionCommand().equals("changepw")) {
            System.out.println("click on update password");

            class ModifyPassword extends JDialog{
                private View.AccountInfo view;
                private DatabaseConnector db;

                public ModifyPassword(AccountInfo view, DatabaseConnector db) {
                    System.out.println("View: Creating ModifyPassword GUI.");
                    initComponents();
                    this.view = view;
                    this.db = db;
                    this.setVisible(true);
                    System.out.println("View: Created ModifyPassword GUI.");
                }

                private void controller(ActionEvent e) {
                    // TODO add your code here
                    if (e.getActionCommand().equals("OK")) {
                        System.out.println("click on OK");
                        if (Account.isValidPassword(passwordField_NPW.getText())) {
                            if (passwordField_NPW.getText().equals(passwordField_CNPW.getText())) {
                                String oldPw = passwordField_OPW.getText();
                                String newPw = passwordField_NPW.getText();
                                try {
                                    String query = "SELECT * FROM account " +
                                            "WHERE UserAccount LIKE '" + view.account.getUserAccount() + "' AND Password LIKE PASSWORD('" + oldPw + "')";
                                    ResultSet res = db.getConnection().createStatement().executeQuery(query);
                                    if (res.next()) {
                                        query = "UPDATE account SET Password = '" + newPw + "' WHERE AccountID = '" + view.account.getAccountID() + "'";
                                        db.getConnection().createStatement().execute(query);
                                        this.dispose();
                                        JOptionPane.showMessageDialog(this, "Update password successfully!", "", JOptionPane.INFORMATION_MESSAGE);
                                    } else JOptionPane.showMessageDialog(this, "Password your not matching with the older!", "", JOptionPane.INFORMATION_MESSAGE);
                                } catch (SQLException sqlException) {
                                    System.out.println("DB error: Can not check old password.");
                                    JOptionPane.showMessageDialog(this, "Fail to update new password", "Error DB connect", JOptionPane.ERROR_MESSAGE);
                                }
                            } else JOptionPane.showMessageDialog(this, "new passwords not matching!", "Error", JOptionPane.INFORMATION_MESSAGE);
                        } else JOptionPane.showMessageDialog(this, "enter the valid new password!");
                    } else if (e.getActionCommand().equals("Cancel")) {
                        System.out.println("click on Cancel");
                        this.dispose();
                    }
                }

                private void initComponents() {
                    // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
                    contentPanel = new JPanel();
                    label_OPW = new JLabel();
                    label_NPW = new JLabel();
                    label_CNPW = new JLabel();
                    passwordField_OPW = new JPasswordField();
                    passwordField_NPW = new JPasswordField();
                    passwordField_CNPW = new JPasswordField();
                    textArea1 = new JTextArea();
                    buttonBar = new JPanel();
                    okButton = new JButton();
                    cancelButton = new JButton();

                    //======== this ========
                    var contentPane = getContentPane();

                    //======== contentPanel ========
                    {

                        //---- label_OPW ----
                        label_OPW.setText("Old Password");
                        label_OPW.setFont(new Font("Calibri", Font.PLAIN, 14));

                        //---- label_NPW ----
                        label_NPW.setText("New Password");
                        label_NPW.setFont(new Font("Calibri", Font.PLAIN, 14));

                        //---- label_CNPW ----
                        label_CNPW.setText("Check new password");
                        label_CNPW.setFont(new Font("Calibri", Font.PLAIN, 14));

                        //---- passwordField_OPW ----
                        passwordField_OPW.setOpaque(true);
                        passwordField_OPW.setFont(new Font("Calibri", Font.PLAIN, 14));

                        //---- passwordField_NPW ----
                        passwordField_NPW.setOpaque(true);
                        passwordField_NPW.setFont(new Font("Calibri", Font.PLAIN, 14));

                        //---- passwordField_CNPW ----
                        passwordField_CNPW.setOpaque(true);
                        passwordField_CNPW.setFont(new Font("Calibri", Font.PLAIN, 14));

                        //---- textArea1 ----
                        textArea1.setText("Password: \n   [6-20] characters long\n   Containing 1 numeric character [0-9]\n   Containing 1 uppercase and 1 lower character\n   Contain 1 character in the set of characters [@#$%!]");
                        textArea1.setFont(new Font("Calibri", Font.PLAIN, 15));
                        textArea1.setEditable(false);
                        textArea1.setOpaque(true);

                        //======== buttonBar ========
                        {
                            buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                            buttonBar.setLayout(new GridBagLayout());
                            ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 85, 80};
                            ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0, 0.0};

                            //---- okButton ----
                            okButton.setText("OK");
                            okButton.addActionListener(e -> controller(e));
                            buttonBar.add(okButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                    new Insets(0, 0, 0, 5), 0, 0));

                            //---- cancelButton ----
                            cancelButton.setText("Cancel");
                            cancelButton.addActionListener(e -> controller(e));
                            buttonBar.add(cancelButton, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
                                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                    new Insets(0, 0, 0, 0), 0, 0));
                        }

                        GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                        contentPanel.setLayout(contentPanelLayout);
                        contentPanelLayout.setHorizontalGroup(
                                contentPanelLayout.createParallelGroup()
                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(buttonBar, GroupLayout.PREFERRED_SIZE, 379, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(11, Short.MAX_VALUE))
                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                                .addGroup(contentPanelLayout.createParallelGroup()
                                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                                                .addGap(14, 14, 14)
                                                                .addGroup(contentPanelLayout.createParallelGroup()
                                                                        .addComponent(label_OPW, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(label_NPW, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(label_CNPW))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(passwordField_CNPW, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                                                                        .addComponent(passwordField_NPW)
                                                                        .addComponent(passwordField_OPW)))
                                                        .addGroup(contentPanelLayout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(textArea1)))
                                                .addContainerGap())
                        );
                        contentPanelLayout.setVerticalGroup(
                                contentPanelLayout.createParallelGroup()
                                        .addGroup(GroupLayout.Alignment.TRAILING, contentPanelLayout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(label_OPW, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(passwordField_OPW, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(22, 22, 22)
                                                .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(label_NPW, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(passwordField_NPW, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(22, 22, 22)
                                                .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(label_CNPW, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(passwordField_CNPW, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGap(10, 10, 10)
                                                .addComponent(textArea1, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(buttonBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(15, Short.MAX_VALUE))
                        );
                    }

                    GroupLayout contentPaneLayout = new GroupLayout(contentPane);
                    contentPane.setLayout(contentPaneLayout);
                    contentPaneLayout.setHorizontalGroup(
                            contentPaneLayout.createParallelGroup()
                                    .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addContainerGap()
                                            .addComponent(contentPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addContainerGap())
                    );
                    contentPaneLayout.setVerticalGroup(
                            contentPaneLayout.createParallelGroup()
                                    .addGroup(contentPaneLayout.createSequentialGroup()
                                            .addContainerGap()
                                            .addComponent(contentPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addContainerGap())
                    );
                    pack();
                    setLocationRelativeTo(getOwner());
                    // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
                }

                // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
                private JPanel contentPanel;
                private JLabel label_OPW;
                private JLabel label_NPW;
                private JLabel label_CNPW;
                private JPasswordField passwordField_OPW;
                private JPasswordField passwordField_NPW;
                private JPasswordField passwordField_CNPW;
                private JTextArea textArea1;
                private JPanel buttonBar;
                private JButton okButton;
                private JButton cancelButton;
                // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
            }
            ModifyPassword tmp = new ModifyPassword(this, db);
        } else if (e.getActionCommand().equals("log out")) {
            System.out.println("click on log out");
            this.dispose();
            home.dispose();
            new SignIn();
        }
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        label_AID = new JLabel();
        textField_AID = new JTextField();
        label_Account = new JLabel();
        textField_Account = new JTextField();
        label_Password = new JLabel();
        textField_Password = new JPasswordField();
        label_Type = new JLabel();
        textField_Type = new JTextField();
        label_Username = new JLabel();
        textField_Username = new JTextField();
        label_Address = new JLabel();
        textField_Address = new JTextField();
        label_Phone = new JLabel();
        textField_Phone = new JTextField();
        label_Email = new JLabel();
        textField_Email = new JTextField();
        button_Update = new JButton();
        button_Done = new JButton();
        label9 = new JLabel();
        separator1 = new JSeparator();
        button_ChangePW = new JButton();
        button_Logout = new JButton();

        //======== this ========
        setBackground(UIManager.getColor("Panel.background"));
        setFont(new Font("Calibri", Font.PLAIN, 12));
        var contentPane = getContentPane();

        //---- label_AID ----
        label_AID.setText("Account id");
        label_AID.setBackground(Color.darkGray);
        label_AID.setForeground(new Color(0x0099cc));
        label_AID.setFont(new Font("Calibri", Font.PLAIN, 18));

        //---- textField_AID ----
        textField_AID.setBackground(Color.darkGray);
        textField_AID.setForeground(new Color(0xcccccc));
        textField_AID.setEditable(false);
        textField_AID.setEnabled(false);
        textField_AID.setFont(new Font("Calibri", Font.PLAIN, 20));

        //---- label_Account ----
        label_Account.setText("User account");
        label_Account.setBackground(Color.darkGray);
        label_Account.setForeground(new Color(0x0099cc));
        label_Account.setFont(new Font("Calibri", Font.PLAIN, 18));

        //---- textField_Account ----
        textField_Account.setBackground(Color.darkGray);
        textField_Account.setForeground(new Color(0xcccccc));
        textField_Account.setEditable(false);
        textField_Account.setEnabled(false);
        textField_Account.setFont(new Font("Calibri", Font.PLAIN, 20));

        //---- label_Password ----
        label_Password.setText("Password");
        label_Password.setBackground(Color.darkGray);
        label_Password.setForeground(new Color(0x0099cc));
        label_Password.setFont(new Font("Calibri", Font.PLAIN, 18));

        //---- textField_Password ----
        textField_Password.setBackground(Color.darkGray);
        textField_Password.setForeground(new Color(0xcccccc));
        textField_Password.setEditable(false);
        textField_Password.setEnabled(false);
        textField_Password.setFont(new Font("Calibri", Font.PLAIN, 20));

        //---- label_Type ----
        label_Type.setText("Type account");
        label_Type.setBackground(Color.darkGray);
        label_Type.setForeground(new Color(0x0099cc));
        label_Type.setFont(new Font("Calibri", Font.PLAIN, 18));

        //---- textField_Type ----
        textField_Type.setBackground(Color.darkGray);
        textField_Type.setForeground(new Color(0xcccccc));
        textField_Type.setEditable(false);
        textField_Type.setEnabled(false);
        textField_Type.setFont(new Font("Calibri", Font.PLAIN, 20));

        //---- label_Username ----
        label_Username.setText("User name");
        label_Username.setBackground(Color.darkGray);
        label_Username.setForeground(new Color(0x0099cc));
        label_Username.setFont(new Font("Calibri", Font.PLAIN, 18));

        //---- textField_Username ----
        textField_Username.setBackground(Color.darkGray);
        textField_Username.setForeground(new Color(0xcccccc));
        textField_Username.setFont(new Font("Calibri", Font.PLAIN, 20));

        //---- label_Address ----
        label_Address.setText("Address");
        label_Address.setBackground(Color.darkGray);
        label_Address.setForeground(new Color(0x0099cc));
        label_Address.setFont(new Font("Calibri", Font.PLAIN, 18));

        //---- textField_Address ----
        textField_Address.setBackground(Color.darkGray);
        textField_Address.setForeground(new Color(0xcccccc));
        textField_Address.setFont(new Font("Calibri", Font.PLAIN, 20));

        //---- label_Phone ----
        label_Phone.setText("Phone");
        label_Phone.setBackground(Color.darkGray);
        label_Phone.setForeground(new Color(0x0099cc));
        label_Phone.setFont(new Font("Calibri", Font.PLAIN, 18));

        //---- textField_Phone ----
        textField_Phone.setBackground(Color.darkGray);
        textField_Phone.setForeground(new Color(0xcccccc));
        textField_Phone.setFont(new Font("Calibri", Font.PLAIN, 20));

        //---- label_Email ----
        label_Email.setText("Email");
        label_Email.setBackground(Color.darkGray);
        label_Email.setForeground(new Color(0x0099cc));
        label_Email.setFont(new Font("Calibri", Font.PLAIN, 18));

        //---- textField_Email ----
        textField_Email.setBackground(Color.darkGray);
        textField_Email.setForeground(new Color(0xcccccc));
        textField_Email.setFont(new Font("Calibri", Font.PLAIN, 20));

        //---- button_Update ----
        button_Update.setText("update");
        button_Update.setActionCommand("update");
        button_Update.setBackground(Color.lightGray);
        button_Update.setForeground(new Color(0x006666));
        button_Update.setFont(new Font("Calibri", Font.PLAIN, 20));
        button_Update.setVerticalAlignment(SwingConstants.BOTTOM);
        button_Update.addActionListener(e -> controler(e));

        //---- button_Done ----
        button_Done.setText("done");
        button_Done.setActionCommand("done");
        button_Done.setBackground(Color.lightGray);
        button_Done.setForeground(new Color(0x006666));
        button_Done.setFont(new Font("Calibri", Font.PLAIN, 20));
        button_Done.setVerticalAlignment(SwingConstants.BOTTOM);
        button_Done.addActionListener(e -> controler(e));

        //---- label9 ----
        label9.setText("Account infomation");
        label9.setBackground(Color.darkGray);
        label9.setForeground(new Color(0x006633));
        label9.setFont(new Font("Calibri", Font.PLAIN, 20));
        label9.setVerticalAlignment(SwingConstants.BOTTOM);

        //---- separator1 ----
        separator1.setPreferredSize(new Dimension(300, 3));

        //---- button_ChangePW ----
        button_ChangePW.setIcon(new ImageIcon(getClass().getResource("/View/Icon/pencil-icon.png")));
        button_ChangePW.setActionCommand("changepw");
        button_ChangePW.addActionListener(e -> controler(e));

        //---- button_Logout ----
        button_Logout.setText("log out");
        button_Logout.setActionCommand("log out");
        button_Logout.setBackground(Color.lightGray);
        button_Logout.setForeground(new Color(0x006666));
        button_Logout.setFont(new Font("Calibri", Font.PLAIN, 20));
        button_Logout.setIcon(new ImageIcon(getClass().getResource("/View/Icon/turn-off.png")));
        button_Logout.addActionListener(e -> controler(e));

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(separator1, GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE)
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(label_Password, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label_Account, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(textField_Account, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
                                .addGroup(contentPaneLayout.createSequentialGroup()
                                    .addComponent(textField_Password, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(button_ChangePW, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label_AID, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(textField_AID, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label_Email, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(textField_Email, GroupLayout.PREFERRED_SIZE, 377, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label_Address, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(textField_Address, GroupLayout.PREFERRED_SIZE, 377, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(label_Phone, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(textField_Phone, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                            .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                                .addComponent(label_Username, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textField_Username))
                            .addGroup(GroupLayout.Alignment.LEADING, contentPaneLayout.createSequentialGroup()
                                .addComponent(label_Type, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textField_Type, GroupLayout.PREFERRED_SIZE, 204, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addComponent(label9, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addComponent(button_Logout, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(button_Update, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(button_Done, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(25, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label9, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(separator1, GroupLayout.PREFERRED_SIZE, 3, GroupLayout.PREFERRED_SIZE)
                    .addGap(8, 8, 8)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label_AID)
                        .addComponent(textField_AID, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(textField_Account, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label_Account))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(textField_Password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label_Password)
                        .addComponent(button_ChangePW, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(textField_Type, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label_Type))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(label_Username)
                        .addComponent(textField_Username, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(textField_Phone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label_Phone))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(textField_Address, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label_Address))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(textField_Email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(label_Email))
                    .addGap(20, 20, 20)
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addComponent(button_Logout, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                        .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(button_Update)
                            .addComponent(button_Done)))
                    .addContainerGap(8, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }


    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel label_AID;
    private JTextField textField_AID;
    private JLabel label_Account;
    private JTextField textField_Account;
    private JLabel label_Password;
    private JPasswordField textField_Password;
    private JLabel label_Type;
    private JTextField textField_Type;
    private JLabel label_Username;
    private JTextField textField_Username;
    private JLabel label_Address;
    private JTextField textField_Address;
    private JLabel label_Phone;
    private JTextField textField_Phone;
    private JLabel label_Email;
    private JTextField textField_Email;
    private JButton button_Update;
    private JButton button_Done;
    private JLabel label9;
    private JSeparator separator1;
    private JButton button_ChangePW;
    private JButton button_Logout;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
