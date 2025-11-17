package view;

import controller.SinhVienDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import model.SinhVien;



public class GD_SuaSinhVien extends javax.swing.JFrame implements ActionListener{
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GD_SuaSinhVien.class.getName());

    private SinhVienDAO sinhVienDAO;
    private SinhVien s;
    
    public GD_SuaSinhVien() {
        initComponents();
        
        sinhVienDAO = new SinhVienDAO();
        gioitinh = new ButtonGroup();
        trangthai = new ButtonGroup();
        BackButton.addActionListener(this);
        UpdateButton.addActionListener(this);
        TimKiemButton.addActionListener(this);
        XoaSinhVienButton.addActionListener(this);
        CapNhapDiemButton.addActionListener(this);
        gioitinh.add(MaleCheckBox);
        gioitinh.add(FemaleCheckBox);
        trangthai.add(StudyingCheckBox);
        trangthai.add(GraduatedCheckBox);
    }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        BackButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        IdTextField = new javax.swing.JTextField();
        TimKiemButton = new javax.swing.JButton();
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
        UpdateButton = new javax.swing.JButton();
        SchoolYearTextField = new javax.swing.JTextField();
        EmailTextField = new javax.swing.JTextField();
        PhoneTextField = new javax.swing.JTextField();
        AddressTextField = new javax.swing.JTextField();
        ClassTextField = new javax.swing.JTextField();
        NameTextField = new javax.swing.JTextField();
        MajorComboBox = new javax.swing.JComboBox(); 
        MaleCheckBox = new javax.swing.JCheckBox();
        FemaleCheckBox = new javax.swing.JCheckBox();
        StudyingCheckBox = new javax.swing.JCheckBox();
        GraduatedCheckBox = new javax.swing.JCheckBox();
        XoaSinhVienButton = new javax.swing.JButton();
        CapNhapDiemButton = new javax.swing.JButton();
        ngaySpinner  = new javax.swing.JSpinner();
        thangSpinner = new javax.swing.JSpinner();
        namSpinner = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); 
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Update Student Information");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 6, -1, 48));

        BackButton.setText("Back");
        getContentPane().add(BackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jLabel2.setText("MSV:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 79, -1, -1));
        getContentPane().add(IdTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 76, 114, -1));

        TimKiemButton.setText("Search");
        getContentPane().add(TimKiemButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 110, -1, -1));

        jLabel3.setText("Name:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 79, -1, -1));

        jLabel4.setText("Sex:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 112, -1, -1));

        jLabel5.setText("DOB:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 148, -1, -1));

        jLabel6.setText("Class:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 182, -1, -1));

        jLabel7.setText("Address:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 216, -1, -1));

        jLabel8.setText("Phone:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 250, -1, -1));

        jLabel9.setText("Email:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 284, -1, -1));

        jLabel10.setText("Status:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 317, -1, -1));

        jLabel11.setText("Major:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 350, -1, -1));

        jLabel12.setText("School Year:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 384, -1, -1));

            UpdateButton.setText("Update Infor");
            getContentPane().add(UpdateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 421, -1, -1));
            getContentPane().add(SchoolYearTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 381, 235, -1));
            getContentPane().add(EmailTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 281, 235, -1));
            getContentPane().add(PhoneTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 247, 235, -1));
            getContentPane().add(AddressTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 213, 235, -1));
            getContentPane().add(ClassTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 179, 235, -1));

            getContentPane().add(NameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 76, 235, -1));
            ngaySpinner.setModel(new javax.swing.SpinnerNumberModel(1,1,31,1));
            getContentPane().add(ngaySpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(291,145,50,-1));
            thangSpinner.setModel(new javax.swing.SpinnerNumberModel(1,1,12,1));
            getContentPane().add(thangSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(346,145,50,-1));
            namSpinner.setModel(new javax.swing.SpinnerNumberModel(1900,1900,2200,1));
            getContentPane().add(namSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(400,145,80,-1));
        
        MajorComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "IT", "QT", "MK", "BC", "KHMT" }));
        getContentPane().add(MajorComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 347, -1, -1));

        MaleCheckBox.setText("Male");
        getContentPane().add(MaleCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 110, -1, -1));

        FemaleCheckBox.setText("Female");
        getContentPane().add(FemaleCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 110, -1, -1));

        StudyingCheckBox.setText("Studying");
        getContentPane().add(StudyingCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(291, 315, -1, -1));

        GraduatedCheckBox.setText("Graduated");
        getContentPane().add(GraduatedCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(367, 315, -1, -1));

        XoaSinhVienButton.setText("Delete Student");
        getContentPane().add(XoaSinhVienButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 421, -1, -1));

        CapNhapDiemButton.setText("Update Grade");
        getContentPane().add(CapNhapDiemButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(431, 421, -1, -1));

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
                new GD_SuaSinhVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JTextField AddressTextField;
    private javax.swing.JButton BackButton;
    private javax.swing.JButton CapNhapDiemButton;
    private javax.swing.JTextField ClassTextField;
    //private javax.swing.JTextField DobTextField;
    private javax.swing.JTextField EmailTextField;
    private javax.swing.JCheckBox FemaleCheckBox;
    private javax.swing.JCheckBox GraduatedCheckBox;
    private javax.swing.JTextField IdTextField;
    private javax.swing.JComboBox MajorComboBox; 
    private javax.swing.JCheckBox MaleCheckBox;
    private javax.swing.JTextField NameTextField;
    private javax.swing.JTextField PhoneTextField;
    private javax.swing.JTextField SchoolYearTextField;
    private javax.swing.JCheckBox StudyingCheckBox;
    private javax.swing.JButton TimKiemButton;
    private javax.swing.JButton UpdateButton;
    private javax.swing.JButton XoaSinhVienButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;            
    private ButtonGroup gioitinh;
    private ButtonGroup trangthai;
     private javax.swing.JSpinner ngaySpinner;
    private javax.swing.JSpinner thangSpinner;
    private javax.swing.JSpinner namSpinner;
    
    
  
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource().equals(TimKiemButton)) btnTimKiemClick();
        else if(e.getSource().equals(UpdateButton)) btnCapNhapClick();
        else if(e.getSource().equals(XoaSinhVienButton)) btnXoaSinhVienClick();
        else if(e.getSource().equals(CapNhapDiemButton)) btnCapNhapDiemClick();
        else
        {
            GD_Menu_Admin winAdmin = new GD_Menu_Admin();
            winAdmin.setLocationRelativeTo(null);
            winAdmin.setVisible(true);
            this.dispose();
        }
    }
    public void btnTimKiemClick()
    {
        s = sinhVienDAO.getSinhVien(IdTextField.getText());
        IdTextField.setText(s.getId());
        NameTextField.setText(s.getName());
        boolean check = s.getStatus().equals("Studying");
        StudyingCheckBox.setSelected(check);
        GraduatedCheckBox.setSelected(!check);
        String sv1 = new SimpleDateFormat("dd/MM/yyyy").format(s.getDob());
        String[] ss = sv1.split("/");
        ngaySpinner.setValue(Integer.valueOf(ss[0]));
        thangSpinner.setValue(Integer.valueOf(ss[1]));
        namSpinner.setValue(Integer.valueOf(ss[2]));
        ClassTextField.setText(s.getMainClass());
        AddressTextField.setText(s.getAddress());
        PhoneTextField.setText(s.getPhone());
        EmailTextField.setText(s.getEmail());
        check = s.getSex().equals("Male");
        MaleCheckBox.setSelected(check);
        FemaleCheckBox.setSelected(!check);
        if(s.getMajor().equals("IT")) MajorComboBox.setSelectedIndex(0);
        else if(s.getMajor().equals("QT")) MajorComboBox.setSelectedIndex(1);
        else if(s.getMajor().equals("MK")) MajorComboBox.setSelectedIndex(2);
        else if(s.getMajor().equals("BC")) MajorComboBox.setSelectedIndex(3);
        else if(s.getMajor().equals("KHMT")) MajorComboBox.setSelectedIndex(4);
        SchoolYearTextField.setText(String.valueOf(s.getSchoolYear()));
    }
    public void btnCapNhapClick()
    {
        SinhVien sv = new SinhVien();
        String khoa = s.getMajor();
        sv.setId(IdTextField.getText());
        sv.setName(NameTextField.getText());
        if(MaleCheckBox.isSelected()) sv.setSex("Male");
        else sv.setSex("Female");
        try {
            sv.setDob(new SimpleDateFormat("dd/MM/yyyy").parse(ngaySpinner.getValue().toString() + "/" + thangSpinner.getValue().toString() + "/" + namSpinner.getValue().toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        sv.setMainClass(ClassTextField.getText());
        sv.setAddress(AddressTextField.getText());
        sv.setPhone(PhoneTextField.getText());
        sv.setEmail(EmailTextField.getText());
        if(StudyingCheckBox.isSelected()) sv.setStatus("Studying");
        else sv.setStatus("Graduated");
        sv.setMajor((String)MajorComboBox.getSelectedItem());
        try {
            sv.setSchoolYear(Integer.parseInt(SchoolYearTextField.getText()));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if(khoa.equals(sv.getMajor()))
        {
            if(sinhVienDAO.CapNhap(sv))
            {
                JOptionPane.showMessageDialog(rootPane, "Update successful!");
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "Error!");
            }
        }
        else{
             if(sinhVienDAO.CapNhap(sv))
            {
                JOptionPane.showMessageDialog(rootPane, "Update successful!");
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "Error!");
            }
        }
        
    }
    public void btnCapNhapDiemClick()
    {
        GD_CapNhapDiem winCapNhapDiem = new GD_CapNhapDiem(s);
        winCapNhapDiem.setLocationRelativeTo(null);
        winCapNhapDiem.setVisible(true);
    }
    public void btnXoaSinhVienClick()
    {
        int choice = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to delete this student?", "Notice", JOptionPane.YES_NO_OPTION);
        if(choice == JOptionPane.YES_OPTION)
        {
            if(new SinhVienDAO().XoaSinhVien(IdTextField.getText()))
            {
                JOptionPane.showMessageDialog(rootPane, "Deleted successfully!");
                IdTextField.setText("");
                NameTextField.setText("");
                MaleCheckBox.setSelected(false);
                FemaleCheckBox.setSelected(false);
                ngaySpinner.setValue(Integer.valueOf("1"));
                thangSpinner.setValue(Integer.valueOf("1"));
                namSpinner.setValue(Integer.valueOf("1900"));
                ClassTextField.setText("");
                AddressTextField.setText("");
                PhoneTextField.setText("");
                EmailTextField.setText("");
                StudyingCheckBox.setSelected(false);
                GraduatedCheckBox.setSelected(false);
                SchoolYearTextField.setText("");
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "No student information!");
            }
        }
        
    }
}