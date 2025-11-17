package view;

import controller.SinhVienDAO;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat; 
import java.util.ArrayList;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import model.SinhVien;



public class GD_SVCungLop extends javax.swing.JFrame implements ActionListener{
    SinhVien sinhVien;
    ArrayList list; 
    DefaultTableModel model;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GD_SVCungLop.class.getName());

    
    public GD_SVCungLop(SinhVien sinhVien) {
        initComponents();
        this.sinhVien = sinhVien;
        BackButton.addActionListener(this);
        model = (DefaultTableModel) SvTable.getModel();
        list = new SinhVienDAO().getlistSinhVien();
        int cnt = 0;
        model.setColumnIdentifiers(new Object[]{
            "STT","ID","NAME","GENDER","DOB","CLASS","ADDRESS","PHONE NUMBER","EMAIL","STATUS","MAJOR","TERM"
        });
        SvTable.getColumnModel().getColumn(0).setPreferredWidth(35);
        SvTable.getColumnModel().getColumn(1).setPreferredWidth(80);
        SvTable.getColumnModel().getColumn(2).setPreferredWidth(115);
        SvTable.getColumnModel().getColumn(3).setPreferredWidth(55);
        SvTable.getColumnModel().getColumn(4).setPreferredWidth(75);
        SvTable.getColumnModel().getColumn(5).setPreferredWidth(70);
        SvTable.getColumnModel().getColumn(6).setPreferredWidth(60);
        SvTable.getColumnModel().getColumn(7).setPreferredWidth(60);
        SvTable.getColumnModel().getColumn(8).setPreferredWidth(60);
        SvTable.getColumnModel().getColumn(9).setPreferredWidth(60);
        SvTable.getColumnModel().getColumn(10).setPreferredWidth(40);
        SvTable.getColumnModel().getColumn(11).setPreferredWidth(40);
        
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
        
        
        for(int j = 0; j < list.size(); j++)
        {
            
            SinhVien i = (SinhVien) list.get(j); 
            
            if(i.getMainClass().equals(sinhVien.getMainClass()))
            {
         
                model.addRow(new Object[]{
                    new Integer(++cnt),
                    i.getId(),
                    i.getName(),
                    i.getSex(),
                    sdf.format(i.getDob()),
                    i.getMainClass(),
                    i.getAddress(),
                    i.getPhone(),
                    i.getEmail(),
                    i.getStatus(),
                    i.getMajor(),
                    new Integer(i.getSchoolYear()), 
                   
                });
            }
        }
        
        SvTable.setDefaultEditor(Object.class, null);
        int columnIndex = 12;
        
    
    }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        SvTable = new javax.swing.JTable();
        BackButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout()); 

        SvTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(SvTable);
        SvTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 300));

        BackButton.setText("Back");
        getContentPane().add(BackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 310, -1, -1));

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
    private javax.swing.JButton BackButton;
    private javax.swing.JTable SvTable;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration                   
    
   
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource().equals(BackButton))
        {
            GD_Menu_SV winD_Menu_SV = new GD_Menu_SV(sinhVien);
            winD_Menu_SV.setLocationRelativeTo(null);
            winD_Menu_SV.setVisible(true);
            this.dispose();
        }
    }

}