package Controller;

import Model.Account;
import Model.ClientAccount;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SignIn implements ActionListener {
    private View.SignIn view;
    private DatabaseConnector db;

    public SignIn(View.SignIn view) {
        this.view = view;
        db = new DatabaseConnector("root", "");
    }

    public SignIn() {
        db = new DatabaseConnector("root", "");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Sign in")) {
            String acc = view.getTextField_Account().getText();
            String pw = view.getTextField_Password().getText();
            ResultSet check;
            Account account;
            try {
                String query = "SELECT * FROM account " +
                        "WHERE UserAccount LIKE '"+ acc + "' AND Password LIKE PASSWORD('"+ pw +"')";
                check = db.getConnection().createStatement().executeQuery("SELECT * FROM account " +
                        "WHERE UserAccount LIKE '"+ acc + "' AND Password LIKE PASSWORD('"+ pw +"')");
                System.out.println("execute:\n" + query);
                if (check.next()) {
                    String accountID = check.getString("AccountID");
                    String userAccount = check.getString("UserAccount");
                    String type = check.getString("Type");
                    String name = check.getString("Name");
                    String phone = check.getString("Phone");
                    String address = check.getString("Address");
                    String email = check.getString("Email");
                    account = new Account(accountID, userAccount, type, name, phone, address, email);
                    view.dispose();
                    System.out.println("loading Home GUI:...");
                    new View.Home(account, this.db);
                } else {
                    view.getTextField_Noti().setText("Check your password or user account!");
                    view.getTextField_Noti().setForeground(Color.RED);
                }
            } catch (SQLException sqlException) {
                view.getTextField_Noti().setText("Fail to connect database");
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        } else if (e.getActionCommand().equals("Create new Client Account")) {
            new View.CreateAccount();
        }
    }

}
