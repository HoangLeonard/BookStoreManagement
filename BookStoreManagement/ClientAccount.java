import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

public class ClientAccount extends Account {
    private Hashtable<Book,Integer> order;
    private Queue<Bill> deliveringBill;

    public ClientAccount(String accountID, String userAccount, String password,
                         String name, String phone, String address, String email) {
        super(accountID, userAccount, password, "client", name, phone, address, email);
        order = new Hashtable<>();
        deliveringBill = new LinkedList<>();
    }

    public void addToOrder(Book b, int quantity) {
        order.put(b,quantity);
    }

    public void removeFromOrder(Book b) {
        order.remove(b);
    }

//    public Bill toBill() {
//
//    }


}
