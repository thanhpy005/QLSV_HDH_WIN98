
package view;

import controller.TaiKhoanDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;



public class GD_ThemTaiKhoan extends javax.swing.JFrame implements ActionListener{
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GD_ThemTaiKhoan.class.getName());

    private TaiKhoanDAO taiKhoanDAO;
    
    public GD_ThemTaiKhoan() {
        initComponents();
        setSize(500,260);
        taiKhoanDAO = new TaiKhoanDAO();
        
        AddButton.addActionListener(this);
        ResetButton.addActionListener(this);
        BackButton.addActionListener(this);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        UserNameTextField = new javax.swing.JTextField();
        PassWordTextField = new javax.swing.JPasswordField();
        AddButton = new javax.swing.JButton();
        ResetButton = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student Management [ADMIN]");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add Account");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 6, 282, 52));

        jLabel2.setText("Username:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 79, -1, -1));

        jLabel3.setText("Password:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 113, -1, -1));
        getContentPane().add(UserNameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 76, 159, -1));
        getContentPane().add(PassWordTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 110, 159, -1));

        AddButton.setText("Add");
        getContentPane().add(AddButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 181, -1, -1));

        ResetButton.setText("Reset");
        getContentPane().add(ResetButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(315, 181, -1, -1));

        BackButton.setText("Back");
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
                new GD_ThemTaiKhoan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton AddButton;
    private javax.swing.JButton BackButton;
    private javax.swing.JPasswordField PassWordTextField;
    private javax.swing.JButton ResetButton;
    private javax.swing.JTextField UserNameTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration                   
    
   
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource().equals(AddButton)) btnAddClick();
        else if(e.getSource().equals(ResetButton))
        {
            UserNameTextField.setText("");
            PassWordTextField.setText("");
        }
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
        
        char[] temp = PassWordTextField.getPassword();
        String passWorString = new String(temp);
        if(UserNameTextField.getText().equals("") || passWorString.equals("")){
            JOptionPane.showMessageDialog(rootPane, "Username or password is blank");
        }
        else {
            if(taiKhoanDAO.AddTaiKhoan(UserNameTextField.getText(), passWorString))
            {
                JOptionPane.showMessageDialog(rootPane, "Added account successful!");
            }
        }
        
    }

}