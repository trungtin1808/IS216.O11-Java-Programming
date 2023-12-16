/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO2;

import java.sql.Connection;
import Object2.DauSach;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.sql.ResultSet;

public class DauSachDAO {
    
    public static Connection conn = Connect.getConnect();
    
    public static boolean ThemDauSach(DauSach ds) {
        String sql = "insert into DAUSACH (TENDS, TACGIA, NXB, NAMXB, VITRI, TONGSO, DANGCHOMUON, SANCO) values (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stm = conn.prepareStatement(sql);) {
            stm.setString(1, ds.getTenDS());
            stm.setString(2, ds.getTacGia());
            stm.setString(3, ds.getNXB());
            stm.setInt(4, ds.getNamXB());
            stm.setString(5, ds.getViTri());
            stm.setInt(6, ds.getTongSo());
            stm.setInt(7, ds.getDangChoMuon());
            stm.setInt(8, ds.getSanCo());
            return stm.executeUpdate() > 0;
        }
        catch (SQLException e) {
            throw new ArithmeticException(e.getMessage());
        }
    }
    
    public static boolean XoaDauSach(int mds) {
        String sql = "delete from DAUSACH where MADS = ? ";
        try (PreparedStatement stm = conn.prepareStatement(sql);) {
            stm.setString(1, Integer.toString(mds));
            return stm.executeUpdate() > 0;
        } catch (SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
    }
    
    public static boolean SuaDauSach(DauSach ds, int mds) {
        String query = "select DANGCHOMUON from DAUSACH where MADS = ?";
        int dangChoMuon = 0;
        try (PreparedStatement stm = conn.prepareStatement(query);) {
            stm.setInt(1, mds);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) dangChoMuon = rs.getInt("DANGCHOMUON");
        } catch (SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
        ds.setDangChoMuon(dangChoMuon);
        ds.setSanCo();
        
        String sql = "update DAUSACH set TENDS = ?, TACGIA = ?, NXB = ?, NAMXB=?, VITRI = ?, TONGSO = ?, SANCO = ? where MADS = ?";
        try (PreparedStatement stm = conn.prepareStatement(sql);) {
            stm.setString(1, ds.getTenDS());
            stm.setString(2, ds.getTacGia());
            stm.setString(3, ds.getNXB());
            stm.setInt(4, ds.getNamXB());
            stm.setString(5, ds.getViTri());
            stm.setInt(6, ds.getTongSo());
            stm.setInt(7, ds.getSanCo());
            stm.setInt(8, mds);
            return stm.executeUpdate() > 0;
        } catch (SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
    }
    
    public static boolean KTNamXB(int nam) {
        Calendar cal = Calendar.getInstance();
        int currentYear = cal.get(Calendar.YEAR);
        if (nam <= currentYear) return true;
        return false;
    }
    
    public static boolean KTTongSoThem(int ts) {
        if (ts <= 0) return false;
        return true;
    }
    
    public static boolean KTTongSoSua(int mds, int ts) {
        String query = "select TONGSO from DAUSACH where MADS = ?";
        int tongSo = 0;
        try (PreparedStatement stm = conn.prepareStatement(query);) {
            stm.setInt(1, mds);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) tongSo = rs.getInt("TONGSO");
        } catch (SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
        
        if (ts < tongSo) return false;
        return true;
    }
    
    public static boolean KTTinhTrangMuonSach(int mds) {
        String query = "select * from PHIEUMUONSACH, CTPMS where PHIEUMUONSACG.MAPMS = CTPMS.MAPMS AND CTPMS.MADS = ? and PHIEUMUONSACH.TINHTRANG = 0";
        try (PreparedStatement stm = conn.prepareStatement(query);) {
            stm.setInt(1, mds);
            if (!stm.executeQuery().next()) return true;
        }
        catch (SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
        return false;
    }
}
