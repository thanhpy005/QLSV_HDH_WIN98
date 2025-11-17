
package model;





public class TienTrinh {
    private String Id,TenMon,ChuyenNganh;

    public String getChuyenNganh() {
        return ChuyenNganh;
    }

    public void setChuyenNganh(String ChuyenNganh) {
        this.ChuyenNganh = ChuyenNganh;
    }
    private float KetQua;
    private int HocKi;
    public TienTrinh()
    {
        
    }

    public String getId() {
        return Id;
    }

    public String getTenMon() {
        return TenMon;
    }

    public float getKetQua() {
        return KetQua;
    }

    public int getHocKi() {
        return HocKi;
    }

    public void setId(String Id) {
        this.Id = Id.toUpperCase();
    }

    public void setTenMon(String TenMon) {
        this.TenMon = TenMon;
    }

    public void setKetQua(float KetQua) {
        this.KetQua = KetQua;
    }

    public void setHocKi(int HocKi) {
        this.HocKi = HocKi;
    }
    
   
    
}
