/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Object2;

public class DauSach {
    private String tenDS, tacGia, NXB, viTri;
    private int namXB, tongSo, sanCo, dangChoMuon; 
    
    public DauSach() {
        setTenDS("");
        setTacGia("");
        setNXB("");
        setViTri("");
        setNamXB(0);
        setTongSo(0);
        setDangChoMuon(0);
        setSanCo();
    }
    
    public DauSach(String tds, String tg, String nxb, String vt, int nam, int ts) {
        setTenDS(tds);
        setTacGia(tg);
        setNXB(nxb);
        setViTri(vt);
        setNamXB(nam);
        setTongSo(ts);
        setDangChoMuon(0);
        setSanCo();
    }
    
    public String getTenDS() {
        return this.tenDS;
    }
    public void setTenDS(String tds) {
        this.tenDS = tds;
    }
    
    public String getTacGia() {
        return this.tacGia;
    }
    public void setTacGia(String tg) {
        this.tacGia = tg;
    }
    
    public String getNXB() {
        return this.NXB;
    }
    public void setNXB(String nxb) {
        this.NXB = nxb;
    }
    
    public String getViTri() {
        return this.viTri;
    }
    public void setViTri(String vt) {
        this.viTri = vt;
    }
    
    public int getNamXB() {
        return this.namXB;
    }
    public void setNamXB(int nam) {
        this.namXB = nam;
    }
    
    public int getTongSo() {
        return this.tongSo;
    }
    public void setTongSo(int ts) {
        this.tongSo = ts;
    }
    
    public int getDangChoMuon() {
        return this.dangChoMuon;
    }
    public void setDangChoMuon(int sl) {
        this.dangChoMuon = sl;
    }
    
    public int getSanCo() {
        return this.sanCo;
    }
    public void setSanCo() {
        this.sanCo = this.tongSo - this.dangChoMuon;
    }
    
}
