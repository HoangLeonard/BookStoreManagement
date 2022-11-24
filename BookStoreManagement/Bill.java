import java.util.Arrays;
import java.util.Date;

public class Bill {
    private String billID;
    private final ClientAccount account;
    private final StaffAccount management;
    private final BookPackage[] books;
    private Date invoiceDate;

    private String status = "";

    public Bill(String billID, ClientAccount account, StaffAccount management, BookPackage[] books, Date invoiceDate) {
        this.billID = billID;
        this.account = account;
        this.management = management;
        this.books = books;
        this.invoiceDate = invoiceDate;
    }

    public String getBillID() {
        return billID;
    }

    public void setBillID(String billID) {
        this.billID = billID;
    }

    public ClientAccount getAccount() {
        return account;
    }

    public StaffAccount getManagement() {
        return management;
    }

    public BookPackage[] getBooks() {
        return books;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
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
                ", books=" + Arrays.toString(books) +
                ", invoiceDate=" + invoiceDate +
                '}';
    }

}
