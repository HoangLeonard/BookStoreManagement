import java.util.Arrays;
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
        /*+ Phải chứa ít nhất 1 ký tự số từ 0 – 9

          + Phải chứa ít nhất 1 ký tự chữ thường

          + Phải chứa ít nhất 1 ký tự chữ hoa

          + Phải chứa ít nhất 1 ký tự trong tập các ký tự
        * */
        return password.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!]).{6,20})");
    }

    public static boolean isValidEmail(String email) {

        return email.matches("^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$");
    }

    public static boolean isValidUsername(String username) {
        // Username có độ tài từ 6 đến 12 ký tự, không có khoảng trắng và không dấu
        return username.matches("[a-z0-9_-]{6,12}$");
    }

    public static boolean isValidPhoneNumber(String phone) {
        return phone.matches("[0-9]{10}");
    }

    public static boolean isValidDate(String date) {
        //Định dạng ngày yyyy/mm/dd hoặc yyyy-mm-dd
        return date.matches("\\d{4}[-|/]\\d{2}[-|/]\\d{2}");
    }

    public static String standardizeName (String name) {
        String[] tmp = name.trim().split("\\s+");
        for(int i=0; i<tmp.length; i++) {
            char [] tmpchar = tmp[i].toLowerCase().toCharArray();
            tmpchar[0] = Character.toUpperCase(tmpchar[0]);
            tmp[i] = String.valueOf(tmpchar);
        }
        String result = String.join(" ", tmp);
        return result.trim();
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

//    public static void main(String[] args) {
//        String test = "nGuyễn    tHị     hảI YếN";
//        System.out.println(Account.standardizeName(test));
//    }
}
