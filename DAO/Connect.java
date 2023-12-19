/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Connect {
    public static Connection conn = null;
    
    public static Connection getConnect() {
        String hostname = "localhost";
        String port = "1433";
        String dbname = "QLTV";
        String username = "sa";
        String password = "123456789";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectURL = "jdbc:sqlserver://" + hostname + ":" + port + ";DatabaseName=" + dbname + ";encrypt=true;trustServerCertificate=true;";
            conn = DriverManager.getConnection(connectURL, username, password);
            
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return conn;
    }
}
