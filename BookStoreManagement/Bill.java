import java.util.Hashtable;
import java.time.LocalDate;

public class Bill {
    private final String billID;
    private final ClientAccount account;
    private final String staffID;
    private final Hashtable<Book,Integer> items;
    private final LocalDate invoiceDate;
    private final String deliveryID;
    private String status = "";

    public Bill(String billID, ClientAccount account, String support, Hashtable<Book, Integer> items,
                LocalDate invoiceDate, String deliveryID) {
        this.billID = billID;
        this.account = account;
        this.staffID = support;
        this.items = items;
        this.invoiceDate = invoiceDate;
        this.deliveryID = deliveryID;
        this.status = "processing";
    }

    public String getBillID() {
        return billID;
    }

    public ClientAccount getAccount() {
        return account;
    }

    public String getSupport() {
        return staffID;
    }

    public Hashtable<Book, Integer> getItems() {
        return items;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public String getDeliveryID() {
        return deliveryID;
    }

    public String getStatus() {
        return status;
    }
}
