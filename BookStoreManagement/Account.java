import java.util.regex.*;
public abstract class Account {
    private String accountID;
    private String userAccount;
    private String password;
    private String type;
    private String name;
    private String phone;
    private String address;

    public Account(String accountID, String userAccount, String password, String type, String name, String phone, String address) {
        this.accountID = accountID;
        this.userAccount = userAccount;
        this.password = password;
        this.type = type;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public static boolean isValidPassword(String password) {
        return false;
    }

    public static boolean isValidEmail(String email) {
        return false;
    }

    public static boolean isValidPhoneNumber(String phone) {
        return false;
    }

    public static String standardizeName (String name) {
        return "";
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountID='" + accountID + '\'' +
                ", userAccount='" + userAccount + '\'' +
                ", password='" + password + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
