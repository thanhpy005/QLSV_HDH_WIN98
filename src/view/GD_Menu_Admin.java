package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.util.Properties;
import model.TaiKhoan;



public class GD_Menu_Admin extends javax.swing.JFrame implements ActionListener{
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GD_Menu_Admin.class.getName());

    
    
    public GD_Menu_Admin() {
        initComponents();

        setSize(850, 400);
        Properties prop = new Properties();
        try {
            InputStream input = getClass().getResourceAsStream("/config.properties");
            if(input != null) {
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

    
        getContentPane().setBackground(new Color(r, g, b));
        AddSvButton.addActionListener(this);
        
        UpdateSvButton.addActionListener(this);
        ShowSvButton.addActionListener(this);
        AddAccButton.addActionListener(this);
        BackButton.addActionListener(this);
        
    }

   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        AddSvButton = new javax.swing.JButton();
        UpdateSvButton = new javax.swing.JButton();
        ShowSvButton = new javax.swing.JButton();
        AddAccButton = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student Management [ADMIN]");
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout()); 

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); 
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MENU");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 6, 633, 65));

        AddSvButton.setText("New Student");
        getContentPane().add(AddSvButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 126, 242, 46));

        UpdateSvButton.setText("Update Student Information");
        getContentPane().add(UpdateSvButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(96, 263, 242, 46));

        ShowSvButton.setText("Student List");
        
        getContentPane().add(ShowSvButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(487, 126, 242, 46));

        AddAccButton.setText("Add Account");
        AddAccButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
            }
        });
        getContentPane().add(AddAccButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(487, 262, 242, 47));

        BackButton.setText("Log out");
        getContentPane().add(BackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        pack();
    }// </editor-fold>                        

    
    public static void main(String args[]) {
       
        try {
    
    javax.swing.UIManager.LookAndFeelInfo[] lafInfos = javax.swing.UIManager.getInstalledLookAndFeels();
    
    
    for (int i = 0; i < lafInfos.length; i++) {
        
        javax.swing.UIManager.LookAndFeelInfo info = lafInfos[i];
        
        
        if ("Nimbus".equals(info.getName())) {
            javax.swing.UIManager.setLookAndFeel(info.getClassName());
            break;
        }
    }
   
} catch (ClassNotFoundException ex) {
    logger.log(java.util.logging.Level.SEVERE, null, ex);
} catch (InstantiationException ex) {
    logger.log(java.util.logging.Level.SEVERE, null, ex);
} catch (IllegalAccessException ex) {
    logger.log(java.util.logging.Level.SEVERE, null, ex);
} catch (javax.swing.UnsupportedLookAndFeelException ex) {
    logger.log(java.util.logging.Level.SEVERE, null, ex);
}
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new GD_Menu_Admin().setVisible(true); 
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton AddAccButton;
    private javax.swing.JButton AddSvButton;
    private javax.swing.JButton BackButton;
    private javax.swing.JButton ShowSvButton;
    private javax.swing.JButton UpdateSvButton;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration                   
    
   
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource().equals(AddSvButton)) btnThemSinhVien();
        
        else if(e.getSource().equals(UpdateSvButton)) btnCapNhapSinhVien();
        else if(e.getSource().equals(ShowSvButton)) btnTatCaSinhVien();
        else if(e.getSource().equals(AddAccButton)) btnThemTaiKhoan();
        else if(e.getSource().equals(BackButton))
        {
            GD_DangNhap winD_DangNhap = new GD_DangNhap();
            winD_DangNhap.setLocationRelativeTo(null);
            winD_DangNhap.setVisible(true);
            this.dispose();
        }
       
    }
    public void btnThemSinhVien()
    {
        GD_ThemSinhVien winThemSinhVien = new GD_ThemSinhVien();
        winThemSinhVien.setLocationRelativeTo(null);
        winThemSinhVien.setVisible(true);
        this.dispose();
    }
    
    public void btnCapNhapSinhVien()
    {
        GD_SuaSinhVien winD_SuaSinhVien = new GD_SuaSinhVien();
        winD_SuaSinhVien.setLocationRelativeTo(null);
        winD_SuaSinhVien.setVisible(true);
        this.dispose();
    }
    public void btnTatCaSinhVien()
    {
        new GD_ShowSinhVien().setVisible(true);
        this.dispose();
    }
    public void btnThemTaiKhoan()
    {
        GD_ThemTaiKhoan winD_ThemTaiKhoan = new GD_ThemTaiKhoan();
        winD_ThemTaiKhoan.setLocationRelativeTo(null);
        winD_ThemTaiKhoan.setVisible(true);
        this.dispose();
    }
    
}