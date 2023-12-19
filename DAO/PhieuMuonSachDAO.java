/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import Object.PhieuMuonSach;
import java.sql.PreparedStatement;
//import java.sql.CallableStatement;
import java.sql.SQLException;
//import java.util.Calendar;
import java.sql.ResultSet;
//import java.util.Map;
//import java.util.Iterator;
//import java.util.Map.Entry;
import java.util.Vector;

public class PhieuMuonSachDAO {
    public static Connection conn = Connect.getConnect();

    public static boolean ThemPMS(PhieuMuonSach pms) {
        String sql = "{call THEMPMS(?, ?, ?, ?, ?, ?)}";
        try (PreparedStatement stm = conn.prepareStatement(sql);) {
            stm.setInt(1, pms.getMaDocGia());
            stm.setDate(2, pms.getNgayMuon());
            stm.setDate(3, pms.getHanTra());
            stm.setInt(4, pms.getTongSL());
            stm.setInt(5, pms.getTinhTrang());
            
            stm.setString(6, pms.getXmlString());
            
            return stm.executeUpdate() > 0;
        }
        catch (SQLException e) {
            throw new ArithmeticException(e.getMessage());
        }
    }

    public static boolean KTSanCo(int maDauSach, int soLuongNhap) {
        String query = "select * from DAUSACH where MADAUSACH = ? and SANCO >= ?";
        try (PreparedStatement stm = conn.prepareStatement(query);) {
            stm.setInt(1, maDauSach);
            stm.setInt(2, soLuongNhap);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) return true;
        } catch (SQLException e) {
            throw new ArithmeticException(e.getMessage());
        }
        return false;
    }
    
    public static Vector<Integer> getListMaDauSach() {
        Vector<Integer> listMaDauSach = new Vector<>();
        
        String query = "select MADAUSACH from DAUSACH";
        try (PreparedStatement stm = conn.prepareStatement(query);) {
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                listMaDauSach.add(rs.getInt("MADAUSACH"));
            }
        } catch (SQLException e) {
            throw new ArithmeticException(e.getMessage());
        }
        return listMaDauSach;
    }
    
}
