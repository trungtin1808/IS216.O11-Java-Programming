/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;

import java.sql.Date; 

public class DocGia {
    private int loaiDocGia;
    private String hoTen, diaChi, email;
    private Date ngaySinh, ngayLapThe, ngayDenHan;
    private int tienNo;
    
    public DocGia() {
        setHoTen("");
        setLoaiDocGia(0);
        setNgaySinh(new Date(System.currentTimeMillis()));
        setDiaChi("");
        setEmail("");
        setTienNo(0);
    }
    
    public DocGia(String ht, int ldg, Date ns, String dc, String em, Date nlt, Date ndh) {
        setHoTen(ht);
        setLoaiDocGia(ldg);
        setNgaySinh(ns);
        setDiaChi(dc);
        setEmail(em);
        setNgayLapThe(nlt);
        setNgayDenHan(ndh);
        setTienNo(0);
    }
    
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
    public void setNgayLapThe(Date nlt) {
        this.ngayLapThe = nlt;
    }
    
    public Date getNgayDenHan() {
        return this.ngayDenHan;
    }
    public void setNgayDenHan(Date ndh) {
        this.ngayDenHan = ndh;
    }
   
    public int getTienNo() {
        return this.tienNo;
    }
    public void setTienNo(int tn) {
        this.tienNo = tn;
    }
}
