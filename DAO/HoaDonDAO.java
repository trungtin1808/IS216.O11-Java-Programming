/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Admin
 */
import java.sql.*;
import Object.HoaDon;
import java.util.ArrayList;

public class HoaDonDAO {

    public static Connection conn = Connect.getConnect();

    public static void ThemHoaDon(HoaDon hd) {
        String sql="{call THEMHOADON(?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql);) {
                stmt.setInt(1,hd.getmAPHIEUTRA());
                stmt.setInt(2, hd.gettIENTHU());
                stmt.execute();
            } catch (SQLException e) {
                throw new ArithmeticException(e.getMessage());
            }
    }
    public static boolean KTMaPhieuTra(int mAPHIEUTRA){
        String sql ="select MAPHIEUTRA from PHIEUTRASACH WHERE MAPHIEUTRA=?";
        try (PreparedStatement stm = conn.prepareStatement(sql)) {
                
                stm.setInt(1,mAPHIEUTRA);
                ResultSet rs = stm.executeQuery();
                return rs.next();
                
            } catch (SQLException e) {
                throw new ArithmeticException(e.getMessage());
            }

        
    }
    public static boolean KIEMTRA(HoaDon hd){
        String sql ="""
                    SELECT DOCGIA.TIENNO
                    FROM PHIEUTRASACH
                    JOIN PHIEUMUONSACH ON PHIEUMUONSACH.MAPHIEUMUONSACH = PHIEUTRASACH.MAPHIEUMUONSACH
                    JOIN DOCGIA ON PHIEUMUONSACH.MADOCGIA = DOCGIA.MADOCGIA
                    WHERE PHIEUTRASACH.MAPHIEUTRA = ?""";
        try (PreparedStatement stm = conn.prepareStatement(sql)) {
                
                stm.setInt(1,hd.getmAPHIEUTRA());
                ResultSet rs = stm.executeQuery();
                if(rs.next()){
                    int tIENNO = rs.getInt("TIENNO");
                    if(tIENNO>0&&tIENNO>=hd.gettIENTHU()) return true;
                }
                return false;
                    
            } catch (SQLException e) {
                throw new ArithmeticException(e.getMessage());
            }

    }
}
