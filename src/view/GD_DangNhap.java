package view;

import controller.TaiKhoanDAO;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.util.Properties;
import model.SinhVien;



public class GD_DangNhap extends javax.swing.JFrame implements ActionListener{
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GD_DangNhap.class.getName());

    private TaiKhoanDAO taiKhoanDAO;
    
    public GD_DangNhap() {
        initComponents();
       
        taiKhoanDAO = new TaiKhoanDAO();
        
        LoginButton.addActionListener(this);
        ResetButton.addActionListener(this);
        QuitButton.addActionListener(this);
        
    }

    
                 
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        UserTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        LoginButton = new javax.swing.JButton();
        ResetButton = new javax.swing.JButton();
        QuitButton = new javax.swing.JButton();
        PassTextField = new javax.swing.JPasswordField();
        NvCheckBox = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student Management [Admin]");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout()); 

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); 
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Login Page");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 19, 478, 74));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
        jLabel2.setText("User:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 111, 44, 25));
        getContentPane().add(UserTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 113, 151, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); 
        jLabel3.setText("Pass:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 148, 44, 25));

        LoginButton.setText("Login");
        LoginButton.setOpaque(true);
        getContentPane().add(LoginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 238, 88, -1));

        ResetButton.setText("Reset");
        ResetButton.setOpaque(true);
        getContentPane().add(ResetButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 238, 88, -1));

        QuitButton.setText("Quit");
        getContentPane().add(QuitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 267, -1, -1));
        getContentPane().add(PassTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 150, 151, -1));

        NvCheckBox.setText("ADMIN");
        getContentPane().add(NvCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 191, -1, -1));

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
     
        final GD_DangNhap winDangNhap = new GD_DangNhap(); 
        winDangNhap.setLocationRelativeTo(null);
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                winDangNhap.setVisible(true);
            }
        });
      

    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton LoginButton;
    private javax.swing.JCheckBox NvCheckBox;
    private javax.swing.JPasswordField PassTextField;
    private javax.swing.JButton QuitButton;
    private javax.swing.JButton ResetButton;
    private javax.swing.JTextField UserTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration                   
    
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource().equals(LoginButton))
        {
            tbnLoginClick();
        }
        else if(e.getSource().equals(ResetButton))
                {
                    tbnResetClich();
                }
        else
        {
            this.dispose();
        }
    }
    public void tbnLoginClick()
    {
        char[] pass1 = PassTextField.getPassword();
        String passWord = new String(pass1);
        if(taiKhoanDAO.DangNhap(UserTextField.getText(), passWord,NvCheckBox.isSelected()) == true){
            this.dispose();
        }
        
    }
    public void tbnResetClich()
    {
        UserTextField.setText("");
        PassTextField.setText("");
    }
          
}