package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        
        Class.forName("org.hsqldb.jdbcDriver");
        
        
        String connectionUrl = "jdbc:hsqldb:file:database/QuanLy;textdb.encoding=UTF-8";
        
        
        String user = "SA"; 
        String password = "";
        
        return DriverManager.getConnection(connectionUrl, user, password);
    }

    // Test nhanh
    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = getConnection();
          
            
        } catch (Exception e) {
          
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                 
                    conn.createStatement().execute("SHUTDOWN");
                    conn.close();
                    
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}