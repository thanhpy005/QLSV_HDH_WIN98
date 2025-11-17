/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.TienTrinhDAO;
import controller.TkbDAO;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import model.LichHoc;
import model.SinhVien;
import model.TienTrinh;

/**
 *
 * @author ThanhNguyen
 */
public class GD_DangKiMon extends javax.swing.JFrame implements ActionListener{
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GD_DangKiMon.class.getName());
    private DefaultTableModel model;
    private ArrayList list; 
    private SinhVien sinhVien;
    
    public GD_DangKiMon(SinhVien s) {
        
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
        sinhVien = s;
        RefreshButton.addActionListener(this);
        BackButton.addActionListener(this);
        list  = new TienTrinhDAO().getTienTrinh2KiHoc(s);
        
        
        for(int j = 0; j < list.size(); j++)
        {
            TienTrinh i = (TienTrinh) list.get(j); 
            TenMonCheckBox.addItem(i.getTenMon());
        }
        model = (DefaultTableModel) MonHocTable.getModel();
        model.setColumnIdentifiers(new Object[]{
            "ID","NAME","CLASSROOM","START TIME","NUMBER OF LESSONS","DAY","PERIOD","OPERATION"
        });
        MonHocTable.getColumnModel().getColumn(0).setPreferredWidth(40);
        MonHocTable.getColumnModel().getColumn(1).setPreferredWidth(100);
        MonHocTable.getColumnModel().getColumn(2).setPreferredWidth(50);
        MonHocTable.getColumnModel().getColumn(3).setPreferredWidth(50);
        MonHocTable.getColumnModel().getColumn(4).setPreferredWidth(50);
        MonHocTable.getColumnModel().getColumn(5).setPreferredWidth(50);
        MonHocTable.getColumnModel().getColumn(6).setPreferredWidth(80);
        MonHocTable.getColumnModel().getColumn(7).setPreferredWidth(65);
    }
    public String getMaMon(String s)
    {
        String res = "";
        String[] a = s.split("\\s+");
        
        
        for(int k = 0; k < a.length; k++)
        {
            res += Character.toUpperCase(a[k].charAt(0));
        }
        return res;
        
    }
    public void ShowData()
    {
        int[] haitiet = {1,7};
        int[] batiet = {3,9};
        for(int i = 2; i <= 7; i++) 
        {
            
            for(int h = 0; h < haitiet.length; h++)
            {
                int j = haitiet[h];
                model.addRow(new Object[]{
                    getMaMon(TenMonCheckBox.getSelectedItem().toString()),
                    TenMonCheckBox.getSelectedItem().toString(),
                    String.valueOf(j) + "0" + String.valueOf(TenMonCheckBox.getSelectedIndex()+1),
                    new Integer(j), 
                    new Integer(2),
                    new Integer(i),
                    (sinhVien.getSchoolYear() % 2 == 0)? "From 01/02 to 31/05" : "From 15/08 to 31/12",
                    "Join"
                });
            }
            
            
            for(int b = 0; b < batiet.length; b++)
            {
                int j = batiet[b];
                model.addRow(new Object[]{
                    getMaMon(TenMonCheckBox.getSelectedItem().toString()),
                    TenMonCheckBox.getSelectedItem().toString(),
                    String.valueOf(j) + "0" + String.valueOf(TenMonCheckBox.getSelectedIndex()+1),
                    new Integer(j), 
                    new Integer(3), 
                    new Integer(i), 
                    (sinhVien.getSchoolYear() % 2 == 0)? "From 01/02 to 31/05" : "From 15/08 to 31/12",
                    "Join"
                });
            }
            
        }
    }
  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TenMonCheckBox = new javax.swing.JComboBox(); 
        RefreshButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        MonHocTable = new javax.swing.JTable();
        BackButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student Management [USER]");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout()); 

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); 
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Course Registration");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 66));

        jLabel2.setText("Course name:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 81, -1, -1));

        getContentPane().add(TenMonCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 78, 200, -1));

        RefreshButton.setText("Refresh");
        getContentPane().add(RefreshButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 78, -1, -1));

        MonHocTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(MonHocTable);
        MonHocTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 119, 505, 300));

        BackButton.setText("Back");
        getContentPane().add(BackButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 430, -1, -1));

        pack();
    }// </editor-fold>                        

   
    public static void main(String args[]) {
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
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
        //</editor-fold>
        
        
        
        
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton BackButton;
    private javax.swing.JTable MonHocTable;
    private javax.swing.JButton RefreshButton;
    private javax.swing.JComboBox TenMonCheckBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration                   
    
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource().equals(RefreshButton)) btnRefreshButtonClick();
        else btnBackButtonClick();
    }
    public void btnRefreshButtonClick()
    {
        model.setRowCount(0);
        ShowData();
        int columIndex = 7;
        MonHocTable.getColumnModel().getColumn(columIndex).setCellRenderer(new ButtonRenderer2());
        MonHocTable.getColumnModel().getColumn(columIndex).setCellEditor(new ButtonEditor2(sinhVien));
        
    }
    public void btnBackButtonClick()
    {
        GD_Menu_SV winD_Menu_SV = new GD_Menu_SV(sinhVien);
        winD_Menu_SV.setLocationRelativeTo(null);
        winD_Menu_SV.setVisible(true);
        this.dispose();
    }
}
class ButtonRenderer2 extends JButton implements TableCellRenderer
{
    public ButtonRenderer2()
    {
        setOpaque(true);
        
    }
   
    public Component getTableCellRendererComponent(JTable table,Object value,boolean isSelected, boolean hasFocus,int row, int column)
    {
        setText((value == null)? "Join": value.toString());
        return this;
    }
}
class ButtonEditor2 extends AbstractCellEditor implements TableCellEditor, ActionListener
{
    private JButton button;
    private JTable table;
    private int currentRow;
    private SinhVien sinhVien;
    public ButtonEditor2(SinhVien s)
    {
        sinhVien =s;
        button = new JButton("Join");
        button.setOpaque(true);
        button.addActionListener(this);
    }
   
    public Component getTableCellEditorComponent(JTable table, Object value,boolean isSelected, int row, int column)
    {
        this.table = table;
        this.currentRow = row;
        button.setText((value == null)? "Join":value.toString());
        return button;
    }
    
    public Object getCellEditorValue()
    {
        return button.getText();
    }
    
    public void actionPerformed(ActionEvent e)
    {
        LichHoc l = new LichHoc();
        l.setId(sinhVien.getId());
        l.setMamon(table.getValueAt(currentRow, 0).toString());
        l.setTenmon(table.getValueAt(currentRow, 1).toString());
        l.setPhonghoc(table.getValueAt(currentRow, 2).toString());
        l.setTietBatDau(Integer.parseInt(table.getValueAt(currentRow, 3).toString()));
        l.setSoTiet(Integer.parseInt(table.getValueAt(currentRow, 4).toString()));
        l.setDayString(table.getValueAt(currentRow, 5).toString());
        l.setThoiGian(table.getValueAt(currentRow, 6).toString());
        l.setKiHoc(sinhVien.getSchoolYear());
        if(new TkbDAO().CapNhapTkb(l))
        {
            JOptionPane.showMessageDialog(null, "Registration successfull!");
        }
        else{
            JOptionPane.showMessageDialog(null, "Duplicate class schedule or registered course!");
        }
    }

   
    protected void fireEditingStopped() {
        super.fireEditingStopped(); 
    }
    
}