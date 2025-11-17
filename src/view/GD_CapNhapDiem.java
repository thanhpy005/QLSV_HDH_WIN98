package view;

import controller.SinhVienDAO;
import controller.TienTrinhDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.SinhVien;
import model.TienTrinh;


public class GD_CapNhapDiem extends javax.swing.JFrame implements ActionListener{
    DefaultTableModel model;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GD_CapNhapDiem.class.getName());

    private SinhVienDAO sinhVienDAO;
    private TienTrinhDAO tienTrinhDAO;
    private SinhVien sinhVien;
    
    public GD_CapNhapDiem(SinhVien sinhVien) {
        initComponents();
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        sinhVienDAO = new SinhVienDAO();
        tienTrinhDAO = new TienTrinhDAO();
        this.sinhVien = sinhVien;
        TimSinhVienButton.addActionListener(this);
        CapNhapButton.addActionListener(this);
        BackButton.addActionListener(this);
        
        IdTextField.setText(sinhVien.getId());
        KiHocTextField.setText(String.valueOf(sinhVien.getSchoolYear()));
    }

                
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        IdTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        SuaDiemTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        KiHocTextField = new javax.swing.JTextField();
        TimSinhVienButton = new javax.swing.JButton();
        CapNhapButton = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student Management [ADMIN]");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout()); 

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Update Grade");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 558, 49));

        jLabel2.setText("ID:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 58, -1, -1));
        getContentPane().add(IdTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 55, 218, -1));

        SuaDiemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(SuaDiemTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 155, 558, 171));

        jLabel3.setText("Term");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(143, 86, -1, -1));
        getContentPane().add(KiHocTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(197, 83, 45, -1));

        TimSinhVienButton.setText("Search");
        getContentPane().add(TimSinhVienButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(249, 117, -1, -1));

        CapNhapButton.setText("Update");
        getContentPane().add(CapNhapButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(245, 344, -1, -1));

        BackButton.setText("Back");
        getContentPane().add(BackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 428, -1, -1));

        pack();
    }// </editor-fold>                        

    /**
     * @param args the command line arguments
     */
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
    private javax.swing.JButton BackButton;
    private javax.swing.JButton CapNhapButton;
    private javax.swing.JTextField IdTextField;
    private javax.swing.JTextField KiHocTextField;
    private javax.swing.JTable SuaDiemTable;
    private javax.swing.JButton TimSinhVienButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration                   
    
   
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource().equals(TimSinhVienButton)) btnTimClick();
        else if(e.getSource().equals(CapNhapButton)) btnCapNhapClick();
        else
        {
            this.dispose();
        }
     }
    public void btnTimClick()
    {
        SinhVien NewSinhVien = sinhVienDAO.getSinhVien(IdTextField.getText());
        
        
        ArrayList NewTienTrinh = tienTrinhDAO.getTienTrinh(NewSinhVien);
        model = (DefaultTableModel) SuaDiemTable.getModel();
        model.setRowCount(0);
        model.setColumnIdentifiers(new Object[]{
            "STT","Name","Result"
        });
        int cnt=1;
        
        
        for(int j = 0; j < NewTienTrinh.size(); j++)
        {
           
            TienTrinh i = (TienTrinh) NewTienTrinh.get(j);
            
            if(i.getHocKi() == Integer.parseInt(KiHocTextField.getText()))
            {
                
                model.addRow(new Object[]{
                    new Integer(cnt), i.getTenMon(), new Float(i.getKetQua())
                });
                cnt+=1;
            }
        }
    }
    public void btnCapNhapClick()
    {
        SinhVien NewSinhVien = sinhVienDAO.getSinhVien(IdTextField.getText());
        TienTrinh tr = new TienTrinh();
        tr.setId(NewSinhVien.getId());
        tr.setHocKi(Integer.parseInt(KiHocTextField.getText()));
        tr.setChuyenNganh(NewSinhVien.getMajor());
        boolean kt = true;
        for(int i = 0;i<model.getRowCount();i++)
        {
            tr.setTenMon(model.getValueAt(i, 1).toString());
            try {
                tr.setKetQua(Float.parseFloat(model.getValueAt(i, 2).toString()));
            } catch (NumberFormatException e) {
                tr.setKetQua(0);
            }
            if(new TienTrinhDAO().SetDiem(tr) == false) kt = false;
            
        }
        if(kt) JOptionPane.showMessageDialog(rootPane, "Grade update successfull!");
        else JOptionPane.showMessageDialog(rootPane, "Error!");
        
    }
}