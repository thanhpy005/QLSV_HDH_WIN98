package view;

import controller.SinhVienDAO;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import model.SinhVien;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;


public class GD_ThemSinhVien extends javax.swing.JFrame implements ActionListener{
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GD_ThemSinhVien.class.getName());

    private SinhVienDAO sinhVienDAO;
    
    public GD_ThemSinhVien() {
        initComponents();
       
        TrangThai = new ButtonGroup();
        GioiTinh = new ButtonGroup();
        sinhVienDAO = new SinhVienDAO();
        
        Add.addActionListener(this);
        ResetButton.addActionListener(this);
        BackButton.addActionListener(this);
        MajorComboBox.addItem("IT");
        MajorComboBox.addItem("BC");
        MajorComboBox.addItem("QT");
        MajorComboBox.addItem("KHMT");
        MajorComboBox.addItem("MK");
        TrangThai.add(StudyingCheckBox);
        TrangThai.add(GraduatedCheckBox);
        GioiTinh.add(MaleCheckBox);
        GioiTinh.add(FemaleCheckBox);


    }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Add = new javax.swing.JButton();
        ResetButton = new javax.swing.JButton();
        PhoneTextField = new javax.swing.JTextField();
        AddressTextField = new javax.swing.JTextField();
        MaleCheckBox = new javax.swing.JCheckBox();
        FemaleCheckBox = new javax.swing.JCheckBox();
        NameTextField = new javax.swing.JTextField();
        StudyingCheckBox = new javax.swing.JCheckBox();
        GraduatedCheckBox = new javax.swing.JCheckBox();
        BackButton = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        MajorComboBox = new javax.swing.JComboBox(); 
        DaySpinner = new javax.swing.JSpinner();
        MonthSpinner = new javax.swing.JSpinner();
        YearSpinner = new javax.swing.JSpinner();
        LopSpinner = new javax.swing.JSpinner();
        KhoaSpinner = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student Management [ADMIN]");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout()); 

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add Student Information");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 312, 67));

        jLabel2.setText("School year:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 88, -1, -1));

        jLabel3.setText("Name:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 122, -1, -1));

        jLabel4.setText("Sex:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 155, -1, -1));

        jLabel5.setText("Date of birth:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 188, -1, -1));

        jLabel6.setText("Class:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 256, -1, -1));

        jLabel7.setText("Address:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 222, -1, -1));

        jLabel8.setText("Phone Number:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 290, -1, -1));

        jLabel10.setText("Status:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(42, 323, -1, -1));

        Add.setText("Add");
       
        getContentPane().add(Add, new org.netbeans.lib.awtextra.AbsoluteConstraints(54, 400, -1, -1));

        ResetButton.setText("Reset");
        getContentPane().add(ResetButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 400, -1, -1));
        getContentPane().add(PhoneTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 287, 221, -1));
        getContentPane().add(AddressTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 219, 221, -1));

        MaleCheckBox.setText("Male");
        getContentPane().add(MaleCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 153, -1, -1));

        FemaleCheckBox.setText("Female");
        getContentPane().add(FemaleCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(205, 153, -1, -1));
        getContentPane().add(NameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 119, 221, -1));

        StudyingCheckBox.setText("Studying");
        
        getContentPane().add(StudyingCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 321, -1, -1));

        GraduatedCheckBox.setText("Graduated");
        getContentPane().add(GraduatedCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 321, -1, -1));

        BackButton.setText("Back");
        getContentPane().add(BackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        jLabel12.setText("Major:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 356, -1, -1));

        getContentPane().add(MajorComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 353, -1, -1));

        DaySpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));
        getContentPane().add(DaySpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 185, 49, -1));

        MonthSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));
        getContentPane().add(MonthSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(193, 185, 46, -1));

        YearSpinner.setModel(new javax.swing.SpinnerNumberModel(2000, 1900, 2500, 1));
        getContentPane().add(YearSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 185, -1, -1));

        LopSpinner.setModel(new javax.swing.SpinnerNumberModel(1, 1, 10, 1));
        getContentPane().add(LopSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 253, -1, -1));

        KhoaSpinner.setModel(new javax.swing.SpinnerNumberModel(new Integer(21), null, null, new Integer(1)));
        getContentPane().add(KhoaSpinner, new org.netbeans.lib.awtextra.AbsoluteConstraints(138, 85, -1, -1));

        setSize(400,480);
    }// </editor-fold>                        

    
    public String getEmail(String s, String q)
    {
        String[] arr = s.split("\\s+");
       
        for(int j = 0; j < arr.length; j++) 
        {
            String i = arr[j];
            i.toUpperCase();
        }
        String res = String.valueOf(arr[arr.length-1].charAt(0));
        for(int i = 0;i<arr.length-1;i++)
        {
            res += arr[i].charAt(0);
        }
        res += "." + q + "@ptit.edu.vn";
        return res;
    }
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
                new GD_ThemSinhVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton Add;
    private javax.swing.JTextField AddressTextField;
    private javax.swing.JButton BackButton;
    private javax.swing.JSpinner DaySpinner;
    private javax.swing.JCheckBox FemaleCheckBox;
    private javax.swing.JCheckBox GraduatedCheckBox;
    private javax.swing.JSpinner KhoaSpinner;
    private javax.swing.JSpinner LopSpinner;
    private javax.swing.JComboBox MajorComboBox; 
    private javax.swing.JCheckBox MaleCheckBox;
    private javax.swing.JSpinner MonthSpinner;
    private javax.swing.JTextField NameTextField;
    private javax.swing.JTextField PhoneTextField;
    private javax.swing.JButton ResetButton;
    private javax.swing.JCheckBox StudyingCheckBox;
    private javax.swing.JSpinner YearSpinner;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;                
    private ButtonGroup TrangThai;
    private ButtonGroup GioiTinh;
   
   
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource().equals(Add)) btnAddClick();
        else if(e.getSource().equals(ResetButton)) btnResetClick();
        else
        {
            
            GD_Menu_Admin winAdmin = new GD_Menu_Admin();
            winAdmin.setLocationRelativeTo(null);
            winAdmin.setVisible(true);
            this.dispose();
        }
    }
    public void btnAddClick()
    {
        SinhVien s = new SinhVien();
      
        ArrayList list  = new SinhVienDAO().getListSinhVien2Major((String)MajorComboBox.getSelectedItem());
        
        
        ArrayList tmp = new ArrayList();
        
        
        for(int k = 0; k < list.size(); k++)
        {
            Object obj = list.get(k);
            SinhVien i = (SinhVien) obj;
            String khoaString = KhoaSpinner.getValue().toString();
            String msvString = i.getId().substring(1,3);
            String t2 = i.getId().substring(5);
            int t3 = Integer.parseInt(t2);
            if(khoaString.equals(msvString))
            {
                tmp.add(new Integer(t3));
            }
        }
        int stt = tmp.size()+1;
        Collections.sort(tmp);
        if(tmp.size() == 0) stt = 1;
        else{
            for(int i = 0;i<tmp.size();i++)
            {
                
                if(i + 1 != ((Integer) tmp.get(i)).intValue()){
                    stt = i+1;
                    break;
                }
            }
        }
       
        s.setId("B" + KhoaSpinner.getValue().toString() + (String)MajorComboBox.getSelectedItem() + new java.text.DecimalFormat("000").format(stt));
        s.setName(NameTextField.getText());
        if(MaleCheckBox.isSelected()) s.setSex("Male");
        else if(FemaleCheckBox.isSelected()) s.setSex("Female");
        try {
            s.setDob(new SimpleDateFormat("dd/MM/yyyy").parse(DaySpinner.getValue().toString() + "/" + MonthSpinner.getValue().toString() + "/" + YearSpinner.getValue().toString()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        s.setAddress(AddressTextField.getText());
        s.setMainClass("D" + KhoaSpinner.getValue().toString() + (String)MajorComboBox.getSelectedItem() + new java.text.DecimalFormat("00").format(((Number)LopSpinner.getValue()).longValue()));
        s.setPhone(PhoneTextField.getText());
        s.setEmail(getEmail(NameTextField.getText(), s.getId()));
        if(StudyingCheckBox.isSelected()) s.setStatus("Studying");
        if(GraduatedCheckBox.isSelected()) s.setStatus("Graduated");
        
        s.setMajor((String)MajorComboBox.getSelectedItem());
        try {
            s.setSchoolYear(Integer.parseInt("1"));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        if(sinhVienDAO.addSinhVien(s))
        {
            JOptionPane.showMessageDialog(rootPane, "Added student information!");
        }
        else 
        {
            JOptionPane.showMessageDialog(rootPane, "Error!");
        }
    }
    public void btnResetClick()
    {
        
        NameTextField.setText("");
        MaleCheckBox.setSelected(false);
        FemaleCheckBox.setSelected(false);
        AddressTextField.setText("");
       
        PhoneTextField.setText("");
        
        StudyingCheckBox.setSelected(false);
        GraduatedCheckBox.setSelected(false);
       

    }
}