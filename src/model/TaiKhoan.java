/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ThanhNguyen
 */
public class TaiKhoan {
    private String IdString,PassWord,Type;

    public TaiKhoan() {
    }

    public void setIdString(String IdString) {
        this.IdString = IdString;
    }

    public String getIdString() {
        return IdString;
    }

    public void setPassWord(String PassWord) {
        this.PassWord = PassWord;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getPassWord() {
        return PassWord;
    }

    public String getType() {
        return Type;
    }
    
}
