package controller;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; 
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.CacMonHoc;
import model.SinhVien;
import util.DBConnection; 

public class SinhVienDAO {
     public ArrayList getListSinhVien2Major(String s)
     {
         ArrayList list  = new ArrayList(); 
 
         String sql = "SELECT * FROM \"SinhVien\" WHERE \"Major\"=?";
         Connection conn = null; 
         PreparedStatement ps = null; 
         ResultSet rs = null; 
         try { 
             conn = DBConnection.getConnection();
             ps = conn.prepareStatement(sql);
             ps.setString(1, s);
             rs = ps.executeQuery();
             while(rs.next())
             {
                 SinhVien sv = new SinhVien();
                 
                 sv.setId(rs.getString("Id"));
                 sv.setName(rs.getString("Name"));
                 sv.setSex(rs.getString("Sex"));
                 sv.setDob(rs.getDate("Day_of_birth"));
                 sv.setMainClass(rs.getString("MainClass"));
                 sv.setAddress(rs.getString("Address"));
                 sv.setPhone(rs.getString("Phone"));
                 sv.setEmail(rs.getString("Email"));
                 sv.setStatus(rs.getString("Status"));
                 sv.setMajor(rs.getString("Major"));
                 sv.setSchoolYear(rs.getInt("School_Year"));
                 list.add(sv);
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
         return list;

     }
      public SinhVien getSinhVien(String s)
      {
         s = s.toUpperCase();
         SinhVien sv = new SinhVien();
         
         String sql = "SELECT * FROM \"SinhVien\" WHERE \"Id\"=?";
         Connection conn = null; 
         PreparedStatement ps = null; 
         ResultSet rs = null; 
         try { 
             conn = DBConnection.getConnection();
             ps = conn.prepareStatement(sql);
             ps.setString(1, s);
             rs = ps.executeQuery();
             if(rs.next())
             {
                 
                 sv.setId(rs.getString("Id"));
                 sv.setName(rs.getString("Name"));
                 sv.setSex(rs.getString("Sex"));
                 sv.setDob(rs.getDate("Day_of_birth"));
                 sv.setMainClass(rs.getString("MainClass"));
                 sv.setAddress(rs.getString("Address"));
                 sv.setPhone(rs.getString("Phone"));
                 sv.setEmail(rs.getString("Email"));
                 sv.setStatus(rs.getString("Status"));
                 sv.setMajor(rs.getString("Major"));
                 sv.setSchoolYear(rs.getInt("School_Year"));
             }
             else{
                 JOptionPane.showMessageDialog(null, "No student information!");
                 
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
         return sv;
     }


     public boolean addSinhVien(SinhVien s)
     {
         
         String sql = "INSERT INTO \"SinhVien\"(\"Id\",\"Name\",\"Sex\",\"Day_of_birth\",\"MainClass\",\"Address\",\"Phone\",\"Email\",\"Status\",\"Major\",\"School_Year\") VALUES(?,?,?,?,?,?,?,?,?,?,?)";
         String sql1 = "INSERT INTO \"TaiKhoan\"(\"Id\",\"Pass_Word\") VALUES(?,?)";
         String sql2 = "INSERT INTO \"TienTrinh\"(\"Id\",\"TenMon\",\"KetQua\",\"HocKi\",\"ChuyenNganh\") VALUES(?,?,?,?,?)";

         Connection conn = null;
         PreparedStatement ps = null; 
         PreparedStatement ps1 = null; 
         PreparedStatement ps2 = null; 

         boolean success = false; 

         try { 
             conn = DBConnection.getConnection();
             
             conn.setAutoCommit(false);

             ps = conn.prepareStatement(sql);
             ps.setString(1, s.getId());
             ps.setString(2, s.getName());
             ps.setString(3, s.getSex());
             ps.setDate(4,new java.sql.Date(s.getDob().getTime()));
             ps.setString(5, s.getMainClass());
             ps.setString(6, s.getAddress());
             ps.setString(7, s.getPhone());
             ps.setString(8, s.getEmail());
             ps.setString(9, s.getStatus());
             ps.setString(10, s.getMajor());
             ps.setInt(11, s.getSchoolYear());

             ps1 = conn.prepareStatement(sql1);
             ps1.setString(1,s.getId());
             ps1.setString(2, "123"); 

             int ex1 = ps.executeUpdate();
             int ex2 = ps1.executeUpdate();

             if(ex1 > 0 && ex2 > 0)
             {
                 ps2 = conn.prepareStatement(sql2);
                 String[] TenMonHoc = null;
                 int hocKiLimit = 0;
                 int[] kiSplit = null; 

                
                 if(s.getMajor().equals("IT"))
                 {
                     TenMonHoc = new CacMonHoc().IT_TienTrinh;
                     hocKiLimit = 45; 
                     kiSplit = new int[]{3, 10, 17, 24, 31, 37, 43}; 
                 }
                 else if(s.getMajor().equals("BC"))
                 {
                     TenMonHoc = new CacMonHoc().BC_TienTrinh;
                     hocKiLimit = 46; 
                     kiSplit = new int[]{4, 12, 19, 25, 33, 38, 44};
                 }
                 else if(s.getMajor().equals("KHMT"))
                 {
                     TenMonHoc = new CacMonHoc().KHMT_TienTrinh;
                     hocKiLimit = 48; 
                     kiSplit = new int[]{3, 10, 16, 22, 29, 35, 41};
                 }
                 else if(s.getMajor().equals("QT"))
                 {
                    
                     TenMonHoc = new CacMonHoc().QT_TienTrinh;
                     hocKiLimit = 46; 
                     kiSplit = new int[]{4, 10, 16, 23, 30, 37, 44};
                 }
                 else if(s.getMajor().equals("MK"))
                 {
                     TenMonHoc = new CacMonHoc().MK_TienTrinh;
                     hocKiLimit = 45; 
                     kiSplit = new int[]{4, 10, 15, 22, 30, 37, 43};
                 }

                 if (TenMonHoc != null) {
                     for(int i = 0; i < hocKiLimit; i++)
                     {
                         ps2.setString(1, s.getId());
                         ps2.setString(2, TenMonHoc[i]);
                         ps2.setFloat(3, 0); 

                         
                         int hocKi = 1;
                         for (int k = 0; k < kiSplit.length; k++) {
                            if (i <= kiSplit[k]) {
                                hocKi = k + 1;
                                break;
                            }
                            if (k == kiSplit.length - 1) { 
                                hocKi = 8;
                            }
                         }
                         ps2.setInt(4, hocKi);
                         ps2.setString(5, s.getMajor());
                         ps2.executeUpdate(); 
                     }
                 }
                 conn.commit(); 
                 success = true; 
             } else {
                 conn.rollback(); 
             }

         } catch (Exception e) {
             e.printStackTrace();
             JOptionPane.showMessageDialog(null, "Error!");
             try { if (conn != null) conn.rollback(); } catch (SQLException exRb) { exRb.printStackTrace(); } 
         } finally { 
             try {
                
                 if (conn != null && !conn.getAutoCommit()) {
                    conn.setAutoCommit(true);
                 }
                 if (ps != null) ps.close();
                 if (ps1 != null) ps1.close();
                 if (ps2 != null) ps2.close();
                 if (conn != null) conn.close();
             } catch (SQLException ex) {
                 ex.printStackTrace();
             }
         }
         return success; 
     }


     public boolean XoaSinhVien(String s)
     {
         s = s.toUpperCase();
         
         String sql = "DELETE FROM \"SinhVien\" WHERE \"Id\"=?";
         String sql1 = "DELETE FROM \"TienTrinh\" WHERE \"Id\"=?";
         String sql2 = "DELETE FROM \"TaiKhoan\" WHERE \"Id\"=?";
         String sql3 = "DELETE FROM \"LichHoc\" WHERE \"ID\"=?"; 

         Connection conn = null; 
         PreparedStatement ps = null; 
         PreparedStatement ps1 = null; 
         PreparedStatement ps2 = null; 
         PreparedStatement ps3 = null; 
         boolean success = false; 

         try {
             conn = DBConnection.getConnection();
             conn.setAutoCommit(false); 

             
             ps1 = conn.prepareStatement(sql1); 
             ps1.setString(1, s);
             ps1.executeUpdate();

             ps2= conn.prepareStatement(sql2);
             ps2.setString(1, s);
             ps2.executeUpdate();

             ps3 = conn.prepareStatement(sql3);
             ps3.setString(1, s);
             ps3.executeUpdate();

             
             ps = conn.prepareStatement(sql); 
             ps.setString(1, s);
             int rowsDeleted = ps.executeUpdate();

             if (rowsDeleted > 0) {
                conn.commit(); 
                success = true;
             } else {
                conn.rollback(); 
                JOptionPane.showMessageDialog(null, "Error!");
             }
         } catch (Exception e) {
             e.printStackTrace();
             JOptionPane.showMessageDialog(null, "Error!");
             try { if (conn != null) conn.rollback(); } catch (SQLException exRb) { exRb.printStackTrace(); } 
         } finally { 
             try {
                if (conn != null && !conn.getAutoCommit()) {
                    conn.setAutoCommit(true);
                }
                 if (ps != null) ps.close();
                 if (ps1 != null) ps1.close();
                 if (ps2 != null) ps2.close();
                 if (ps3 != null) ps3.close();
                 if (conn != null) conn.close();
             } catch (SQLException ex) {
                 ex.printStackTrace();
             }
         }
         return success; 
     }


     public ArrayList getlistSinhVien()
     {
         ArrayList list = new ArrayList(); 
        
         String sql = "SELECT \"Id\", \"Name\", \"Sex\", \"Day_of_birth\", \"MainClass\", \"Address\", \"Phone\", \"Email\", \"Status\", \"Major\", \"School_Year\" FROM \"SinhVien\"";

         Connection conn = null; 
         PreparedStatement ps = null; 
         ResultSet rs = null; 
         try { 
             conn = DBConnection.getConnection();
             ps = conn.prepareStatement(sql);
             rs = ps.executeQuery();
             while(rs.next())
             {
                 SinhVien s = new SinhVien();
         
                 s.setId(rs.getString("Id"));
                 s.setName(rs.getString("Name"));
                 s.setSex(rs.getString("Sex"));
                 s.setDob(rs.getDate("Day_of_birth"));
                 s.setMainClass(rs.getString("MainClass"));
                 s.setAddress(rs.getString("Address"));
                 s.setPhone(rs.getString("Phone"));
                 s.setEmail(rs.getString("Email"));
                 s.setStatus(rs.getString("Status"));
                 s.setMajor(rs.getString("Major"));
                 s.setSchoolYear(rs.getInt("School_Year"));
                 list.add(s);
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
         return list;
     }
     public boolean CapNhap1(SinhVien s)
     {
         if(XoaSinhVien(s.getId()))
         {
             if(addSinhVien(s)) return true;
         }
         return false;
     }
     public boolean CapNhap(SinhVien s)
     {
         
         String sql = "UPDATE \"SinhVien\" SET " +
                      "\"Name\" = ?, " +
                      "\"Sex\" = ?, " +
                      "\"Day_of_birth\" = ?, " +
                      "\"MainClass\" = ?, " +
                      "\"Address\" = ?, " +
                      "\"Phone\" = ?, " +
                      "\"Email\" = ?, " +
                      "\"Status\" = ?, " +
                      "\"Major\" = ?, " +
                      "\"School_Year\" = ? " +
                      "WHERE \"Id\" = ?";

         Connection conn = null;
         PreparedStatement ps = null;
         boolean success = false;

         try {
             conn = DBConnection.getConnection();
             ps = conn.prepareStatement(sql);

             ps.setString(1, s.getName());
             ps.setString(2, s.getSex());
             ps.setDate(3, new java.sql.Date(s.getDob().getTime()));
             ps.setString(4, s.getMainClass());
             ps.setString(5, s.getAddress());
             ps.setString(6, s.getPhone());
             ps.setString(7, s.getEmail());
             ps.setString(8, s.getStatus());
             ps.setString(9, s.getMajor());
             ps.setInt(10, s.getSchoolYear());
             ps.setString(11, s.getId()); 

             int rowsUpdated = ps.executeUpdate();
             if (rowsUpdated > 0) {
                 success = true;
             } else {
                 JOptionPane.showMessageDialog(null, "Error!");
             }

         } catch (Exception e) {
             e.printStackTrace();
             JOptionPane.showMessageDialog(null, "Error!");
         } finally {
             try {
                 if (ps != null) ps.close();
                 if (conn != null) conn.close();
             } catch (SQLException ex) {
                 ex.printStackTrace();
             }
         }
         return success;
     }


     public void updateAvatar(String maSV, File fileAnh) {
         maSV = maSV.toUpperCase();
         
         String sql = "UPDATE \"SinhVien\" SET \"avatar\" = ? WHERE \"Id\" = ?";
         Connection conn = null; 
         PreparedStatement ps = null;
         FileInputStream fis = null; 
         try { 
              conn = DBConnection.getConnection();
              ps = conn.prepareStatement(sql);
              fis = new FileInputStream(fileAnh);

             ps.setBinaryStream(1, fis, (int) fileAnh.length());
             ps.setString(2, maSV);

             int rows = ps.executeUpdate();
             
         } catch (Exception e) {
             e.printStackTrace();
             JOptionPane.showMessageDialog(null, "Error !");
         } finally { 
             try {
                 if (fis != null) fis.close(); 
                 if (ps != null) ps.close();
                 if (conn != null) conn.close();
             } catch (Exception ex) { 
                 ex.printStackTrace();
             }
         }
     }
     public ImageIcon getAvatar(String maSV) {
         maSV = maSV.toUpperCase();
         
         String sql = "SELECT \"avatar\" FROM \"SinhVien\" WHERE \"Id\"= ?";
         Connection conn = null; 
         PreparedStatement ps = null;
         ResultSet rs = null; 
         try { 
             conn = DBConnection.getConnection();
             ps = conn.prepareStatement(sql);
             ps.setString(1, maSV);
             rs = ps.executeQuery();

             if (rs.next()) {
                
                 byte[] imgBytes = rs.getBytes("avatar");
                 if (imgBytes != null && imgBytes.length > 0) { 
                     Image img = Toolkit.getDefaultToolkit().createImage(imgBytes);
                     
                     ImageIcon icon = new ImageIcon(img);
                     
                     while (icon.getImageLoadStatus() == java.awt.MediaTracker.LOADING) {
                        try { Thread.sleep(100); } catch (InterruptedException ignore) {}
                     }
                      
                    if (icon.getImageLoadStatus() == java.awt.MediaTracker.COMPLETE) {
                        return new ImageIcon(icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
                    }
                 }
             }
         } catch (Exception e) {
             e.printStackTrace();
             JOptionPane.showMessageDialog(null, "Error !");
         } finally { 
             try {
                 if (rs != null) rs.close();
                 if (ps != null) ps.close();
                 if (conn != null) conn.close();
             } catch (SQLException ex) {
                 ex.printStackTrace();
             }
         }
         return null;
    }
}