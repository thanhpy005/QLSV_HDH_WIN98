package view;

import controller.SinhVienDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.SinhVien;
import java.awt.Component;
import java.text.SimpleDateFormat; 
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;


public class GD_ShowSinhVien extends javax.swing.JFrame implements ActionListener{
    public ArrayList list; 
    public DefaultTableModel model;
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GD_ShowSinhVien.class.getName());
    
    
    
    public GD_ShowSinhVien() {
        initComponents();
        BackButton.addActionListener(this);
        this.setLocationRelativeTo(null);
        list = new SinhVienDAO().getlistSinhVien();
        model = (DefaultTableModel) TableSinhVien.getModel();
        model.setColumnIdentifiers(new Object[]{
            "STT","ID","NAME","GENDER","DOB","CLASS","ADDRESS","PHONE","EMAIL","STATUS","MAJOR","TERM","INFORMATION"
        });
        
        TableSinhVien.setDefaultEditor(Object.class, null);
        TableSinhVien.getColumnModel().getColumn(0).setPreferredWidth(35);
        TableSinhVien.getColumnModel().getColumn(1).setPreferredWidth(80);
        TableSinhVien.getColumnModel().getColumn(2).setPreferredWidth(115);
        TableSinhVien.getColumnModel().getColumn(3).setPreferredWidth(55);
        TableSinhVien.getColumnModel().getColumn(4).setPreferredWidth(75);
        TableSinhVien.getColumnModel().getColumn(5).setPreferredWidth(70);
        TableSinhVien.getColumnModel().getColumn(6).setPreferredWidth(60);
        TableSinhVien.getColumnModel().getColumn(7).setPreferredWidth(60);
        TableSinhVien.getColumnModel().getColumn(8).setPreferredWidth(60);
        TableSinhVien.getColumnModel().getColumn(9).setPreferredWidth(60);
        TableSinhVien.getColumnModel().getColumn(10).setPreferredWidth(40);
        TableSinhVien.getColumnModel().getColumn(11).setPreferredWidth(40);
        TableSinhVien.getColumnModel().getColumn(12).setPreferredWidth(70);
        
        ShowData();
        int buttonColumnIndex = 12;
        TableSinhVien.getColumnModel().getColumn(buttonColumnIndex).setCellRenderer(new ButtonRenderer());
        TableSinhVien.getColumnModel().getColumn(buttonColumnIndex).setCellEditor(new ButtonEditor());
        
        
    }
    public void ShowData()
    {
        
        int cnt = 0;
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        
        for(int j = 0; j < list.size(); j++)
        {
            
            SinhVien i = (SinhVien) list.get(j);
            
            
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
                "Detail"
            });
        }
    }
    
   
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableSinhVien = new javax.swing.JTable();
        BackButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout()); 

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Student Information");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 6, 525, 42));

       
        TableSinhVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        
        TableSinhVien.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jScrollPane1.setViewportView(TableSinhVien);
        
        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 840, 300));

        BackButton.setText("Back");
        getContentPane().add(BackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 21, -1, -1));

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
                new GD_ShowSinhVien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton BackButton;
    private javax.swing.JTable TableSinhVien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration                   
    
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource().equals(BackButton))
        {
            GD_Menu_Admin winAdmin = new GD_Menu_Admin();
            winAdmin.setLocationRelativeTo(null);
            winAdmin.setVisible(true);
            this.dispose();
        }
    }
}
class ButtonRenderer extends JButton implements TableCellRenderer {
    public ButtonRenderer()
    {
        setOpaque(true);
    }
    
    public Component getTableCellRendererComponent(JTable table,Object value,boolean  isSelected,boolean hasFocus,int row, int column)
    {
        setText((value == null)? "Detail" : value.toString());
        return this;
    }
}
class ButtonEditor extends AbstractCellEditor implements TableCellEditor,ActionListener{
    private JButton button;
    private int currentRow;
    private JTable table;
    public ButtonEditor()
    {
        button = new JButton("Detail");
        button.setOpaque(true);
        button.addActionListener(this);
    }
    
    public Component getTableCellEditorComponent(JTable table,Object value,boolean  isSelected,int row, int column)
    {
        this.table = table;
        this.currentRow = row;
        button.setText((value == null)? "Detail" : value.toString());
        return button;
    }
    
    public Object getCellEditorValue()
    {
        return button.getText();
    }
    
    public void actionPerformed(ActionEvent e)
    {
        Object student = table.getValueAt(currentRow, 1);
        SinhVien s = new SinhVienDAO().getSinhVien(student.toString());
        GD_Menu_SV1 winD_Menu_SV = new GD_Menu_SV1(s);
        winD_Menu_SV.setLocationRelativeTo(null);
        winD_Menu_SV.setVisible(true);
        
    }


    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }
    
}