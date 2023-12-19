/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.*;

public class DuLieuBang {
    public static PreparedStatement pst = null;
    public static ResultSet rs = null;
    public static Connection conn = Connect.getConnect();
    
    
    public static void Load(String sql, JTable tb) {  
        try {
            pst= conn.prepareStatement(sql);
            rs = pst.executeQuery();
            tb.setModel((DbUtils.resultSetToTableModel(rs)));
        } 
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, e,"Thông báo lỗi!",1);
        }
         
    }
    
    public static ResultSet ShowTextField(String sql) {
        try {
            pst= conn.prepareStatement(sql);
            return pst.executeQuery();           
        }
        catch(Exception e) {
            return null;
        }
    }

    public static void Load(String sql, DefaultTableModel model) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
