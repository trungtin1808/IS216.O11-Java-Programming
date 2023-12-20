/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Admin
 */
import Objects.PhieuTraSach;
import Objects.ChiTietTraSach;
import java.util.*;
import java.sql.Date;
/**
 *
 * @author Admin
 */
import java.sql.*;
import java.lang.Object.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PhieuTraSachDao {
    public static Connection conn = Connect.getConnect();
    public static List<Integer> getlistmAPHIEUMUON(){
        List<Integer> list=new ArrayList<>();
        String sql="select MAPHIEUMUONSACH from PHIEUMUONSACH";
         try (PreparedStatement stm = conn.prepareStatement(sql)) {    
             ResultSet rs = stm.executeQuery();
             while(rs.next()){
                 int MAPHIEUMUONSACH=rs.getInt("MAPHIEUMUONSACH");
                 list.add(MAPHIEUMUONSACH);
             }   
                
            } catch (SQLException e) {
                throw new ArithmeticException(e.getMessage());
            }
         
         
         return list;
        
        
    }
    public static int getmADOCGIA(int MAPHIEUMUONSACH){
        int i=0;
        String sql="select MADOCGIA from PHIEUMUONSACH where MAPHIEUMUONSACH=?";
         try (PreparedStatement stm = conn.prepareStatement(sql)) { 
             stm.setInt(1, MAPHIEUMUONSACH);
             ResultSet rs = stm.executeQuery();
             if(rs.next()){
                 i=rs.getInt("MADOCGIA");
             }
             
               
                
            } catch (SQLException e) {
                throw new ArithmeticException(e.getMessage());
            }
        
        
        return i;
    }
    public static String gettENDOCGIA(int mADOCGIA){
        String hOTEN=null;
        String sql="select HOTEN from DOCGIA where MADOCGIA=?";
         try (PreparedStatement stm = conn.prepareStatement(sql)) { 
             stm.setInt(1, mADOCGIA);
             ResultSet rs = stm.executeQuery();
             if(rs.next()){
                 hOTEN=rs.getString("HOTEN");
             }
             
                  
            } catch (SQLException e) {
                throw new ArithmeticException(e.getMessage());
            }
        
        
        return hOTEN;
    }
    public static List<PhieuTraSach> getlistPTS(){
        List<PhieuTraSach> list=new ArrayList<>();
        String sql="select* from PHIEUTRASACH";
        try (PreparedStatement stm = conn.prepareStatement(sql)) { 
             ResultSet rs = stm.executeQuery();
             while(rs.next()){
                 int mAPHIEUTRA=rs.getInt("MAPHIEUTRA");
                 int mAPHIEUMUONSACH=rs.getInt("MAPHIEUMUONSACH");
                 Date nGAYTRA=rs.getDate("NGAYTRA");
                 int sONGAYTRATRE=rs.getInt("SONGAYTRATRE");
                 int tIENPHATKINAY=rs.getInt("TIENPHATKINAY");
                 PhieuTraSach A=new PhieuTraSach(mAPHIEUMUONSACH,nGAYTRA,mAPHIEUTRA,sONGAYTRATRE,tIENPHATKINAY);
                 list.add(A);
             }
             
                  
            } catch (SQLException e) {
                throw new ArithmeticException(e.getMessage());
            }
        
        return list;
        
    }
    public static List<ChiTietTraSach> getCTTS(int mAPHIEUTRA){
        List<ChiTietTraSach> list=new ArrayList<>();
        String sql="select* from CTTS where MAPHIEUTRA=?";
        try (PreparedStatement stm = conn.prepareStatement(sql)) { 
            
             stm.setInt(1, mAPHIEUTRA);
             ResultSet rs = stm.executeQuery();
             while(rs.next()){
                 int mADAUSACH=rs.getInt("MADAUSACH");
                 int tIENPHAT=rs.getInt("TIENPHAT");
                 ChiTietTraSach A=new ChiTietTraSach(mADAUSACH,mAPHIEUTRA,tIENPHAT);
                 
                 list.add(A);
             }
             
                  
            } catch (SQLException e) {
                throw new ArithmeticException(e.getMessage());
            }
        
        
        return list;
    }
   
    
    public static void InsertPhieuTraSach(PhieuTraSach pts){
        String sql="{call THEMPTS(?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql);) {
                stmt.setInt(1,pts.getmAPHIEUMUON());
                stmt.setDate(2, pts.getnGAYTRA());
                stmt.execute();
            } catch (SQLException e) {
                throw new ArithmeticException(e.getMessage());
            }
    }
}


