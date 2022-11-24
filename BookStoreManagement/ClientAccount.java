import java.util.Queue;

public class ClientAccount extends Account {
    private Order order;
    private Queue<Bill> deliveringBill;

    public ClientAccount(String accountID, String userAccount, String password, String name, String phone, String address) {
        super(accountID, userAccount, password, "client", name, phone, address);
    }
}
