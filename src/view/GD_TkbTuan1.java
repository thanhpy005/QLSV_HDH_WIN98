/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.TkbDAO;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.util.ArrayList; 
import java.util.Iterator; 
import java.util.Properties;
import model.LichHoc;
import model.SinhVien;
import javax.swing.JScrollPane; 
import javax.swing.JPanel; 


public class GD_TkbTuan1 extends javax.swing.JFrame implements ActionListener{
    private ArrayList list; 
    private SinhVien sinhVien;
    
    public GD_TkbTuan1(SinhVien s) {
        initComponents(); 

        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
       
        JPanel originalContentPane = (JPanel) this.getContentPane();

        
        java.awt.Dimension preferredSize = originalContentPane.getPreferredSize();

        
        JPanel mainPanel = new JPanel();
        
    
        mainPanel.setLayout(null); 
        
      
        mainPanel.setPreferredSize(preferredSize);

       
        java.awt.Component[] components = originalContentPane.getComponents();
        for (int k = 0; k < components.length; k++) {
            java.awt.Component comp = components[k];
            
          
            java.awt.Rectangle bounds = comp.getBounds(); 
            
            originalContentPane.remove(comp); 
            mainPanel.add(comp);              
            
       
            comp.setBounds(bounds);           
        }

     
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

    
        this.setContentPane(scrollPane);

      
        setSize(800, 600); 
        setLocationRelativeTo(null); 


        Properties prop = new Properties();
        try {
            InputStream input = getClass().getResourceAsStream("/config.properties");
            if (input != null) {
                prop.load(input);
            }
        } catch (Exception e) {
            e.printStackTrace(); 
        }

        String bgColor = prop.getProperty("backgroundColor", "255,255,255"); 
        String[] rgb = bgColor.split(",");
        int r = Integer.parseInt(rgb[0].trim());
        int g = Integer.parseInt(rgb[1].trim());
        int b = Integer.parseInt(rgb[2].trim());

   
        mainPanel.setBackground(new Color(r, g, b));


        BackButton.addActionListener(this);
        sinhVien = s;
     
        list = new TkbDAO().XemTKbSV(sinhVien.getId(), sinhVien.getSchoolYear());

     
        Iterator iter2 = list.iterator();
        while (iter2.hasNext()) {
            LichHoc i = (LichHoc) iter2.next(); 
            if(i.getDayString().equals(String.valueOf(2))) {
                if(i.getTietBatDau() == 1) {
                    ID_ST2_2T.setText(i.getMamon());
                    Name_ST2_2T.setText(i.getTenmon());
                    Name_ST2_2T.setToolTipText(i.getTenmon());
                    PHONG_ST2_2T.setText("Classroom: "+i.getPhonghoc());
                    Thu2HaiTiet.setBackground(new Color(173, 216, 230));
                } else if(i.getTietBatDau() == 3) {
                    ID_ST2_3T.setText(i.getMamon());
                    NAME_ST2_3T.setText(i.getTenmon());
                    NAME_ST2_3T.setToolTipText(i.getTenmon());
                    PHONG_ST2_3T.setText("Classroom: "+i.getPhonghoc());
                    Thu2BaTiet.setBackground(new Color(173, 216, 230));
                } else if(i.getTietBatDau() == 7) {
                    ID_CT2_2T.setText(i.getMamon());
                    NAME_CT2_2T.setText(i.getTenmon());
                    NAME_CT2_2T.setToolTipText(i.getTenmon());
                    PHONG_CT2_2T.setText("Classroom: "+i.getPhonghoc());
                    Thu2HaiTietChieu.setBackground(new Color(173, 216, 230));
                } else if(i.getTietBatDau() == 9) {
                    ID_CT2_3T.setText(i.getMamon());
                    NAME_CT2_3T.setText(i.getTenmon());
                    NAME_CT2_3T.setToolTipText(i.getTenmon());
                    PHONG_CT2_3T.setText("Classroom: "+i.getPhonghoc());
                    Thu2BaTietChieu.setBackground(new Color(173, 216, 230));
                }
            }
        }

        Iterator iter3 = list.iterator();
        while (iter3.hasNext()) {
             LichHoc i = (LichHoc) iter3.next(); 
             if(i.getDayString().equals(String.valueOf(3))) {
                if(i.getTietBatDau() == 1) {
                    ID_ST3_2T.setText(i.getMamon());
                    NAME_ST3_2T.setText(i.getTenmon());
                    NAME_ST3_2T.setToolTipText(i.getTenmon());
                    PHONG_ST3_2T.setText("Classroom: "+i.getPhonghoc());
                    Thu3HaiTiet.setBackground(new Color(173, 216, 230));
                } else if(i.getTietBatDau() == 3) {
                    ID_ST3_3T.setText(i.getMamon());
                    NAME_ST3_3T.setText(i.getTenmon());
                    NAME_ST3_3T.setToolTipText(i.getTenmon());
                    PHONG_ST3_3T.setText("Classroom: "+i.getPhonghoc());
                    Thu3BaTiet.setBackground(new Color(173, 216, 230));
                } else if(i.getTietBatDau() == 7) {
                    ID_CT3_2T.setText(i.getMamon());
                    NAME_CT3_2T.setText(i.getTenmon());
                    NAME_CT3_2T.setToolTipText(i.getTenmon());
                    PHONG_CT3_2T.setText("Classroom: "+i.getPhonghoc());
                    Thu3HaiTietChieu.setBackground(new Color(173, 216, 230));
                } else if(i.getTietBatDau() == 9) {
                    ID_CT3_3T.setText(i.getMamon());
                    NAME_CT3_3T.setText(i.getTenmon());
                    NAME_CT3_3T.setToolTipText(i.getTenmon());
                    PHONG_CT3_3T.setText("Classroom: "+i.getPhonghoc());
                    Thu3BaTietChieu.setBackground(new Color(173, 216, 230));
                }
            }
        }

     
        Iterator iter4 = list.iterator();
        while (iter4.hasNext()) {
             LichHoc i = (LichHoc) iter4.next(); 
             if(i.getDayString().equals(String.valueOf(4))) {
                if(i.getTietBatDau() == 1) {
                    ID_ST4_2T.setText(i.getMamon());
                    NAME_ST4_2T.setText(i.getTenmon());
                    NAME_ST4_2T.setToolTipText(i.getTenmon());
                    PHONG_ST4_2T.setText("Classroom: "+i.getPhonghoc());
                    Thu4HaiTiet.setBackground(new Color(173, 216, 230));
                } else if(i.getTietBatDau() == 3) {
                    ID_ST4_3T.setText(i.getMamon());
                    NAME_ST4_3T.setText(i.getTenmon());
                    NAME_ST4_3T.setToolTipText(i.getTenmon());
                    PHONG_ST4_3T.setText("Classroom: "+i.getPhonghoc());
                    Thu4BaTiet.setBackground(new Color(173, 216, 230));
                } else if(i.getTietBatDau() == 7) {
                    ID_CT4_2T.setText(i.getMamon());
                    NAME_CT4_2T.setText(i.getTenmon());
                    NAME_CT4_2T.setToolTipText(i.getTenmon());
                    PHONG_CT4_2T.setText("Classroom: "+i.getPhonghoc());
                    Thu4HaiTietChieu.setBackground(new Color(173, 216, 230));
                } else if(i.getTietBatDau() == 9) {
                    ID_CT4_3T.setText(i.getMamon());
                    NAME_CT4_3T.setText(i.getTenmon());
                    NAME_CT4_3T.setToolTipText(i.getTenmon());
                    PHONG_CT4_3T.setText("Classroom: "+i.getPhonghoc());
                    Thu4BaTietChieu.setBackground(new Color(173, 216, 230));
                }
            }
        }

       
        Iterator iter5 = list.iterator();
        while (iter5.hasNext()) {
             LichHoc i = (LichHoc) iter5.next(); 
             if(i.getDayString().equals(String.valueOf(5))) {
                 if(i.getTietBatDau() == 1) {
                    ID_ST5_2T.setText(i.getMamon());
                    NAME_ST5_2T.setText(i.getTenmon());
                    NAME_ST5_2T.setToolTipText(i.getTenmon());
                    PHONG_ST5_2T.setText("Classroom: "+i.getPhonghoc());
                    Thu5HaiTiet.setBackground(new Color(173, 216, 230));
                } else if(i.getTietBatDau() == 3) {
                    ID_ST5_3T.setText(i.getMamon());
                    NAME_ST5_3T.setText(i.getTenmon());
                    NAME_ST5_3T.setToolTipText(i.getTenmon());
                    PHONG_ST5_3T.setText("Classroom: "+i.getPhonghoc());
                    Thu5BaTiet.setBackground(new Color(173, 216, 230));
                } else if(i.getTietBatDau() == 7) {
                    ID_CT5_2T.setText(i.getMamon());
                    NAME_CT5_2T.setText(i.getTenmon());
                    NAME_CT5_2T.setToolTipText(i.getTenmon());
                    PHONG_CT5_2T.setText("Classroom: "+i.getPhonghoc());
                    Thu5HaiTietChieu.setBackground(new Color(173, 216, 230));
                } else if(i.getTietBatDau() == 9) {
                    ID_CT5_3T.setText(i.getMamon());
                    NAME_CT5_3T.setText(i.getTenmon());
                    NAME_CT5_3T.setToolTipText(i.getTenmon());
                    PHONG_CT5_3T.setText("Classroom: "+i.getPhonghoc());
                    Thu5BaTietChieu.setBackground(new Color(173, 216, 230));
                }
             }
        }

        // Vòng lặp 5: Thứ 6
        Iterator iter6 = list.iterator();
        while (iter6.hasNext()) {
             LichHoc i = (LichHoc) iter6.next(); // Phải ép kiểu
             if(i.getDayString().equals(String.valueOf(6))) {
                 if(i.getTietBatDau() == 1) {
                    ID_ST6_2T.setText(i.getMamon());
                    NAME_ST6_2T.setText(i.getTenmon());
                    NAME_ST6_2T.setToolTipText(i.getTenmon());
                    PHONG_ST6_2T.setText("Classroom: "+i.getPhonghoc());
                    Thu6HaiTiet.setBackground(new Color(173, 216, 230));
                } else if(i.getTietBatDau() == 3) {
                    ID_ST6_3T.setText(i.getMamon());
                    NAME_ST6_3T.setText(i.getTenmon());
                    NAME_ST6_3T.setToolTipText(i.getTenmon());
                    PHONG_ST6_3T.setText("Classroom: "+i.getPhonghoc());
                    Thu6BaTiet.setBackground(new Color(173, 216, 230));
                } else if(i.getTietBatDau() == 7) {
                    ID_CT6_2T.setText(i.getMamon());
                    NAME_CT6_2T.setText(i.getTenmon());
                    NAME_CT6_2T.setToolTipText(i.getTenmon());
                    PHONG_CT6_2T.setText("Classroom: "+i.getPhonghoc());
                    Thu6HaiTietChieu.setBackground(new Color(173, 216, 230));
                } else if(i.getTietBatDau() == 9) {
                    ID_CT6_3T.setText(i.getMamon());
                    NAME_CT6_3T.setText(i.getTenmon());
                    NAME_CT6_3T.setToolTipText(i.getTenmon());
                    PHONG_CT6_3T.setText("Classroom: "+i.getPhonghoc());
                    Thu6BaTietChieu.setBackground(new Color(173, 216, 230));
                }
            }
        }

      
        Iterator iter7 = list.iterator();
        while (iter7.hasNext()) {
             LichHoc i = (LichHoc) iter7.next(); 
             if(i.getDayString().equals(String.valueOf(7))) {
                if(i.getTietBatDau() == 1) {
                    ID_ST7_2T.setText(i.getMamon());
                    NAME_ST7_2T.setText(i.getTenmon());
                    NAME_ST7_2T.setToolTipText(i.getTenmon());
                    PHONG_ST7_2T.setText("Classroom: "+i.getPhonghoc());
                    Thu7HaiTiet.setBackground(new Color(173, 216, 230));
                } else if(i.getTietBatDau() == 3) {
                    ID_ST7_3T.setText(i.getMamon());
                    NAME_ST7_3T.setText(i.getTenmon());
                    NAME_ST7_3T.setToolTipText(i.getTenmon());
                    PHONG_ST7_3T.setText("Classroom: "+i.getPhonghoc());
                    Thu7BaTiet.setBackground(new Color(173, 216, 230));
                } else if(i.getTietBatDau() == 7) {
                    ID_CT7_2T.setText(i.getMamon());
                    NAME_CT7_2T.setText(i.getTenmon());
                    NAME_CT7_2T.setToolTipText(i.getTenmon());
                    PHONG_CT7_2T.setText("Classroom: "+i.getPhonghoc());
                    Thu7HaiTietChieu.setBackground(new Color(173, 216, 230));
                } else if(i.getTietBatDau() == 9) {
                    ID_CT7_3T.setText(i.getMamon());
                    NAME_CT7_3T.setText(i.getTenmon());
                    NAME_CT7_3T.setToolTipText(i.getTenmon());
                    PHONG_CT7_3T.setText("Classroom: "+i.getPhonghoc());
                    Thu7BaTietChieu.setBackground(new Color(173, 216, 230));
                }
            }
        }
    }                           
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        Thu2HaiTiet = new javax.swing.JPanel();
        ID_ST2_2T = new javax.swing.JLabel();
        Name_ST2_2T = new javax.swing.JLabel();
        PHONG_ST2_2T = new javax.swing.JLabel();
        Thu3HaiTiet = new javax.swing.JPanel();
        ID_ST3_2T = new javax.swing.JLabel();
        NAME_ST3_2T = new javax.swing.JLabel();
        PHONG_ST3_2T = new javax.swing.JLabel();
        Thu4HaiTiet = new javax.swing.JPanel();
        ID_ST4_2T = new javax.swing.JLabel();
        NAME_ST4_2T = new javax.swing.JLabel();
        PHONG_ST4_2T = new javax.swing.JLabel();
        Thu5HaiTiet = new javax.swing.JPanel();
        ID_ST5_2T = new javax.swing.JLabel();
        NAME_ST5_2T = new javax.swing.JLabel();
        PHONG_ST5_2T = new javax.swing.JLabel();
        Thu6HaiTiet = new javax.swing.JPanel();
        ID_ST6_2T = new javax.swing.JLabel();
        NAME_ST6_2T = new javax.swing.JLabel();
        PHONG_ST6_2T = new javax.swing.JLabel();
        Thu7HaiTiet = new javax.swing.JPanel();
        ID_ST7_2T = new javax.swing.JLabel();
        NAME_ST7_2T = new javax.swing.JLabel();
        PHONG_ST7_2T = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        Thu2BaTiet = new javax.swing.JPanel();
        ID_ST2_3T = new javax.swing.JLabel();
        NAME_ST2_3T = new javax.swing.JLabel();
        PHONG_ST2_3T = new javax.swing.JLabel();
        Thu3BaTiet = new javax.swing.JPanel();
        ID_ST3_3T = new javax.swing.JLabel();
        NAME_ST3_3T = new javax.swing.JLabel();
        PHONG_ST3_3T = new javax.swing.JLabel();
        Thu4BaTiet = new javax.swing.JPanel();
        ID_ST4_3T = new javax.swing.JLabel();
        NAME_ST4_3T = new javax.swing.JLabel();
        PHONG_ST4_3T = new javax.swing.JLabel();
        Thu5BaTiet = new javax.swing.JPanel();
        ID_ST5_3T = new javax.swing.JLabel();
        NAME_ST5_3T = new javax.swing.JLabel();
        PHONG_ST5_3T = new javax.swing.JLabel();
        Thu6BaTiet = new javax.swing.JPanel();
        ID_ST6_3T = new javax.swing.JLabel();
        NAME_ST6_3T = new javax.swing.JLabel();
        PHONG_ST6_3T = new javax.swing.JLabel();
        Thu7BaTiet = new javax.swing.JPanel();
        ID_ST7_3T = new javax.swing.JLabel();
        NAME_ST7_3T = new javax.swing.JLabel();
        PHONG_ST7_3T = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        Thu2HaiTietChieu = new javax.swing.JPanel();
        ID_CT2_2T = new javax.swing.JLabel();
        NAME_CT2_2T = new javax.swing.JLabel();
        PHONG_CT2_2T = new javax.swing.JLabel();
        Thu3HaiTietChieu = new javax.swing.JPanel();
        ID_CT3_2T = new javax.swing.JLabel();
        NAME_CT3_2T = new javax.swing.JLabel();
        PHONG_CT3_2T = new javax.swing.JLabel();
        Thu4HaiTietChieu = new javax.swing.JPanel();
        ID_CT4_2T = new javax.swing.JLabel();
        NAME_CT4_2T = new javax.swing.JLabel();
        PHONG_CT4_2T = new javax.swing.JLabel();
        Thu5HaiTietChieu = new javax.swing.JPanel();
        ID_CT5_2T = new javax.swing.JLabel();
        NAME_CT5_2T = new javax.swing.JLabel();
        PHONG_CT5_2T = new javax.swing.JLabel();
        Thu6HaiTietChieu = new javax.swing.JPanel();
        ID_CT6_2T = new javax.swing.JLabel();
        NAME_CT6_2T = new javax.swing.JLabel();
        PHONG_CT6_2T = new javax.swing.JLabel();
        Thu7HaiTietChieu = new javax.swing.JPanel();
        ID_CT7_2T = new javax.swing.JLabel();
        NAME_CT7_2T = new javax.swing.JLabel();
        PHONG_CT7_2T = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        Thu2BaTietChieu = new javax.swing.JPanel();
        ID_CT2_3T = new javax.swing.JLabel();
        NAME_CT2_3T = new javax.swing.JLabel();
        PHONG_CT2_3T = new javax.swing.JLabel();
        Thu3BaTietChieu = new javax.swing.JPanel();
        ID_CT3_3T = new javax.swing.JLabel();
        NAME_CT3_3T = new javax.swing.JLabel();
        PHONG_CT3_3T = new javax.swing.JLabel();
        Thu4BaTietChieu = new javax.swing.JPanel();
        ID_CT4_3T = new javax.swing.JLabel();
        NAME_CT4_3T = new javax.swing.JLabel();
        PHONG_CT4_3T = new javax.swing.JLabel();
        Thu5BaTietChieu = new javax.swing.JPanel();
        ID_CT5_3T = new javax.swing.JLabel();
        NAME_CT5_3T = new javax.swing.JLabel();
        PHONG_CT5_3T = new javax.swing.JLabel();
        Thu6BaTietChieu = new javax.swing.JPanel();
        ID_CT6_3T = new javax.swing.JLabel();
        NAME_CT6_3T = new javax.swing.JLabel();
        PHONG_CT6_3T = new javax.swing.JLabel();
        Thu7BaTietChieu = new javax.swing.JPanel();
        ID_CT7_3T = new javax.swing.JLabel();
        NAME_CT7_3T = new javax.swing.JLabel();
        PHONG_CT7_3T = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        jPanel39 = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        jPanel40 = new javax.swing.JPanel();
        jPanel41 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel42 = new javax.swing.JPanel();
        BackButton = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Timetable");
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1199, 48));

        jLabel2.setBackground(new java.awt.Color(255, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Lesson 2");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel2.setOpaque(true);
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 122, 100, 37));

        jLabel3.setBackground(new java.awt.Color(255, 0, 0));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Lesson 1");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel3.setOpaque(true);
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 85, 100, 37));

        jLabel4.setBackground(new java.awt.Color(255, 0, 0));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Lesson 3");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel4.setOpaque(true);
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 159, 100, 37));

        jLabel5.setBackground(new java.awt.Color(255, 0, 0));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Lesson 4");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel5.setOpaque(true);
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 196, 100, 37));

        jLabel6.setBackground(new java.awt.Color(255, 0, 0));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Lesson 5");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel6.setOpaque(true);
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 233, 100, 37));

        jLabel7.setBackground(new java.awt.Color(255, 0, 0));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Lesson 6");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel7.setOpaque(true);
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 100, 37));

        jLabel8.setBackground(new java.awt.Color(255, 0, 0));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Lesson 7");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel8.setOpaque(true);
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 307, 100, 37));

        jLabel9.setBackground(new java.awt.Color(255, 0, 0));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Lesson 8");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel9.setOpaque(true);
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 344, 100, 37));

        jLabel10.setBackground(new java.awt.Color(255, 0, 0));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Lesson 9");
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel10.setOpaque(true);
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 381, 100, 37));

        jLabel11.setBackground(new java.awt.Color(255, 0, 0));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Lesson 10");
        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel11.setOpaque(true);
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 418, 100, 37));

        jLabel12.setBackground(new java.awt.Color(255, 0, 0));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Lesson 11");
        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel12.setOpaque(true);
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 455, 100, 37));

        jLabel13.setBackground(new java.awt.Color(255, 0, 0));
        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Lesson 12");
        jLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel13.setOpaque(true);
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 492, 100, 37));

        jLabel14.setBackground(new java.awt.Color(255, 0, 0));
        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Monday");
        jLabel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel14.setOpaque(true);
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 48, 141, 37));

        jLabel15.setBackground(new java.awt.Color(255, 0, 0));
        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Tuesday");
        jLabel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel15.setOpaque(true);
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 48, 139, 37));

        jLabel16.setBackground(new java.awt.Color(255, 0, 0));
        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Wednesday");
        jLabel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel16.setOpaque(true);
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 48, 139, 37));

        jLabel17.setBackground(new java.awt.Color(255, 0, 0));
        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Thursday");
        jLabel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel17.setOpaque(true);
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 48, 139, 37));

        jLabel18.setBackground(new java.awt.Color(255, 0, 0));
        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Friday");
        jLabel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel18.setOpaque(true);
        getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(659, 48, 139, 37));

        jLabel19.setBackground(new java.awt.Color(255, 0, 0));
        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Saturday");
        jLabel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel19.setOpaque(true);
        getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(798, 48, 161, 37));

        jLabel20.setBackground(new java.awt.Color(255, 0, 0));
        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Sunday");
        jLabel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel20.setOpaque(true);
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(959, 48, 140, 40));

        jLabel21.setBackground(new java.awt.Color(255, 0, 0));
        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("7:00");
        jLabel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel21.setOpaque(true);
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(1099, 85, 100, 37));

        jLabel22.setBackground(new java.awt.Color(255, 0, 0));
        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("8:00");
        jLabel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel22.setOpaque(true);
        getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(1099, 122, 100, 37));

        jLabel23.setBackground(new java.awt.Color(255, 0, 0));
        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("9:00");
        jLabel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel23.setOpaque(true);
        getContentPane().add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(1099, 159, 100, 37));

        jLabel24.setBackground(new java.awt.Color(255, 0, 0));
        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("10:00");
        jLabel24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel24.setOpaque(true);
        getContentPane().add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(1099, 196, 100, 37));

        jLabel25.setBackground(new java.awt.Color(255, 0, 0));
        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("11:00");
        jLabel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel25.setOpaque(true);
        getContentPane().add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(1099, 233, 100, 37));

        jLabel26.setBackground(new java.awt.Color(255, 0, 0));
        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("12:00");
        jLabel26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel26.setOpaque(true);
        getContentPane().add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(1099, 270, 100, 37));

        jLabel27.setBackground(new java.awt.Color(255, 0, 0));
        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("13:00");
        jLabel27.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel27.setOpaque(true);
        getContentPane().add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(1099, 307, 100, 37));

        jLabel28.setBackground(new java.awt.Color(255, 0, 0));
        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("14:00");
        jLabel28.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel28.setOpaque(true);
        getContentPane().add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(1099, 344, 100, 37));

        jLabel29.setBackground(new java.awt.Color(255, 0, 0));
        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("15:00");
        jLabel29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel29.setOpaque(true);
        getContentPane().add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(1099, 381, 100, 37));

        jLabel30.setBackground(new java.awt.Color(255, 0, 0));
        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("16:00");
        jLabel30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel30.setOpaque(true);
        getContentPane().add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(1099, 418, 100, 37));

        jLabel31.setBackground(new java.awt.Color(255, 0, 0));
        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("17:00");
        jLabel31.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel31.setOpaque(true);
        getContentPane().add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(1099, 455, 100, 37));

        jLabel32.setBackground(new java.awt.Color(255, 0, 0));
        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("18:00");
        jLabel32.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel32.setOpaque(true);
        getContentPane().add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(1099, 492, 100, 37));

        jLabel33.setBackground(new java.awt.Color(255, 0, 0));
        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel33.setText("Monday");
        jLabel33.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel33.setOpaque(true);
        getContentPane().add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 531, 142, 37));

        jLabel34.setBackground(new java.awt.Color(255, 0, 0));
        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Tuesday");
        jLabel34.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel34.setOpaque(true);
        getContentPane().add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 531, 139, 37));

        jLabel35.setBackground(new java.awt.Color(255, 0, 0));
        jLabel35.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("Wednesday");
        jLabel35.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel35.setOpaque(true);
        getContentPane().add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 531, 139, 37));

        jLabel36.setBackground(new java.awt.Color(255, 0, 0));
        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel36.setText("Thursday");
        jLabel36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel36.setOpaque(true);
        getContentPane().add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 531, 139, 37));

        jLabel37.setBackground(new java.awt.Color(255, 0, 0));
        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("Friday");
        jLabel37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel37.setOpaque(true);
        getContentPane().add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(659, 531, 139, 37));

        jLabel38.setBackground(new java.awt.Color(255, 0, 0));
        jLabel38.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Saturday");
        jLabel38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel38.setOpaque(true);
        getContentPane().add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(798, 531, 161, 37));

        jLabel39.setBackground(new java.awt.Color(255, 0, 0));
        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel39.setText("Sunday");
        jLabel39.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel39.setOpaque(true);
        getContentPane().add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(959, 531, 140, 37));

        Thu2HaiTiet.setBackground(new java.awt.Color(255, 255, 255));
        Thu2HaiTiet.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        Thu2HaiTiet.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ID_ST2_2T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu2HaiTiet.add(ID_ST2_2T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 7, 127, -1));

        Name_ST2_2T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu2HaiTiet.add(Name_ST2_2T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7,30, 127, -1));

        PHONG_ST2_2T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu2HaiTiet.add(PHONG_ST2_2T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 53, 127, -1));

        getContentPane().add(Thu2HaiTiet, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 85, 140, 74));

        Thu3HaiTiet.setBackground(new java.awt.Color(255, 255, 255));
        Thu3HaiTiet.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Thu3HaiTiet.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ID_ST3_2T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu3HaiTiet.add(ID_ST3_2T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 7, 125, -1));

        NAME_ST3_2T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu3HaiTiet.add(NAME_ST3_2T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 30, 125, -1));

        PHONG_ST3_2T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu3HaiTiet.add(PHONG_ST3_2T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 53, 125, -1));

        getContentPane().add(Thu3HaiTiet, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 85, 140, 74));

        Thu4HaiTiet.setBackground(new java.awt.Color(255, 255, 255));
        Thu4HaiTiet.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Thu4HaiTiet.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ID_ST4_2T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu4HaiTiet.add(ID_ST4_2T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 7, 125, -1));

        NAME_ST4_2T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu4HaiTiet.add(NAME_ST4_2T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 30, 125, -1));

        PHONG_ST4_2T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu4HaiTiet.add(PHONG_ST4_2T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 53, 125, -1));

        getContentPane().add(Thu4HaiTiet, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 85, 140, 74));

        Thu5HaiTiet.setBackground(new java.awt.Color(255, 255, 255));
        Thu5HaiTiet.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Thu5HaiTiet.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ID_ST5_2T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu5HaiTiet.add(ID_ST5_2T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 7, 125, -1));

        NAME_ST5_2T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu5HaiTiet.add(NAME_ST5_2T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 30, 125, -1));

        PHONG_ST5_2T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu5HaiTiet.add(PHONG_ST5_2T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 53, 125, -1));

        getContentPane().add(Thu5HaiTiet, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 85, 140, 74));

        Thu6HaiTiet.setBackground(new java.awt.Color(255, 255, 255));
        Thu6HaiTiet.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Thu6HaiTiet.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ID_ST6_2T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu6HaiTiet.add(ID_ST6_2T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 7, 125, -1));

        NAME_ST6_2T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu6HaiTiet.add(NAME_ST6_2T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 30, 125, -1));

        PHONG_ST6_2T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu6HaiTiet.add(PHONG_ST6_2T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 53, 125, -1));

        getContentPane().add(Thu6HaiTiet, new org.netbeans.lib.awtextra.AbsoluteConstraints(659, 85, 140, 74));

        Thu7HaiTiet.setBackground(new java.awt.Color(255, 255, 255));
        Thu7HaiTiet.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Thu7HaiTiet.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ID_ST7_2T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu7HaiTiet.add(ID_ST7_2T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 7, 147, -1));

        NAME_ST7_2T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu7HaiTiet.add(NAME_ST7_2T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 30, 147, -1));

        PHONG_ST7_2T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu7HaiTiet.add(PHONG_ST7_2T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 53, 147, -1));

        getContentPane().add(Thu7HaiTiet, new org.netbeans.lib.awtextra.AbsoluteConstraints(798, 85, 160, 74));

        jPanel8.setBackground(java.awt.Color.white);
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(959, 85, -1, 74));

        Thu2BaTiet.setBackground(new java.awt.Color(255, 255, 255));
        Thu2BaTiet.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Thu2BaTiet.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ID_ST2_3T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu2BaTiet.add(ID_ST2_3T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 7, 127, -1));

        NAME_ST2_3T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu2BaTiet.add(NAME_ST2_3T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 30, 127, -1));

        PHONG_ST2_3T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu2BaTiet.add(PHONG_ST2_3T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 53, 127, -1));

        getContentPane().add(Thu2BaTiet, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 159, 140, 111));

        Thu3BaTiet.setBackground(new java.awt.Color(255, 255, 255));
        Thu3BaTiet.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Thu3BaTiet.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ID_ST3_3T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu3BaTiet.add(ID_ST3_3T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 7, 125, -1));

        NAME_ST3_3T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu3BaTiet.add(NAME_ST3_3T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 30, 125, -1));

        PHONG_ST3_3T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu3BaTiet.add(PHONG_ST3_3T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 53, 125, -1));

        getContentPane().add(Thu3BaTiet, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 159, 140, 111));

        Thu4BaTiet.setBackground(new java.awt.Color(255, 255, 255));
        Thu4BaTiet.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Thu4BaTiet.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ID_ST4_3T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu4BaTiet.add(ID_ST4_3T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 7, 125, -1));

        NAME_ST4_3T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu4BaTiet.add(NAME_ST4_3T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 30, 125, -1));

        PHONG_ST4_3T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu4BaTiet.add(PHONG_ST4_3T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 53, 125, -1));

        getContentPane().add(Thu4BaTiet, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 159, 140, 111));

        Thu5BaTiet.setBackground(new java.awt.Color(255, 255, 255));
        Thu5BaTiet.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Thu5BaTiet.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ID_ST5_3T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu5BaTiet.add(ID_ST5_3T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 7, 125, -1));

        NAME_ST5_3T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu5BaTiet.add(NAME_ST5_3T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 30, 125, -1));

        PHONG_ST5_3T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu5BaTiet.add(PHONG_ST5_3T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7,53, 125, -1));

        getContentPane().add(Thu5BaTiet, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 159, 140, 111));

        Thu6BaTiet.setBackground(new java.awt.Color(255, 255, 255));
        Thu6BaTiet.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Thu6BaTiet.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ID_ST6_3T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu6BaTiet.add(ID_ST6_3T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 7, 125, -1));

        NAME_ST6_3T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu6BaTiet.add(NAME_ST6_3T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 30, 125, -1));

        PHONG_ST6_3T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu6BaTiet.add(PHONG_ST6_3T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 53, 125, -1));

        getContentPane().add(Thu6BaTiet, new org.netbeans.lib.awtextra.AbsoluteConstraints(659, 159, 140, 111));

        Thu7BaTiet.setBackground(new java.awt.Color(255, 255, 255));
        Thu7BaTiet.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Thu7BaTiet.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ID_ST7_3T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu7BaTiet.add(ID_ST7_3T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 7, 147, -1));

        NAME_ST7_3T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu7BaTiet.add(NAME_ST7_3T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 30, 147, -1));

        PHONG_ST7_3T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu7BaTiet.add(PHONG_ST7_3T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 53, 147, -1));

        getContentPane().add(Thu7BaTiet, new org.netbeans.lib.awtextra.AbsoluteConstraints(798, 159, 160, 111));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 160, 140, 111));

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 270, -1, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 270, 139, -1));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 270, 139, -1));

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 270, 139, -1));

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(659, 270, 139, -1));

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(798, 270, 161, -1));

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));
        jPanel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(959, 270, 140, -1));

        Thu2HaiTietChieu.setBackground(new java.awt.Color(255, 255, 255));
        Thu2HaiTietChieu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Thu2HaiTietChieu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ID_CT2_2T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu2HaiTietChieu.add(ID_CT2_2T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 7, 127, -1));

        NAME_CT2_2T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu2HaiTietChieu.add(NAME_CT2_2T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 30, 127, 16));

        PHONG_CT2_2T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu2HaiTietChieu.add(PHONG_CT2_2T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 53,127, -1));

        getContentPane().add(Thu2HaiTietChieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 307, 140, 74));

        Thu3HaiTietChieu.setBackground(new java.awt.Color(255, 255, 255));
        Thu3HaiTietChieu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Thu3HaiTietChieu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ID_CT3_2T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu3HaiTietChieu.add(ID_CT3_2T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 7, 125, -1));

        NAME_CT3_2T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu3HaiTietChieu.add(NAME_CT3_2T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 30, 125, -1));

        PHONG_CT3_2T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu3HaiTietChieu.add(PHONG_CT3_2T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 53, 125, -1));

        getContentPane().add(Thu3HaiTietChieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 307, 140, 74));

        Thu4HaiTietChieu.setBackground(new java.awt.Color(255, 255, 255));
        Thu4HaiTietChieu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Thu4HaiTietChieu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ID_CT4_2T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu4HaiTietChieu.add(ID_CT4_2T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 7, 125, -1));

        NAME_CT4_2T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu4HaiTietChieu.add(NAME_CT4_2T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 30, 125, -1));

        PHONG_CT4_2T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu4HaiTietChieu.add(PHONG_CT4_2T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 53, 125, -1));

        getContentPane().add(Thu4HaiTietChieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 307, 140, 74));

        Thu5HaiTietChieu.setBackground(new java.awt.Color(255, 255, 255));
        Thu5HaiTietChieu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Thu5HaiTietChieu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ID_CT5_2T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu5HaiTietChieu.add(ID_CT5_2T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 7, 125, -1));

        NAME_CT5_2T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu5HaiTietChieu.add(NAME_CT5_2T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 30, 125, -1));

        PHONG_CT5_2T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu5HaiTietChieu.add(PHONG_CT5_2T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 53, 125, -1));

        getContentPane().add(Thu5HaiTietChieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 307, 140, 74));

        Thu6HaiTietChieu.setBackground(new java.awt.Color(255, 255, 255));
        Thu6HaiTietChieu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Thu6HaiTietChieu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ID_CT6_2T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu6HaiTietChieu.add(ID_CT6_2T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 7, 125, -1));

        NAME_CT6_2T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu6HaiTietChieu.add(NAME_CT6_2T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 30, 125, -1));

        PHONG_CT6_2T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu6HaiTietChieu.add(PHONG_CT6_2T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 53,125, -1));

        getContentPane().add(Thu6HaiTietChieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(659, 307, 140, 74));

        Thu7HaiTietChieu.setBackground(new java.awt.Color(255, 255, 255));
        Thu7HaiTietChieu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Thu7HaiTietChieu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ID_CT7_2T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu7HaiTietChieu.add(ID_CT7_2T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 7, 147, -1));

        NAME_CT7_2T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu7HaiTietChieu.add(NAME_CT7_2T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 30, 147, -1));

        PHONG_CT7_2T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu7HaiTietChieu.add(PHONG_CT7_2T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 53, 147, -1));

        getContentPane().add(Thu7HaiTietChieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(798, 307, 160, 74));

        jPanel29.setBackground(new java.awt.Color(255, 255, 255));
        jPanel29.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel29.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel30.setBackground(new java.awt.Color(255, 255, 255));
        jPanel30.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel30.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel29.add(jPanel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(959, 307, 140, 74));

        getContentPane().add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(959, 307, 140, 74));

        Thu2BaTietChieu.setBackground(new java.awt.Color(255, 255, 255));
        Thu2BaTietChieu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Thu2BaTietChieu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ID_CT2_3T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu2BaTietChieu.add(ID_CT2_3T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 7, 127, -1));

        NAME_CT2_3T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu2BaTietChieu.add(NAME_CT2_3T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 30, 127, -1));

        PHONG_CT2_3T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu2BaTietChieu.add(PHONG_CT2_3T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 53, 127, -1));

        getContentPane().add(Thu2BaTietChieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 381, 140, 111));

        Thu3BaTietChieu.setBackground(new java.awt.Color(255, 255, 255));
        Thu3BaTietChieu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Thu3BaTietChieu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ID_CT3_3T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu3BaTietChieu.add(ID_CT3_3T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 7, 125, -1));

        NAME_CT3_3T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu3BaTietChieu.add(NAME_CT3_3T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 30, 125, -1));

        PHONG_CT3_3T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu3BaTietChieu.add(PHONG_CT3_3T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 53, 125, -1));

        getContentPane().add(Thu3BaTietChieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 381, 140, 111));

        Thu4BaTietChieu.setBackground(new java.awt.Color(255, 255, 255));
        Thu4BaTietChieu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Thu4BaTietChieu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ID_CT4_3T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu4BaTietChieu.add(ID_CT4_3T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 7, 125, -1));

        NAME_CT4_3T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu4BaTietChieu.add(NAME_CT4_3T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 30, 125, -1));

        PHONG_CT4_3T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu4BaTietChieu.add(PHONG_CT4_3T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 53, 125, -1));

        getContentPane().add(Thu4BaTietChieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 381, 140, 111));

        Thu5BaTietChieu.setBackground(new java.awt.Color(255, 255, 255));
        Thu5BaTietChieu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Thu5BaTietChieu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ID_CT5_3T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu5BaTietChieu.add(ID_CT5_3T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 7, 125, -1));

        NAME_CT5_3T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu5BaTietChieu.add(NAME_CT5_3T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 30, 125, -1));

        PHONG_CT5_3T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu5BaTietChieu.add(PHONG_CT5_3T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 53, 125, -1));

        getContentPane().add(Thu5BaTietChieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 381, 140, 111));

        Thu6BaTietChieu.setBackground(new java.awt.Color(255, 255, 255));
        Thu6BaTietChieu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Thu6BaTietChieu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ID_CT6_3T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu6BaTietChieu.add(ID_CT6_3T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 7, 125, -1));

        NAME_CT6_3T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu6BaTietChieu.add(NAME_CT6_3T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 30, 125, -1));

        PHONG_CT6_3T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu6BaTietChieu.add(PHONG_CT6_3T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 53, 125, -1));

        getContentPane().add(Thu6BaTietChieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(659, 381, 140, 111));

        Thu7BaTietChieu.setBackground(new java.awt.Color(255, 255, 255));
        Thu7BaTietChieu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Thu7BaTietChieu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ID_CT7_3T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu7BaTietChieu.add(ID_CT7_3T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 7, 147, -1));

        NAME_CT7_3T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu7BaTietChieu.add(NAME_CT7_3T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 30, 147, -1));

        PHONG_CT7_3T.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Thu7BaTietChieu.add(PHONG_CT7_3T, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 53, 147, -1));

        getContentPane().add(Thu7BaTietChieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(798, 381, 160, 111));

        jPanel36.setBackground(new java.awt.Color(255, 255, 255));
        jPanel36.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel36.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(959, 381, 140, 111));

        jPanel37.setBackground(new java.awt.Color(255, 255, 255));
        jPanel37.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel37.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 492, 141, -1));

        jPanel39.setBackground(new java.awt.Color(255, 255, 255));
        jPanel39.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel39.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(242, 492, 139, -1));

        jPanel38.setBackground(new java.awt.Color(255, 255, 255));
        jPanel38.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel38.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(381, 492, 139, -1));

        jPanel40.setBackground(new java.awt.Color(255, 255, 255));
        jPanel40.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel40.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 492, 139, -1));

        jPanel41.setBackground(new java.awt.Color(255, 255, 255));
        jPanel41.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel41.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(659, 492, 139, -1));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(798, 492, 161, -1));

        jPanel42.setBackground(new java.awt.Color(255, 255, 255));
        jPanel42.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel42.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(959, 492, 140, -1));

        BackButton.setText("Back");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });
        getContentPane().add(BackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 596, -1, -1));

        jLabel40.setBackground(new java.awt.Color(255, 0, 0));
        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel40.setOpaque(true);
        getContentPane().add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 48, 100, 37));

        jLabel42.setBackground(new java.awt.Color(255, 0, 0));
        jLabel42.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel42.setOpaque(true);
        getContentPane().add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(1099, 529, 100, 39));

        jLabel43.setBackground(new java.awt.Color(255, 0, 0));
        jLabel43.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel43.setOpaque(true);
        getContentPane().add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 529, 100, 39));

        jLabel41.setBackground(new java.awt.Color(255, 0, 0));
        jLabel41.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel41.setOpaque(true);
        getContentPane().add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(1099, 48, 100, 37));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 80, 140, 80));

        pack();
    }// </editor-fold>                        

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        
        GD_Menu_SV1 winD_Menu_SV = new GD_Menu_SV1(sinhVien);
        winD_Menu_SV.setLocationRelativeTo(null);
        winD_Menu_SV.setVisible(true);
        this.dispose();
    }                                          

   
    public static void main(String args[]) {
       
        try {
            
            javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException ex) {
            System.err.println("Windows LookAndFeel không tìm thấy: " + ex.getMessage());
            try {
                
                javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getCrossPlatformLookAndFeelClassName());
            } catch (Exception e) {
                 System.err.println("Không thể set LookAndFeel mặc định: " + e.getMessage());
            }
        } catch (InstantiationException ex) {
             System.err.println("Không thể khởi tạo Windows LookAndFeel: " + ex.getMessage());
        } catch (IllegalAccessException ex) {
             System.err.println("Không thể truy cập Windows LookAndFeel: " + ex.getMessage());
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
             System.err.println("Windows LookAndFeel không được hỗ trợ: " + ex.getMessage());
        }
        //</editor-fold>

       

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton BackButton;
    private javax.swing.JLabel ID_CT2_2T;
    private javax.swing.JLabel ID_CT2_3T;
    private javax.swing.JLabel ID_CT3_2T;
    private javax.swing.JLabel ID_CT3_3T;
    private javax.swing.JLabel ID_CT4_2T;
    private javax.swing.JLabel ID_CT4_3T;
    private javax.swing.JLabel ID_CT5_2T;
    private javax.swing.JLabel ID_CT5_3T;
    private javax.swing.JLabel ID_CT6_2T;
    private javax.swing.JLabel ID_CT6_3T;
    private javax.swing.JLabel ID_CT7_2T;
    private javax.swing.JLabel ID_CT7_3T;
    private javax.swing.JLabel ID_ST2_2T;
    private javax.swing.JLabel ID_ST2_3T;
    private javax.swing.JLabel ID_ST3_2T;
    private javax.swing.JLabel ID_ST3_3T;
    private javax.swing.JLabel ID_ST4_2T;
    private javax.swing.JLabel ID_ST4_3T;
    private javax.swing.JLabel ID_ST5_2T;
    private javax.swing.JLabel ID_ST5_3T;
    private javax.swing.JLabel ID_ST6_2T;
    private javax.swing.JLabel ID_ST6_3T;
    private javax.swing.JLabel ID_ST7_2T;
    private javax.swing.JLabel ID_ST7_3T;
    private javax.swing.JLabel NAME_CT2_2T;
    private javax.swing.JLabel NAME_CT2_3T;
    private javax.swing.JLabel NAME_CT3_2T;
    private javax.swing.JLabel NAME_CT3_3T;
    private javax.swing.JLabel NAME_CT4_2T;
    private javax.swing.JLabel NAME_CT4_3T;
    private javax.swing.JLabel NAME_CT5_2T;
    private javax.swing.JLabel NAME_CT5_3T;
    private javax.swing.JLabel NAME_CT6_2T;
    private javax.swing.JLabel NAME_CT6_3T;
    private javax.swing.JLabel NAME_CT7_2T;
    private javax.swing.JLabel NAME_CT7_3T;
    private javax.swing.JLabel NAME_ST2_3T;
    private javax.swing.JLabel NAME_ST3_2T;
    private javax.swing.JLabel NAME_ST3_3T;
    private javax.swing.JLabel NAME_ST4_2T;
    private javax.swing.JLabel NAME_ST4_3T;
    private javax.swing.JLabel NAME_ST5_2T;
    private javax.swing.JLabel NAME_ST5_3T;
    private javax.swing.JLabel NAME_ST6_2T;
    private javax.swing.JLabel NAME_ST6_3T;
    private javax.swing.JLabel NAME_ST7_2T;
    private javax.swing.JLabel NAME_ST7_3T;
    private javax.swing.JLabel Name_ST2_2T;
    private javax.swing.JLabel PHONG_CT2_2T;
    private javax.swing.JLabel PHONG_CT2_3T;
    private javax.swing.JLabel PHONG_CT3_2T;
    private javax.swing.JLabel PHONG_CT3_3T;
    private javax.swing.JLabel PHONG_CT4_2T;
    private javax.swing.JLabel PHONG_CT4_3T;
    private javax.swing.JLabel PHONG_CT5_2T;
    private javax.swing.JLabel PHONG_CT5_3T;
    private javax.swing.JLabel PHONG_CT6_2T;
    private javax.swing.JLabel PHONG_CT6_3T;
    private javax.swing.JLabel PHONG_CT7_2T;
    private javax.swing.JLabel PHONG_CT7_3T;
    private javax.swing.JLabel PHONG_ST2_2T;
    private javax.swing.JLabel PHONG_ST2_3T;
    private javax.swing.JLabel PHONG_ST3_2T;
    private javax.swing.JLabel PHONG_ST3_3T;
    private javax.swing.JLabel PHONG_ST4_2T;
    private javax.swing.JLabel PHONG_ST4_3T;
    private javax.swing.JLabel PHONG_ST5_2T;
    private javax.swing.JLabel PHONG_ST5_3T;
    private javax.swing.JLabel PHONG_ST6_2T;
    private javax.swing.JLabel PHONG_ST6_3T;
    private javax.swing.JLabel PHONG_ST7_2T;
    private javax.swing.JLabel PHONG_ST7_3T;
    private javax.swing.JPanel Thu2BaTiet;
    private javax.swing.JPanel Thu2BaTietChieu;
    private javax.swing.JPanel Thu2HaiTiet;
    private javax.swing.JPanel Thu2HaiTietChieu;
    private javax.swing.JPanel Thu3BaTiet;
    private javax.swing.JPanel Thu3BaTietChieu;
    private javax.swing.JPanel Thu3HaiTiet;
    private javax.swing.JPanel Thu3HaiTietChieu;
    private javax.swing.JPanel Thu4BaTiet;
    private javax.swing.JPanel Thu4BaTietChieu;
    private javax.swing.JPanel Thu4HaiTiet;
    private javax.swing.JPanel Thu4HaiTietChieu;
    private javax.swing.JPanel Thu5BaTiet;
    private javax.swing.JPanel Thu5BaTietChieu;
    private javax.swing.JPanel Thu5HaiTiet;
    private javax.swing.JPanel Thu5HaiTietChieu;
    private javax.swing.JPanel Thu6BaTiet;
    private javax.swing.JPanel Thu6BaTietChieu;
    private javax.swing.JPanel Thu6HaiTiet;
    private javax.swing.JPanel Thu6HaiTietChieu;
    private javax.swing.JPanel Thu7BaTiet;
    private javax.swing.JPanel Thu7BaTietChieu;
    private javax.swing.JPanel Thu7HaiTiet;
    private javax.swing.JPanel Thu7HaiTietChieu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel8;
    // End of variables declaration                   

    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource().equals(BackButton))
        {
           
             BackButtonActionPerformed(e);
        }
    }

}