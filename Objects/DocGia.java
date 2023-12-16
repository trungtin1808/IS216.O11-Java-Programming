/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object2;

import java.sql.Date; 
import java.util.Calendar;

public class DocGia {
    private int loaiDocGia;
    private String hoTen, diaChi, email;
    private Date ngaySinh, ngayLapThe, ngayDenHan;
    
    public DocGia() {
//        setMaDocGia(0);
        setHoTen("");
        setLoaiDocGia(0);
        setNgaySinh(new Date(System.currentTimeMillis()));
        setDiaChi("");
        setEmail("");
        setNgayLapThe();
        setNgayDenHan(4); 
    }
    
    public DocGia(int mdg, String ht, int ldg, Date ns, String dc, String em) {
//        setMaDocGia(mdg);
        setHoTen(ht);
        setLoaiDocGia(ldg);
        setNgaySinh(ns);
        setDiaChi(dc);
        setEmail(em);
        setNgayLapThe();
        setNgayDenHan(4);
    }
    
//    public int getMaDocGia() {
//        return this.maDocGia;
//    }
//    public void setMaDocGia(int mdg) {
//        this.maDocGia = mdg;
//    }
    
    public String getHoTen() {
        return this.hoTen;
    }
    public void setHoTen(String ht) {
        this.hoTen = ht;
    }
    
    public int getLoaiDocGia() {
        return this.loaiDocGia;
    }
    public void setLoaiDocGia(int ldg) {
        this.loaiDocGia = ldg;
    }
    
    public Date getNgaySinh() {
        return this.ngaySinh;
    }
    public void setNgaySinh(Date ns) {
        this.ngaySinh = ns;
    }
    
    public String getDiaChi() {
        return this.diaChi;
    }
    public void setDiaChi(String dc) {
        this.diaChi = dc;
    }
    
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String em) {
        this.email = em;
    }
    
    public Date getNgayLapThe() {
        return this.ngayLapThe;
    }
    public void setNgayLapThe() {
        this.ngayLapThe = new Date(System.currentTimeMillis());
    }
    
    public Date getNgayDenHan() {
        return this.ngayDenHan;
    }
    public void setNgayDenHan(int soThang) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(System.currentTimeMillis()));
        cal.add(Calendar.MONTH, soThang);
        this.ngayDenHan = new Date(cal.getTime().getTime());
    }
}
