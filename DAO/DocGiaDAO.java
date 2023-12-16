/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO2;

import Object2.DocGia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.ResultSet;

public class DocGiaDAO {
    
    public static Connection conn = Connect.getConnect();
    
    public static boolean ThemDocGia(DocGia dg) {
        String sql = "insert into DOCGIA (HOTEN, LOAIDG, NGAYSINH, DIACHI, EMAIL, NGAYLAPTHE, NGAYDENHAN) values (?, ?, ?, ?, ?, ?, ?) ";
        try (PreparedStatement stm = conn.prepareStatement(sql);) {
            stm.setString(1, dg.getHoTen());
            stm.setInt(2, dg.getLoaiDocGia());
            stm.setDate(3, dg.getNgaySinh());
            stm.setString(4, dg.getDiaChi());
            stm.setString(5, dg.getEmail());
            stm.setDate(6, dg.getNgayLapThe());
            stm.setDate(7, dg.getNgayDenHan());
            return stm.executeUpdate() > 0;
        }
        catch (SQLException e) {
            throw new ArithmeticException(e.getMessage());
        }
    }
    
    public static boolean XoaDocGia(int mdg) {
        String sql = "delete from DOCGIA where MADG = ? ";
        try (PreparedStatement stm = conn.prepareStatement(sql);) {
            stm.setString(1, Integer.toString(mdg));
            return stm.executeUpdate() > 0;
        } catch (SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
    }
    
    public static boolean SuaDocGia(DocGia dg, int mdg) {
        String sql = "update DOCGIA set HOTEN = ?, LOAIDG = ?, NGAYSINH = ?, DIACHI=?, EMAIL =? where MADG = ?";
        try (PreparedStatement stm = conn.prepareStatement(sql);) {
            stm.setString(1, dg.getHoTen());
            stm.setInt(2, dg.getLoaiDocGia());
            stm.setDate(3, dg.getNgaySinh());
            stm.setString(4, dg.getDiaChi());
            stm.setString(5, dg.getEmail());
            stm.setInt(6, mdg);
            return stm.executeUpdate() > 0;
        } catch (SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
    }
    
    public static boolean GiaHanThe(int mdg) {
        String sql = "update DOCGIA set NGAYDENHAN = DATEADD(MONTH, 2, NGAYDENHAN) where MADG = ?";
        try (PreparedStatement stm = conn.prepareStatement(sql);) {
            stm.setInt(1, mdg);
            return stm.executeUpdate() > 0;
        }
        catch (SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
    }
    
    public static boolean KTNgaySinh(Date ns, Date nlt) {
        int comparisonResult = ns.compareTo(nlt);
        if (comparisonResult < 0) return true;
        return false;
    }
    
    public static boolean KTHanThe(int mdg) {
        Date currentDate = new Date(System.currentTimeMillis());
        Date ngayDenHan = null;
        String query = "select NGAYDENHAN from DOCGIA where MADG = ?";
        try (PreparedStatement stm = conn.prepareStatement(query);) {
            stm.setInt(1, mdg);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) ngayDenHan = rs.getDate("NGAYDENHAN");
        }
        catch (SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
        long dateDiff = currentDate.getTime() - ngayDenHan.getTime();
        dateDiff = dateDiff / (24*60*60*1000);
//        int comparisonResult = ngayDenHan.compareTo(currentDate);
        if (dateDiff >= 7) return true;
        return false;
    }
//    doc gia dang khong muon sach = true, co muon ma chua tra = false
    public static boolean KTTinhTrangMuonSach(int mdg) {
        String query = "select * from PHIEUMUONSACH where MADG = ? and TINHTRANG = 0";
        try (PreparedStatement stm = conn.prepareStatement(query);) {
            stm.setInt(1, mdg);
            if (!stm.executeQuery().next()) return true;
        }
        catch (SQLException ex) {
            throw new ArithmeticException(ex.getMessage());
        }
        return false;
    }
    
}
