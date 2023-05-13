package Model;

import Controller.DatabaseConnector;

import java.time.LocalDate;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

public class ClientAccount extends Account {
    private Hashtable<Book,Integer> order;
    private Queue<Bill> bills;

    public ClientAccount(String accountID, String userAccount,
                         String name, String phone, String address, String email) {
        super(accountID, userAccount, "client", name, phone, address, email);
        order = new Hashtable<>();
        bills = new LinkedList<>();


    }

    public void addToOrder(Book b, int quantity) {
        order.put(b,quantity);
    }

    public void removeFromOrder(Book b) {
        order.remove(b);
    }


}
