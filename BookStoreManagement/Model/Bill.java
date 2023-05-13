package Model;

import java.util.Date;
import java.util.Hashtable;
import java.time.LocalDate;

public class Bill {
    private String billID;
    private Account account;
    private String staffID;
    private Hashtable<Book,Integer> items;
    private Hashtable<String, Book> mapping;
    private String date;
    private String deliveryID;
    private String status = "";

    public Bill(String billID, Account account, String support, Hashtable<Book, Integer> items,
                String invoiceDate, String deliveryID) {
        this.billID = billID;
        this.account = account;
        this.staffID = support;
        this.items = items;
        this.date = invoiceDate;
        this.deliveryID = deliveryID;
        this.status = "processing";
    }

    public String getBillID() {
        return billID;
    }

    public String getSupport() {
        return staffID;
    }

    public Hashtable<Book, Integer> getItems() {
        return items;
    }

    public String getDeliveryID() {
        return deliveryID;
    }

    public String getStatus() {
        return status;
    }

    public Hashtable<String, Book> getMapping() {
        return mapping;
    }

    public static String generateInsertBillQuery(Bill b) {
        String query ="INSERT INTO bill (BillID, AccountID, StaffID, Date, Status, DeliveryID)" +
        "\nVALUE ('__BillID', '__AccountID', '__StaffID', '__Date', '__Status', '__DeliveryID');";
        String bid = b.billID;
        String aid = b.account.getAccountID();
        String sid = b.staffID;
        String d = "2022-12-22";
        String status = "processing";
        String deli = "DID0002";
        return query.replace("__BillID", bid).replace("__AccountID", aid).replace("__StaffID", sid)
                .replace("__Date", d).replace("__Status", status).replace("__DeliveryID", deli);
    }

    public static String generateInsertBillDetailQuery(Bill b) {
        if (b.getItems().keySet().size() == 0) return "";
        String query = "INSERT INTO billdetail (BillID, BookID, Quantity) VALUES -- tail";
        String tail = "('__BillID', '__BookID', '__Quantity'),-- tail";
        String billID = b.billID;
        for (Book book : b.getItems().keySet()) {
            query = query.replace("-- tail",tail);
            String bookID = book.getBookID();
            String quantity = b.getItems().get(book).toString();
            query = query.replace("__BillID", billID).replace("__BookID", bookID).replace("__Quantity", quantity);
        }
        return query.replace(",-- tail", ";");
    }
}
