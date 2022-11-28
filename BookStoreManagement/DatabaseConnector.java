import java.sql.*;
public class DatabaseConnector {
    public static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static String DB_URL = "jdbc:mysql://Localhost/bookstoremanagement";
    private final String user;
    protected Connection connection = null;
    private static int nextCID = 0; //the next client account id
    private static int nextAID = 0;
    private static int nextSID = 0;
    private static int nextAuID = 0;
    private static int nextBiID = 0;
    private static int nextBID = 0;
    private static int nextPID = 0;

    public DatabaseConnector(String user, String password) {
        this.user = user;
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

    public static void updateID() {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, "root", "");
            try {
                CallableStatement call = connection.prepareCall("{CALL CurrentAccountID(?, ?)}");
                call.setString("accountType", "client");
                call.setInt("prefix", 3);
                ResultSet rs = call.executeQuery();
                while (rs.next()) nextCID = rs.getInt(1);
            } catch (SQLException e) {
                System.out.println("fail to update CID");
                //e.printStackTrace();
            }
            try {
                CallableStatement call = connection.prepareCall("{CALL CurrentAccountID(?, ?)}");
                call.setString("accountType", "admin");
                call.setInt("prefix", 3);
                ResultSet rs = call.executeQuery();
                while (rs.next()) nextAID = rs.getInt(1);
            } catch (SQLException e) {
                System.out.println("fail to update AID");
                //e.printStackTrace();
            }
            try {
                CallableStatement call = connection.prepareCall("{CALL CurrentAccountID(?, ?)}");
                call.setString("accountType", "staff");
                call.setInt("prefix", 3);
                ResultSet rs = call.executeQuery();
                while (rs.next()) nextSID = rs.getInt(1);
            } catch (SQLException e) {
                System.out.println("fail to update SID");
                //e.printStackTrace();
            }
            try {
                CallableStatement call = connection.prepareCall("{CALL CurrentAuthorID(?)}");
                call.setInt("prefix", 4);
                ResultSet rs = call.executeQuery();
                while (rs.next()) nextAuID = rs.getInt(1);
            } catch (SQLException e) {
                System.out.println("fail to update AuID");
                //e.printStackTrace();
            }
            try {
                CallableStatement call = connection.prepareCall("{CALL CurrentBillID(?)}");
                call.setInt("prefix", 4);
                ResultSet rs = call.executeQuery();
                while (rs.next()) nextBiID = rs.getInt(1);
            } catch (SQLException e) {
                System.out.println("fail to update BiID");
                //e.printStackTrace();
            }
            try {
                CallableStatement call = connection.prepareCall("{CALL CurrentBookID(?)}");
                call.setInt("prefix", 3);
                ResultSet rs = call.executeQuery();
                while (rs.next()) nextBID = rs.getInt(1);
            } catch (SQLException e) {
                System.out.println("fail to update BID");
                //e.printStackTrace();
            }
            try {
                CallableStatement call = connection.prepareCall("{CALL CurrentPublisherID(?)}");
                call.setInt("prefix", 3);
                ResultSet rs = call.executeQuery();
                while (rs.next()) nextPID = rs.getInt(1);
            } catch (SQLException e) {
                System.out.println("fail to update PID");
                //e.printStackTrace();
            }
        } catch (SQLException e) {
            System.out.println("JDBC can not connect to database");
        }
    }

    public String getUser() {
        return user;
    }

    public static int getCID() {
        nextCID += 1;
        return nextCID;
    }

    public static int getAID() {
        nextAID += 1;
        return nextAID;
    }

    public static int getSID() {
        nextSID += 1;
        return nextSID;
    }

    public static int getAuID() {
        nextAuID += 1;
        return nextAuID;
    }

    public static int getBiID() {
        nextBiID += 1;
        return nextBiID;
    }

    public static int getBID() {
        nextBID += 1;
        return nextBID;
    }

    public static int getPID() {
        nextPID += 1;
        return nextPID;
    }


    public static void main(String[] args) {
        updateID();
        System.out.println(getBID());
        System.out.println(getAID());
        System.out.println(getSID());
        System.out.println(getBiID());
        System.out.println(getCID());
        System.out.println(getPID());
        System.out.println(getAuID());
    }

}
