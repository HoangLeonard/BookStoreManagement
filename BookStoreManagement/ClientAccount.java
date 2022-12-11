import java.time.LocalDate;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Queue;

public class ClientAccount extends Account {
    private Hashtable<Book,Integer> order;
    private Queue<Bill> bills;

    public ClientAccount(String accountID, String userAccount, String password,
                         String name, String phone, String address, String email) {
        super(accountID, userAccount, password, "client", name, phone, address, email);
        order = new Hashtable<>();
        bills = new LinkedList<>();


    }

    public void addToOrder(Book b, int quantity) {
        order.put(b,quantity);
    }

    public void removeFromOrder(Book b) {
        order.remove(b);
    }

    public void toBill(String deliveryID) {
        String billId = String.format("BiID%04d", DatabaseConnector.getBiID());
        bills.add(new Bill(billId, this, "CID006", order, LocalDate.now(), deliveryID));
        order = new Hashtable<>();

    }


}
