package view;

import controller.TaiKhoanDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.SinhVien;
import model.TaiKhoan;

public class GD_DoiMk extends javax.swing.JFrame implements ActionListener{
    public SinhVien sinhVien;
    public TaiKhoan taiKhoan;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GD_DoiMk.class.getName());

    private TaiKhoanDAO taiKhoanDAO;
    
    public GD_DoiMk(SinhVien s) {
        initComponents();
        sinhVien = s;
        
        taiKhoanDAO = new TaiKhoanDAO();
        
        CapNhapButton.addActionListener(this);
        ResetButton.addActionListener(this);
        BackButton.addActionListener(this);
    }

                
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        XacNhanTextField = new javax.swing.JPasswordField();
        MatKhauMoiTextField = new javax.swing.JPasswordField();
        CapNhapButton = new javax.swing.JButton();
        ResetButton = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();
        MatKhauCuTextField = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        setTitle("Student Management [USER]");
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); 
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Change Password");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 440, 52));

        jLabel3.setText("Current password:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 86, -1, -1));

        jLabel4.setText("New password:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 120, -1, -1));

        jLabel5.setText("Confirm:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 154, -1, -1));
        getContentPane().add(XacNhanTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 151, 208, -1));
        getContentPane().add(MatKhauMoiTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 117, 208, -1));

        CapNhapButton.setText("Update");
        getContentPane().add(CapNhapButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(72, 205, -1, -1));

        ResetButton.setText("Reset");
        getContentPane().add(ResetButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 205, 83, -1));

        BackButton.setText("Back");
        getContentPane().add(BackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 271, -1, -1));
        getContentPane().add(MatKhauCuTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 83, 208, -1));

        pack();
    }// </editor-fold>                        

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
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton BackButton;
    private javax.swing.JButton CapNhapButton;
    private javax.swing.JPasswordField MatKhauCuTextField;
    private javax.swing.JPasswordField MatKhauMoiTextField;
    private javax.swing.JButton ResetButton;
    private javax.swing.JPasswordField XacNhanTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration                   
    
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource().equals(CapNhapButton)) btnCapNhapClick();
        else if(e.getSource().equals(ResetButton))
        {
            MatKhauCuTextField.setText("");
            MatKhauMoiTextField.setText("");
            XacNhanTextField.setText("");
        }
        else
        {
            GD_Menu_SV winD_Menu_SV = new GD_Menu_SV(sinhVien);
            winD_Menu_SV.setLocationRelativeTo(null);
            winD_Menu_SV.setVisible(true);
            this.dispose();
        }
     }
    public void btnCapNhapClick()
    {
        TaiKhoan tk = taiKhoanDAO.getTaiKhoan(sinhVien);
        
        
        char[] temp1 = MatKhauCuTextField.getPassword();
        char[] temp2 = MatKhauMoiTextField.getPassword();
        char[] temp3 = XacNhanTextField.getPassword();
        
        String MatKhauCu = new String(temp1);
        String NewMk  = new String(temp2);
        String XacNhanMk = new String(temp3);
        
        if(MatKhauCu.equals(tk.getPassWord())) 
        {
            if(NewMk.equals(XacNhanMk))
            {
              
                
                if(taiKhoanDAO.DoiMatKhau(sinhVien, NewMk)) 
                {
                    JOptionPane.showMessageDialog(rootPane, "Update successful!");
                }
                else JOptionPane.showMessageDialog(rootPane, "Update failed!");
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Confirm password does not match new password!");
            }
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "Incorrect current password!");
        }
    }

}