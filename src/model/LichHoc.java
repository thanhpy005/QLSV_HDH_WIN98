
package model;


public class LichHoc{
    private String Id,Mamon, Tenmon, Phonghoc,DayString,ThoiGian;
    private int TietBatDau,SoTiet,KiHoc;

    public void setKiHoc(int KiHoc) {
        this.KiHoc = KiHoc;
    }

    public int getKiHoc() {
        return KiHoc;
    }

    public void setThoiGian(String ThoiGian) {
        this.ThoiGian = ThoiGian;
    }

    public void setTietBatDau(int TietBatDau) {
        this.TietBatDau = TietBatDau;
    }

    public void setSoTiet(int SoTiet) {
        this.SoTiet = SoTiet;
    }

    public String getThoiGian() {
        return ThoiGian;
    }

    public int getTietBatDau() {
        return TietBatDau;
    }

    public int getSoTiet() {
        return SoTiet;
    }

    public void setId(String Id) {
        this.Id = Id.toUpperCase();
    }

    public String getId() {
        return Id;
    }

    public void setDayString(String DayString) {
        this.DayString = DayString;
    }

    public String getDayString() {
        return DayString;
    }

    public void setMamon(String Mamon) {
        this.Mamon = Mamon;
    }

    public void setTenmon(String Tenmon) {
        this.Tenmon = Tenmon;
    }

    public void setPhonghoc(String Phonghoc) {
        this.Phonghoc = Phonghoc;
    }

   

    public String getMamon() {
        return Mamon;
    }

    public String getTenmon() {
        return Tenmon;
    }

    public String getPhonghoc() {
        return Phonghoc;
    }

    

    
}
