public class BookStore  {
    private Account account;
    private DatabaseConnector dbConnect;
    private BookSearchEngine bookSearchEngine;
    class BookSearchEngine{
        /*Nhiệm vụ của search engine là sinh ra câu truy vấn phù hợp với yêu cầu của Client Account
        * */
        String nameBook;
        String author;
        String publisher;
        String [] categories;
        String query;
    }

    public boolean signUp() {
        return false;
    }

    public boolean signIn() {
        return false;
    }

    public boolean logOut() {
        return false;
    }

    public void resetPassword() {

    }


}
