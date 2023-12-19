/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Admin
 */
import Object.PhieuTraSach;

/**
 *
 * @author Admin
 */
import java.sql.*;
import java.lang.Object.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PhieuTraSachDAO {
    public static Connection conn = Connect.getConnect();

   
    public static boolean KTPhieuTra(int mAPHIEUMUON){
        String sql="select MAPHIEUMUONSACH from PHIEUMUONSACH WHERE MAPHIEUMUONSACH=?";
        try (PreparedStatement stm = conn.prepareStatement(sql);) {
                stm.setInt(1,mAPHIEUMUON);
                ResultSet rs = stm.executeQuery();
                return rs.next();
            } catch (SQLException e) {
                throw new ArithmeticException(e.getMessage());
            }
        
        
    }
    public static void InsertPhieuTraSach(PhieuTraSach pts){
        String sql="{call THEMPTS(?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql);) {
                stmt.setInt(1,pts.getMaPhieuMuonSach());
                stmt.setDate(2, pts.getNgayTra());
                stmt.execute();
            } catch (SQLException e) {
                throw new ArithmeticException(e.getMessage());
            }
    }
}

