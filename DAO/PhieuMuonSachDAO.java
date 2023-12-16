/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO2;

import java.sql.Connection;
import Object2.PhieuMuonSach;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.sql.ResultSet;
import java.util.Map;
import java.util.Iterator;
import java.util.Map.Entry;

public class PhieuMuonSachDAO {
    public static Connection conn = Connect.getConnect();
//    procedure insert vao ca pms va ctpms va tru di so luong
    public static boolean ThemPMS(PhieuMuonSach pms) {
        String sql = "insert into PHIEUMUONSACH (MADG, NGAYMUON, HANTRA, TONGSL, TINHTRANG) values (?, ?, ?, ?, ?)";
        try (PreparedStatement stm = conn.prepareStatement(sql);) {
            stm.setInt(1, pms.getMaDocGia());
            stm.setDate(2, pms.getNgayMuon());
            stm.setDate(3, pms.getHanTra());
            stm.setInt(4, pms.getTongSL());
            stm.setInt(5, pms.getTinhTrang());
            return stm.executeUpdate() > 0;
        }
        catch (SQLException e) {
            throw new ArithmeticException(e.getMessage());
        }
    }

    public static boolean KTSanCo(Map<Integer,Integer> ds) {
        Iterator<Entry<Integer, Integer>> iterator = ds.entrySet().iterator();
        int sanCo = 0;
        
        while (iterator.hasNext()) {
            Entry<Integer, Integer> entry = iterator.next();
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            
            String query = "select SANCO from DAUSACH where MADS = ?";
            try (PreparedStatement stm = conn.prepareStatement(query);) {
                stm.setInt(1, key);
                ResultSet rs = stm.executeQuery();
                if (rs.next()) sanCo = rs.getInt("SANCO");
                if (sanCo < value) return false;
            } catch (SQLException e) {
                throw new ArithmeticException(e.getMessage());
            }
        }
        return true;
    }
    
}
