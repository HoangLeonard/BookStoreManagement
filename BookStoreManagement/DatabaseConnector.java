
import javax.swing.*;
import java.sql.*;
public class DatabaseConnector {
    public static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static String DB_URL = "jdbc:mysql://Localhost/bookstoremanagement";
    private String user = "";
    private String password = "";
    protected Connection connection = null;
    private int CID = 0; //the next client account id
    private int AID = 0;
    private int SID = 0;
    private int AuID = 0;
    private int BiID = 0;
    private int BID = 0;
    private int PID = 0;

    public DatabaseConnector(String user, String password) {
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, user, password);
            if (connection == null) throw new SQLException();
            else System.out.println("Creating connection successfully!");
        } catch (ClassNotFoundException e) {
            System.out.println("Can not find " + JDBC_DRIVER);
        } catch (SQLException e) {
            System.out.println("Checking for account: username, password");
        }
    }

    public void updateID() {
        try {
            CallableStatement call = connection.prepareCall("{CALL CurrentAccountID(?, ?)}");
            call.setString("accountType", "client");
            call.setInt("prefix", 3);
            ResultSet rs = call.executeQuery();
            while (rs.next()) this.CID = rs.getInt(1);
        } catch (SQLException e) {
            System.out.println("fail to update CID");
            //e.printStackTrace();
        }
        try {
            CallableStatement call = connection.prepareCall("{CALL CurrentAccountID(?, ?)}");
            call.setString("accountType", "admin");
            call.setInt("prefix", 3);
            ResultSet rs = call.executeQuery();
            while (rs.next()) this.AID = rs.getInt(1);
        } catch (SQLException e) {
            System.out.println("fail to update AID");
            //e.printStackTrace();
        }
        try {
            CallableStatement call = connection.prepareCall("{CALL CurrentAccountID(?, ?)}");
            call.setString("accountType", "staff");
            call.setInt("prefix", 3);
            ResultSet rs = call.executeQuery();
            while (rs.next()) this.SID = rs.getInt(1);
        } catch (SQLException e) {
            System.out.println("fail to update SID");
            //e.printStackTrace();
        }
        try {
            CallableStatement call = connection.prepareCall("{CALL CurrentAuthorID(?)}");
            call.setInt("prefix", 4);
            ResultSet rs = call.executeQuery();
            while (rs.next()) this.AuID = rs.getInt(1);
        } catch (SQLException e) {
            System.out.println("fail to update AuID");
            //e.printStackTrace();
        }
        try {
            CallableStatement call = connection.prepareCall("{CALL CurrentBillID(?)}");
            call.setInt("prefix", 4);
            ResultSet rs = call.executeQuery();
            while (rs.next()) this.BiID = rs.getInt(1);
        } catch (SQLException e) {
            System.out.println("fail to update BiID");
            //e.printStackTrace();
        }
        try {
            CallableStatement call = connection.prepareCall("{CALL CurrentBookID(?)}");
            call.setInt("prefix", 3);
            ResultSet rs = call.executeQuery();
            while (rs.next()) this.BID = rs.getInt(1);
        } catch (SQLException e) {
            System.out.println("fail to update BID");
            //e.printStackTrace();
        }
        try {
            CallableStatement call = connection.prepareCall("{CALL CurrentPublisherID(?)}");
            call.setInt("prefix", 3);
            ResultSet rs = call.executeQuery();
            while (rs.next()) this.PID = rs.getInt(1);
        } catch (SQLException e) {
            System.out.println("fail to update PID");
            //e.printStackTrace();
        }
    }

    public int getCID() {
        return CID;
    }

    public int getAID() {
        return AID;
    }

    public int getSID() {
        return SID;
    }

    public int getAuID() {
        return AuID;
    }

    public int getBiID() {
        return BiID;
    }

    public int getBID() {
        return BID;
    }

    public int getPID() {
        return PID;
    }

    public static void main(String[] args) {
        DatabaseConnector test = new DatabaseConnector("root", "");
        test.updateID();
        System.out.println(test.getBID());
        System.out.println(test.getAID());
        System.out.println(test.getSID());
        System.out.println(test.getBiID());
        System.out.println(test.getCID());
        System.out.println(test.getPID());
        System.out.println(test.getAuID());

    }

}
