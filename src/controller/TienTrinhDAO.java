package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.SinhVien;
import model.TienTrinh;
import util.DBConnection; 

public class TienTrinhDAO {
     public ArrayList getTienTrinh(SinhVien s)
     {
         ArrayList list = new ArrayList();
         
         String sql = "SELECT * FROM \"TienTrinh\" WHERE \"Id\"=?";
         Connection conn = null;
         PreparedStatement ps = null;
         ResultSet rs = null;
         try {
             conn = DBConnection.getConnection();
             ps = conn.prepareStatement(sql);
             ps.setString(1, s.getId());
             rs = ps.executeQuery();
             while(rs.next())
             {
                 TienTrinh tr = new TienTrinh();
                 tr.setId(rs.getString("Id"));
                 tr.setTenMon(rs.getString("TenMon"));
                 tr.setKetQua(rs.getFloat("KetQua"));
                 tr.setHocKi(rs.getInt("HocKi"));
                 tr.setChuyenNganh(rs.getString("ChuyenNganh"));
                 list.add(tr);
             }

         } catch (Exception e) {
             e.printStackTrace();
             JOptionPane.showMessageDialog(null, "No student information!");
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

      public ArrayList getTienTrinh2KiHoc(SinhVien s)
      {
           ArrayList list = new ArrayList();
           
           String sql = "SELECT * FROM \"TienTrinh\" WHERE \"Id\"=? AND \"HocKi\"=?";
           Connection conn = null;
           PreparedStatement ps = null;
           ResultSet rs = null;
           try {
               conn = DBConnection.getConnection();
               ps = conn.prepareStatement(sql);
               ps.setString(1, s.getId());
               ps.setInt(2, s.getSchoolYear());
               rs = ps.executeQuery();
               while(rs.next())
               {
                   TienTrinh tr =new TienTrinh();
                   
                   tr.setId(rs.getString("Id"));
                   tr.setTenMon(rs.getString("TenMon"));
                   tr.setKetQua(rs.getFloat("KetQua"));
                   tr.setHocKi(rs.getInt("HocKi"));
                   tr.setChuyenNganh(rs.getString("ChuyenNganh"));
                   list.add(tr);
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

       public float getCpa(SinhVien s)
       {
         float res = 0;
         String sql = "SELECT AVG(CAST(\"KetQua\" AS Float)) AS \"DIEMTRUNGBINH\" FROM \"TienTrinh\" WHERE \"Id\"=? AND \"KetQua\">0";
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
                 
                 res = rs.getFloat("DIEMTRUNGBINH");
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
         return res;
     }

      public boolean SetDiem(TienTrinh s)
      {
        
         String sql = "UPDATE \"TienTrinh\" SET \"KetQua\"=? WHERE \"Id\"=? AND \"TenMon\"=?";
         Connection conn = null;
         PreparedStatement ps = null;
         try {
             conn = DBConnection.getConnection();
             ps = conn.prepareStatement(sql);
             ps.setFloat(1, s.getKetQua());
             ps.setString(2, s.getId());
             ps.setString(3, s.getTenMon());
             return ps.executeUpdate() > 0;
         } catch (Exception e) {
             e.printStackTrace();
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