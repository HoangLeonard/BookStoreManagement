import java.util.Hashtable;
import java.time.*;

public class Bill {
    private final String billID;
    private final ClientAccount account;
    private final StaffAccount management;
    private final Hashtable<Book,Integer> items;
    private final LocalDate invoiceDate;

    private String status = "";

    public Bill(String billID, ClientAccount account,
                StaffAccount management, Hashtable<Book, Integer> items) {
        this.billID = billID;
        this.account = account;
        this.management = management;
        this.items = items;
        this.invoiceDate = LocalDate.now();
        this.status = "delivering";
    }

    public String getBillID() {
        return billID;
    }

    public ClientAccount getAccount() {
        return account;
    }

    public StaffAccount getManagement() {
        return management;
    }

    public Hashtable<Book, Integer> getItems() {
        return items;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billID='" + billID + '\'' +
                ", account=" + account +
                ", management=" + management +
                ", items=" + items +
                ", invoiceDate=" + invoiceDate +
                ", status='" + status + '\'' +
                '}';
    }
}
