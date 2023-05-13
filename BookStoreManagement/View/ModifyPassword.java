/*
 * Created by JFormDesigner on Tue Dec 20 04:34:49 ICT 2022
 */

package View;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;

/**
 * @author unknown
 */
public class ModifyPassword extends JDialog{
    private String newPassword = "";

    public ModifyPassword() {
        System.out.println("View: Creating ModifyPassword GUI.");
        initComponents();
        this.setFocusable(true);
        this.setVisible(true);
        System.out.println("View: Created ModifyPassword GUI.");
    }

    private void controller(ActionEvent e) {
        // TODO add your code here
        if (e.getActionCommand().equals("OK")) {
            System.out.println("click on OK");
//            newPassword = textField_NPW.getText();
        } else if (e.getActionCommand().equals("Cancel")) {
            System.out.println("click on Cancel");
            newPassword = null;
        }
        this.dispose();
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


    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
