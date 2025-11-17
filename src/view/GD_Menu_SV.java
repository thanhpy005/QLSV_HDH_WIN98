package view;

import controller.SinhVienDAO;
import controller.TienTrinhDAO;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.SinhVien;
import java.io.File;
import java.text.SimpleDateFormat; 
import java.text.DecimalFormat;  
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import java.awt.Image;
import java.io.InputStream;
import java.util.Properties;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;



public class GD_Menu_SV extends javax.swing.JFrame implements ActionListener{
    public SinhVien sinhVien;
    private File selectFile;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GD_Menu_SV.class.getName());

    private SinhVienDAO sinhVienDAO;
    private TienTrinhDAO tienTrinhDAO;
    
    public GD_Menu_SV(SinhVien s) {
        initComponents();
        pack();
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
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        sinhVienDAO = new SinhVienDAO();
        tienTrinhDAO = new TienTrinhDAO();
        
        sinhVien = s;
        DangKiMonButton.addActionListener(this);
        BackButton.addActionListener(this);
        DoiMkButton.addActionListener(this);
        XemTkbButton.addActionListener(this);
        XemTienTrinhHocButton.addActionListener(this);
        DanhSachLopButton.addActionListener(this);
        ThemAnhButton.addActionListener(this);
        TenLabel.setText(s.getName());
        MsvLabel.setText(s.getId());
        ClassLabel.setText(s.getMainClass());
        ChuyenNganhLabel.setText(s.getMajor());
        GioiTinhLabel.setText(s.getSex());
        
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        NgaySinhLabel.setText(sdf.format(s.getDob()));
        
        DiaChiLabel.setText(s.getAddress());
        NamHocLabel.setText(String.valueOf(s.getSchoolYear()));
        SoDienThoaiLabel.setText(s.getPhone());
        TrangThaiLabel.setText(s.getStatus());
        EmailLabel.setText(s.getEmail());
        
        
        DecimalFormat df = new DecimalFormat("#.#");
        CpaLabel.setText(df.format(tienTrinhDAO.getCpa(s)));
        
        ImageIcon avatar = sinhVienDAO.getAvatar(MsvLabel.getText());
        if (avatar != null) {
            AvatarLabel.setIcon(avatar);
            AvatarLabel.setText("");
        } else {
            AvatarLabel.setIcon(null);
            AvatarLabel.setText("Blank avatar");
        }

    }
    
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel17 = new javax.swing.JLabel();
        XemTkbButton = new javax.swing.JButton();
        TenLabel = new javax.swing.JLabel();
        MsvLabel = new javax.swing.JLabel();
        AvatarLabel = new javax.swing.JLabel();
        BackButton = new javax.swing.JButton();
        DoiMkButton = new javax.swing.JButton();
        LopLabel = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        ChuyenNganhLabel = new javax.swing.JLabel();
        GioiTinhLabel = new javax.swing.JLabel();
        NgaySinhLabel = new javax.swing.JLabel();
        DiaChiLabel = new javax.swing.JLabel();
        NamHocLabel = new javax.swing.JLabel();
        SoDienThoaiLabel = new javax.swing.JLabel();
        TrangThaiLabel = new javax.swing.JLabel();
        EmailLabel = new javax.swing.JLabel();
        CpaLabel = new javax.swing.JLabel();
        ClassLabel = new javax.swing.JLabel();
        XemTienTrinhHocButton = new javax.swing.JButton();
        DanhSachLopButton = new javax.swing.JButton();
        ThemAnhButton = new javax.swing.JButton();
        DangKiMonButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jLabel17.setText("jLabel17");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student Management [USER]");
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout()); 

        XemTkbButton.setText("Timetable");
        
        getContentPane().add(XemTkbButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(544, 364, 106, -1));

        TenLabel.setBackground(new java.awt.Color(255, 255, 255));
        TenLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
        TenLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        TenLabel.setOpaque(true);
        getContentPane().add(TenLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 233, 127, 22));

        MsvLabel.setBackground(new java.awt.Color(255, 255, 255));
        MsvLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
        MsvLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        MsvLabel.setOpaque(true);
        getContentPane().add(MsvLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 267, 127, 20));

        AvatarLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        AvatarLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(AvatarLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 81, 127, 140));

        BackButton.setText("Log out");
        getContentPane().add(BackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        DoiMkButton.setText("Change Password");
        getContentPane().add(DoiMkButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 364, 106, -1));

        LopLabel.setBackground(new java.awt.Color(255, 255, 255));
        LopLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
        LopLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LopLabel.setOpaque(true);
        getContentPane().add(LopLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 327, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jLabel3.setText("Major:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 87, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); 
        jLabel4.setText("Gender:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 115, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); 
        jLabel5.setText("DOB:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 143, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12));
        jLabel6.setText("Address:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 171, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); 
        jLabel7.setText("Term:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 199, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Phone number:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 233, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Status:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 261, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Email:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 289, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("CPA:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(235, 317, -1, -1));

        ChuyenNganhLabel.setBackground(new java.awt.Color(255, 255, 255));
        ChuyenNganhLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ChuyenNganhLabel.setOpaque(true);
        getContentPane().add(ChuyenNganhLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 87, 237, -1));

        GioiTinhLabel.setBackground(new java.awt.Color(255, 255, 255));
        GioiTinhLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        GioiTinhLabel.setOpaque(true);
        getContentPane().add(GioiTinhLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 115, 237, -1));

        NgaySinhLabel.setBackground(new java.awt.Color(255, 255, 255));
        NgaySinhLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NgaySinhLabel.setOpaque(true);
        getContentPane().add(NgaySinhLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 143, 237, -1));

        DiaChiLabel.setBackground(new java.awt.Color(255, 255, 255));
        DiaChiLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DiaChiLabel.setOpaque(true);
        getContentPane().add(DiaChiLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 171, 237, -1));

        NamHocLabel.setBackground(new java.awt.Color(255, 255, 255));
        NamHocLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        NamHocLabel.setOpaque(true);
        getContentPane().add(NamHocLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 199, 237, -1));

        SoDienThoaiLabel.setBackground(new java.awt.Color(255, 255, 255));
        SoDienThoaiLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SoDienThoaiLabel.setOpaque(true);
        getContentPane().add(SoDienThoaiLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 233, 237, -1));

        TrangThaiLabel.setBackground(new java.awt.Color(255, 255, 255));
        TrangThaiLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        TrangThaiLabel.setOpaque(true);
        getContentPane().add(TrangThaiLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 261, 237, -1));

        EmailLabel.setBackground(new java.awt.Color(255, 255, 255));
        EmailLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        EmailLabel.setOpaque(true);
        getContentPane().add(EmailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 289, 237, -1));

        CpaLabel.setBackground(new java.awt.Color(255, 255, 255));
        CpaLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        CpaLabel.setOpaque(true);
        getContentPane().add(CpaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 317, 237, -1));

        ClassLabel.setBackground(new java.awt.Color(255, 255, 255));
        ClassLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ClassLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        ClassLabel.setOpaque(true);
        getContentPane().add(ClassLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 299, 127, 22));

        XemTienTrinhHocButton.setText("Learning Process");
        getContentPane().add(XemTienTrinhHocButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(274, 364, -1, -1));

        DanhSachLopButton.setText("Class");
        getContentPane().add(DanhSachLopButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 364, 100, -1));

        ThemAnhButton.setText("Add Image");
        getContentPane().add(ThemAnhButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 52, -1, -1));

        DangKiMonButton.setText("Course Registration");
        getContentPane().add(DangKiMonButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 364, 130, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); 
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Student Information");
        jLabel1.setToolTipText("");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 6, 320, 40));

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
      
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel AvatarLabel;
    private javax.swing.JButton BackButton;
    private javax.swing.JLabel ChuyenNganhLabel;
    private javax.swing.JLabel ClassLabel;
    private javax.swing.JLabel CpaLabel;
    private javax.swing.JButton DangKiMonButton;
    private javax.swing.JButton DanhSachLopButton;
    private javax.swing.JLabel DiaChiLabel;
    private javax.swing.JButton DoiMkButton;
    private javax.swing.JLabel EmailLabel;
    private javax.swing.JLabel GioiTinhLabel;
    private javax.swing.JLabel LopLabel;
    private javax.swing.JLabel MsvLabel;
    private javax.swing.JLabel NamHocLabel;
    private javax.swing.JLabel NgaySinhLabel;
    private javax.swing.JLabel SoDienThoaiLabel;
    private javax.swing.JLabel TenLabel;
    private javax.swing.JButton ThemAnhButton;
    private javax.swing.JLabel TrangThaiLabel;
    private javax.swing.JButton XemTienTrinhHocButton;
    private javax.swing.JButton XemTkbButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration                   
    
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource().equals(DoiMkButton)) btnDoiMkClick();
        else if(e.getSource().equals(XemTkbButton)) btnXemTkbClick();
        else if(e.getSource().equals(XemTienTrinhHocButton)) btnXemTthClick();
        else if(e.getSource().equals(DanhSachLopButton)) btnDanhSachLopClick();
        else if(e.getSource().equals(ThemAnhButton)) chonAnh();
        else if(e.getSource().equals(DangKiMonButton)) btnDangKiMonClick();
        else{
            GD_DangNhap winD_DangNhap= new GD_DangNhap();
            winD_DangNhap.setLocationRelativeTo(null);
            winD_DangNhap.setVisible(true);
            this.dispose();
        }
    }
    public void btnDoiMkClick()
    {
        GD_DoiMk winD_DoiMk = new GD_DoiMk(sinhVien);
        winD_DoiMk.setLocationRelativeTo(null);
        winD_DoiMk.setVisible(true);
        this.dispose();
    }
    public void btnXemTkbClick()
    {
        GD_TkbTuan winD_TkbTuan = new GD_TkbTuan(sinhVien);
        winD_TkbTuan.setLocationRelativeTo(null);
        winD_TkbTuan.setVisible(true);
        this.dispose();
    }
    public void btnXemTthClick()
    {
        GD_XemTienTrinh winD_XemTienTrinh = new GD_XemTienTrinh(sinhVien);
        winD_XemTienTrinh.setLocationRelativeTo(null);
        winD_XemTienTrinh.setVisible(true);
        this.dispose();
    }
    public void btnDanhSachLopClick()
    {
        GD_SVCungLop winCungLop = new GD_SVCungLop(sinhVien);
        winCungLop.setLocationRelativeTo(null);
        winCungLop.setVisible(true);
        this.dispose();
    }
    public void btnDangKiMonClick()
    {
        GD_DangKiMon winD_DangKiMon = new GD_DangKiMon(sinhVien);
        winD_DangKiMon.setLocationRelativeTo(null);
        winD_DangKiMon.setVisible(true);
        this.dispose();
    }
    public void chonAnh()
    {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Null");
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int result =  chooser.showOpenDialog(this);
        if(result == JFileChooser.APPROVE_OPTION)
        {
            selectFile = chooser.getSelectedFile();
            try {
                Image img = ImageIO.read(selectFile);
                AvatarLabel.setIcon(new ImageIcon(img.getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
                AvatarLabel.setText("");
                sinhVienDAO.updateAvatar(MsvLabel.getText(),selectFile);
                JOptionPane.showMessageDialog(rootPane, "Update successful!");
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(rootPane, "Error!");
                e.printStackTrace();
            }
            
        }
    }
}