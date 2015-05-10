package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Yumi Takuma
 */
public class MyJDBCApp {
    public static void main(String[] args) {
//        System.out.println("Derby DB Connect Example.");
        Connection conn = null;
        String url = "jdbc:derby://localhost:1527/e-VENT";
        String driver = "org.apache.derby.jdbc.ClientDriver";
        String username = "event";
        String password = "event";
        
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url, username, password);
//            System.out.println("Connected to the database.");
            conn.close();
//            System.out.println("Disconnected to the database.");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
//            e.printStackTrace();
        }
    }
}
