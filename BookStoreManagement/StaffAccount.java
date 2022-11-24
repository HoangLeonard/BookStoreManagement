import java.util.Date;

public class StaffAccount extends Account {
    private double basicSalary = 0;
    private String office = "";
    private Date date;

    public StaffAccount(String accountID, String userAccount, String password, String type, String name, String phone, String address, double basicSalary, String office, Date date) {
        super(accountID, userAccount, password, type, name, phone, address);
        this.basicSalary = basicSalary;
        this.office = office;
        this.date = date;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
