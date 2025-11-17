
package model;
import java.util.Date;


public class SinhVien {
    private String Id,Name,Sex,MainClass,Address,Phone,Email,Status, Major;
    private Date Dob;
    private int SchoolYear;

    public SinhVien() {
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setDob(Date Dob) {
        this.Dob = Dob;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    
    public void setId(String Id) {
        this.Id = Id.toUpperCase();
    }

    public void setMainClass(String MainClass) {
        this.MainClass = MainClass;
    }

    public void setMajor(String Major) {
        this.Major = Major;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

   

    public void setSex(String Sex) {
        this.Sex = Sex;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getAddress() {
        return Address;
    }

    public Date getDob() {
        return Dob;
    }

    public String getEmail() {
        return Email;
    }

    

    public String getId() {
        return Id;
    }

    public String getMainClass() {
        return MainClass;
    }

    public String getMajor() {
        return Major;
    }

    public String getName() {
        return Name;
    }

    public String getPhone() {
        return Phone;
    }

    public int getSchoolYear() {
        return SchoolYear;
    }

    public void setSchoolYear(int SchoolYear) {
        this.SchoolYear = SchoolYear;
    }


    public String getSex() {
        return Sex;
    }

    public String getStatus() {
        return Status;
    }
    
}
