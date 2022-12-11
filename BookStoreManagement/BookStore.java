public class BookStore  {
    private Account account;
    private String query;

    public void creatAccount(String userAccount, String password,
                             String name, String phone,
                             String address, String Email) {
        if (Account.isValidUsername(userAccount)
            && Account.isValidPassword(password)
            && Account.isValidPhoneNumber(phone)) {
            name = Account.standardizeName(name);
        }
    }

    public void forgetPassword(String userAccount, String contact) {

    }

    public void signIn(String userAccount, String password) {

    }

    public void logOut() {

    }



}
