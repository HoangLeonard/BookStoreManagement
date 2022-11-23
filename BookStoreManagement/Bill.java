import java.util.Date;

public class Bill {
    private String billID;
    private final ClientAccount account;
    private final Book[] books;
    private Date invoiceDate;

    public Bill(ClientAccount account, Book[] books) {
        this.account = account;
        this.books = books;
    }
}
