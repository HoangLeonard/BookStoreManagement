import java.util.ArrayList;

public class Order {
    /* Using Singleton design pattern */
    private ArrayList<Book> books;
    private final ClientAccount account;
    private static Order singletonOrder;

    public Order(ClientAccount account) {
        this.account = account;
        books = new ArrayList<>();
    }

    public static Order getInstance(ClientAccount account) {
        if (singletonOrder == null) singletonOrder = new Order(account);
        return singletonOrder;
    }
}
