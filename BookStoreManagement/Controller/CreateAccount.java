package Controller;


import Model.Account;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateAccount implements ActionListener {
    private View.CreateAccount view;
    private DatabaseConnector db;

    public CreateAccount(View.CreateAccount view, DatabaseConnector db) {
        this.view = view;
        this.db = db;
    }

    public CreateAccount(View.CreateAccount view) {
        this.view = view;
        this.db = new DatabaseConnector("root", "");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("create account")) {
            //check requires
            String userAccount = view.getTextField_Account().getText();
            String passWord = view.getTextField_Password().getText();
            String address = view.getTextField_Address().getText();
            String type = (String) view.getComboBox_Type().getSelectedItem();
            String id = type.equals("admin")? DatabaseConnector.getAID(): type.equals("staff")? DatabaseConnector.getSID(): DatabaseConnector.getCID();
            String name = Account.standardizeName(view.getTextField_UserName().getText());
            String phone = view.getTextField_Phone().getText();
            String email = view.getTextField_Email().getText();
            String noti = Account.checkValidAccount(userAccount, passWord, phone, email);
            if (address.equals("")) noti += "\nAddress can not be null.";
            if (name.equals("")) name += "\nName can not be null.";
            view.getTextArea_Noti().setText(noti);
            view.getTextArea_Noti().setForeground(Color.RED);

            //add account to db
            if (noti.equals("")) {
                try {
                    String query = "SELECT UserAccount FROM account WHERE UserAccount LIKE '" + userAccount + "'";
                    ResultSet tmp = db.getConnection().createStatement().executeQuery(query);
                    System.out.println("execute:\n" + query);
                    if (tmp.next()) {
                        view.getTextArea_Noti().setText("Existed user account");
                    } else {
                        query =
                                "INSERT INTO `Account` (`AccountID`, `UserAccount`, `Password`, `Type`, `Name`, `Phone`, `Address`, `Email`) VALUES\n" +
                                        "\t('" + id + "', '" + userAccount + "', '" + passWord + "', '" + type + "', '" + name + "', '" + phone + "', '" + address + "', '" + email + "')";
                        db.getConnection().createStatement().execute(query);
                        System.out.println("execute:\n" + query);
                    }
                } catch (SQLException sqlException) {
                    DatabaseConnector.updateID();
                    view.getTextArea_Noti().setText("Fail to create new account. Try again!");
                }
            }
        } else if (e.getActionCommand().equals("Done")) {
            view.dispose();
        }
    }


}
