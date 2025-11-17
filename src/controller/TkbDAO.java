package controller;

import util.DBConnection; 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException; 
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.LichHoc;
import model.SinhVien;

public class TkbDAO {
     public boolean CapNhapTkb(LichHoc l)
     {
         
         String sql = "INSERT INTO \"LichHoc\"(\"ID\",\"Ma_mon\",\"Ten_mon\",\"Thu\",\"Tiet_bat_dau\",\"So_tiet\",\"Phong\",\"Thoi_gian\",\"Ki_hoc\") VALUES(?,?,?,?,?,?,?,?,?)";

         Connection conn = null;
         PreparedStatement ps = null; 
         try { 
             conn = DBConnection.getConnection();
             ps = conn.prepareStatement(sql);
             ps.setString(1, l.getId());
             ps.setString(2, l.getMamon());
             ps.setString(3, l.getTenmon());
             ps.setString(4, l.getDayString());
             ps.setInt(5, l.getTietBatDau());
             ps.setInt(6, l.getSoTiet());
             ps.setString(7, l.getPhonghoc());
             ps.setString(8, l.getThoiGian());
             ps.setInt(9,l.getKiHoc());
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


     public ArrayList XemTKbSV(String s,int k) 
     {
         s = s.toUpperCase();
         ArrayList list = new ArrayList();
         
         String sql = "SELECT \"Ma_mon\",\"Ten_mon\",\"Thu\",\"Tiet_bat_dau\",\"So_tiet\",\"Phong\",\"Thoi_gian\",\"Ki_hoc\" FROM \"LichHoc\" WHERE \"ID\"=? AND \"Ki_hoc\"=? ORDER BY \"Thu\" ASC";

         Connection conn = null; 
         PreparedStatement ps = null; 
         ResultSet rs = null; 
         try { 
             conn = DBConnection.getConnection();
             ps = conn.prepareStatement(sql);
             ps.setString(1, s);
             ps.setInt(2, k);
             rs = ps.executeQuery();
             while(rs.next())
             {
                 LichHoc l = new LichHoc();
                 l.setId(s); 
                 l.setMamon(rs.getString("Ma_mon"));
                 l.setTenmon(rs.getString("Ten_mon"));
                 l.setPhonghoc(rs.getString("Phong"));
                 l.setDayString(rs.getString("Thu"));
                 l.setThoiGian(rs.getString("Thoi_gian"));
                 l.setTietBatDau(rs.getInt("Tiet_bat_dau"));
                 l.setSoTiet(rs.getInt("So_tiet"));
                 l.setKiHoc(rs.getInt("Ki_hoc"));
                 list.add(l);
             }
         } catch (Exception e) {
             e.printStackTrace();
             JOptionPane.showMessageDialog(null, "Error database LichHoc!"); 
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

}