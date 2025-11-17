package controller;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; 
import javax.swing.JOptionPane;
import model.SinhVien;
import model.TaiKhoan;
import util.DBConnection; 
import view.GD_Menu_Admin;
import view.GD_Menu_SV;

public class TaiKhoanDAO {
     public boolean AddTaiKhoan(String id, String pass)
     {
         
         String sql = "INSERT INTO \"NhanVien\"(\"Id\",\"Pass_Word\") VALUES(?,?)";
         Connection conn = null; 
         PreparedStatement ps = null; 
         try { 
             conn = DBConnection.getConnection();
             ps = conn.prepareStatement(sql);
             ps.setString(1, id);
             ps.setString(2, pass);
             return ps.executeUpdate() > 0;
         } catch (Exception e) {
             e.printStackTrace();
             JOptionPane.showMessageDialog(null, "Account already exist!");
         } finally {
             try {
                 if (ps != null) ps.close();
                 if (conn != null) conn.close();
             } catch (SQLException ex) {
                 ex.printStackTrace();
             }
         }
         return false;
     }


     public boolean DangNhap(String s, String q, boolean x)
     {
         Connection conn = null; 
         PreparedStatement ps = null; 
         ResultSet rs = null;
         String sql;

         try { 
             conn = DBConnection.getConnection();
             if(x) 
             {
                
                 sql = "SELECT * FROM \"NhanVien\" WHERE \"Id\"=? AND \"Pass_Word\"=?";
                 ps = conn.prepareStatement(sql);
                 ps.setString(1, s);
                 ps.setString(2, q);
                 rs = ps.executeQuery();
                 if(rs.next())
                 {
                     GD_Menu_Admin winAdmin = new GD_Menu_Admin();
                     winAdmin.setLocationRelativeTo(null);
                     winAdmin.setVisible(true);
                     return true;
                 }
                 else
                 {
                     JOptionPane.showMessageDialog(null, "Incorrect username or password!");
                     return false;
                 }
             }
             else 
             {
                 
                 sql = "SELECT * FROM \"TaiKhoan\" WHERE \"Id\"=? and \"Pass_Word\"=?";
                 ps = conn.prepareStatement(sql);
                 ps.setString(1, s.toUpperCase()); 
                 ps.setString(2, q);
                 rs = ps.executeQuery();
                 if(rs.next())
                 {
                     SinhVienDAO sinhVienDAO = new SinhVienDAO();
                     SinhVien sinhVien = sinhVienDAO.getSinhVien(s);
                     
                     if (sinhVien != null && sinhVien.getId() != null) {
                        GD_Menu_SV winD_Menu_SV = new GD_Menu_SV(sinhVien);
                        winD_Menu_SV.setLocationRelativeTo(null);
                        winD_Menu_SV.setVisible(true);
                        return true;
                     } else {
                        
                        JOptionPane.showMessageDialog(null, "No student information!");
                        return false;
                     }
                 }
                 else{
                     JOptionPane.showMessageDialog(null, "Incorrect username or password!");
                     return false;
                 }
             }
         } catch (Exception e) {
             e.printStackTrace();
         } finally { 
             try {
                 if (rs != null) rs.close();
                 if (ps != null) ps.close();
                 if (conn != null) conn.close();
             } catch (SQLException ex) {
                 ex.printStackTrace();
             }
         }
         return false; 
     }




     
     public TaiKhoan getTaiKhoan(SinhVien s)
     {
       
         String sql = "SELECT * FROM \"TaiKhoan\" WHERE \"Id\"=?";
         TaiKhoan tk = new TaiKhoan();
         Connection conn = null; 
         PreparedStatement ps = null; 
         ResultSet rs = null;
         try { 
             conn = DBConnection.getConnection();
             ps = conn.prepareStatement(sql);
             ps.setString(1, s.getId());
             rs = ps.executeQuery();
             if(rs.next())
             {
                 
                 tk.setIdString(rs.getString("Id"));
                 tk.setPassWord(rs.getString("Pass_Word"));
             }
             else{
                
                 JOptionPane.showMessageDialog(null, "Account does not exist!");
             }
         } catch (Exception e) {
              e.printStackTrace();
              JOptionPane.showMessageDialog(null, "Error!");
         } finally { 
             try {
                 if (rs != null) rs.close();
                 if (ps != null) ps.close();
                 if (conn != null) conn.close();
             } catch (SQLException ex) {
                 ex.printStackTrace();
             }
         }
         return tk;
     }

     
     public boolean DoiMatKhau(SinhVien s,String NewPass)
     {
         
         String sql = "UPDATE \"TaiKhoan\" SET \"Pass_Word\"=? WHERE \"Id\"=?";
         Connection conn = null; 
         PreparedStatement ps = null; 
         try { 
             conn = DBConnection.getConnection();
             ps = conn.prepareStatement(sql);
             ps.setString(1, NewPass);
             ps.setString(2, s.getId());
             return ps.executeUpdate() > 0;
         } catch (Exception e) {
             e.printStackTrace();
             JOptionPane.showMessageDialog(null,"Error");
         } finally {  
             try {
                 if (ps != null) ps.close();
                 if (conn != null) conn.close();
             } catch (SQLException ex) {
                 ex.printStackTrace();
             }
         }
         return false;
     }
}