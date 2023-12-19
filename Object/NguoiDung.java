/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object;


public class NguoiDung {
    private String tenNguoiDung, matKhau;
    private int quyenHan;
    
    public NguoiDung() {
        
    }
    public NguoiDung(String ten, String mk, int quyen) {
        setTen(ten);
        setMK(mk);
        setQuyen(quyen);
    }
    
    public String getTen() {
        return this.tenNguoiDung;
    }
    public void setTen(String ten) {
        this.tenNguoiDung = ten;
    }
    
    public String getMK() {
        return this.matKhau;
    }
    public void setMK(String mk) {
        this.matKhau = mk;
    }
    
    public int getQuyen() {
        return this.quyenHan;
    }
    public void setQuyen(int quyen) {
        this.quyenHan = quyen;
    }
}
