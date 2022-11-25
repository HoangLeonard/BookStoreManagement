
import java.sql.*;
public class DatabaseConnector {
    public static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static String DB_URL = "jdbc:mysql://Localhost/bookstoremanagement";
    private String user = "";
    private String password = "";
    protected Connection connection;
    protected Statement stmt;


    public DatabaseConnector(String user, String password) {
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, user, password);
            if (connection == null) throw new SQLException();
            else System.out.println("Creating connection successfully!");
            stmt = connection.createStatement();
        } catch (ClassNotFoundException e) {
            System.out.println("Can not find " + JDBC_DRIVER);
        } catch (SQLException e) {
            System.out.println("Checking for account: username, password");
        }
    }

//    public static void main(String[] args) {
//        DatabaseConnector test = new DatabaseConnector("root", "");
//        try {
//            ResultSet result = test.stmt.executeQuery("select * from Account");
//            while (result.next()) {
//            }
//        } catch (Exception e) {}
//    }

}
