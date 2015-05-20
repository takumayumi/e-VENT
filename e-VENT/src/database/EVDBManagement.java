package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ClientModel;
import model.EventModel;
import util.DataConverter;

/**
 *
 * @author Yumi Takuma
 */
public class EVDBManagement {
    
    Connection conn = null;
    public void getConnection() {
    
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(EVDBManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String username = "root";
        String password = "";
        String server = "localhost";
        String port = "3306";
        String schema = "e-vent";
        Properties connProps = new Properties();
        connProps.put("user", username);
        connProps.put("password", password);

        try {
            
            conn = DriverManager.getConnection(
                    "jdbc:mysql" + "://"
                    + server
                    + ":" + port + "/"
                    + schema,
                    connProps);
            System.out.println("Connected to the database.");
//            conn.close();
//            System.out.println("Disconnected to the database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    Statement stmt = null;
    ResultSet rs = null;
    
    public ArrayList<EventModel> getEvents() {
        ArrayList<EventModel> events = new ArrayList<>();
        try {
            if(conn != null){
                stmt = conn.createStatement();
                rs = stmt.executeQuery("SELECT event_id, date FROM event");
                
                while(rs.next()) {
                    events.add(new EventModel(rs.getInt("event_id"), DataConverter.resultToCalendar(rs.getString("date"))));
                }

            } else {
                getConnection();
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        
        return events;
    }
    
    public ArrayList<ClientModel> getClients() {
        ArrayList<ClientModel> clients = new ArrayList<>();
        try {
                getConnection();
                stmt = conn.createStatement();
                rs = stmt.executeQuery("SELECT client_id, lastname, firstname, mi FROM client");
                
                while(rs.next()) {
                    System.out.println(rs.getInt("client_id") + ", "+ rs.getString("lastname"));
                    clients.add(new ClientModel(rs.getInt("client_id"), rs.getString("lastname"), rs.getString("firstname"), rs.getString("mi").charAt(0)));
                }

            
                conn.close();
            
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        
        return clients;
    }
}
