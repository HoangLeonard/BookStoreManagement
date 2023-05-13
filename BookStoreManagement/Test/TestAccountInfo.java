package Test;

import Controller.DatabaseConnector;
import Model.Account;
import Model.ClientAccount;
import View.AccountInfo;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TestAccountInfo {
    public static void main(String[] args) {
        class Account {
            String user;
        }

        class ClientAccount extends Account {
            double salary;
        }

        ClientAccount a = (ClientAccount) new Account();
        Account b = (Account) new ClientAccount();

        double doubleNum = (double) 54;
        int intNum = (int) 5.6;
    }




}
