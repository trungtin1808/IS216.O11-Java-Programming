/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object2;

import java.sql.Date;
import java.util.Map;
import java.util.HashMap;
import java.util.Calendar;

public class PhieuMuonSach {
    private int maDocGia, tinhTrang, tongSoLuong;
    private Date ngayMuon, hanTra;
    private Map<Integer,Integer> dsSachMuon;
    
    public PhieuMuonSach() {
        
    }
    
    public PhieuMuonSach(int mdg, int tt, int sl, Map<Integer, Integer> ds) {
        setMaDocGia(mdg);
        setTinhTrang(tt);
        setTongSL(sl);
        setNgayMuon();
        setHanTra();
        setDSSachMuon(ds);
    }
    
    public int getMaDocGia() {
        return this.maDocGia;
    }
    public void setMaDocGia(int mdg) {
        this.maDocGia = mdg;
    }
    
    public int getTinhTrang() {
        return this.tinhTrang;
    }
    public void setTinhTrang(int tt) {
        this.tinhTrang = tt;
    }
    
    public int getTongSL() {
        return this.tongSoLuong;
    }
    public void setTongSL(int sl) {
        this.tongSoLuong = sl;
    }
    
    public Date getNgayMuon() {
        return this.ngayMuon;
    }
    public void setNgayMuon() {
        this.ngayMuon = new Date(System.currentTimeMillis());
    }
    
    public Date getHanTra() {
        return this.hanTra;
    }
    public void setHanTra() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(this.ngayMuon);
        cal.add(Calendar.DATE, 7);
        this.hanTra = new Date(cal.getTime().getTime());
    }
    
    public Map<Integer,Integer> getDSSachMuon() {
        return this.dsSachMuon;
    }
    public void setDSSachMuon(Map<Integer,Integer> ds) {
        this.dsSachMuon = ds;
    }
    
}
