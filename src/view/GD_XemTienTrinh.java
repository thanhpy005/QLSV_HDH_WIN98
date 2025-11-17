package view;

import controller.TienTrinhDAO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Iterator; 
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.TienTrinh;
import model.SinhVien;
import javax.swing.JPanel; 


public class GD_XemTienTrinh extends javax.swing.JFrame implements ActionListener {
    private SinhVien sv;
    
    private ArrayList list;
    DefaultTableModel m1, m2, m3, m4, m5, m6, m7, m8;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GD_XemTienTrinh.class.getName());

    public GD_XemTienTrinh(SinhVien sinhVien) {
        initComponents();
        
        
        setLocationRelativeTo(null);
        
        BackButton.addActionListener(this);
        sv = sinhVien;
        list = new TienTrinhDAO().getTienTrinh(sv);
        m1 = (DefaultTableModel) DiemKi1Table.getModel();
        m2 = (DefaultTableModel) DiemKi2Table.getModel();
        m3 = (DefaultTableModel) DiemKi3Table.getModel();
        m4 = (DefaultTableModel) DiemKi4Table.getModel();
        m5 = (DefaultTableModel) DiemKi5Table.getModel();
        m6 = (DefaultTableModel) DiemKi6Table.getModel();
        m7 = (DefaultTableModel) DiemKi7Table.getModel();
        m8 = (DefaultTableModel) DiemKi8Table.getModel();
        
        String[] columnNames = new String[]{"Name", "Result", "Status"};
        m1.setColumnIdentifiers(columnNames);
        m2.setColumnIdentifiers(columnNames);
        m3.setColumnIdentifiers(columnNames);
        m4.setColumnIdentifiers(columnNames);
        m5.setColumnIdentifiers(columnNames);
        m6.setColumnIdentifiers(columnNames);
        m7.setColumnIdentifiers(columnNames);
        m8.setColumnIdentifiers(columnNames);
        
        LoadDataTable();
        
        GpaTab1Label.setText(String.valueOf(TbKetQua(m1)));
        GpaTab2Label.setText(String.valueOf(TbKetQua(m2)));
        GpaTab3Label.setText(String.valueOf(TbKetQua(m3)));
        GpaTab4Label.setText(String.valueOf(TbKetQua(m4)));
        GpaTab5Label.setText(String.valueOf(TbKetQua(m5)));
        GpaTab6Label.setText(String.valueOf(TbKetQua(m6)));
        GpaTab7Label.setText(String.valueOf(TbKetQua(m7)));
        GpaTab8Label.setText(String.valueOf(TbKetQua(m8)));
    }

    public float TbKetQua(DefaultTableModel m) {
        float res = 0;
        int cnt = 0;
        for (int i = 0; i < m.getRowCount(); i++) {
            
            float diem = ((Float) m.getValueAt(i, 1)).floatValue();
            if (diem > 0) {
                res += diem;
                cnt++;
            }
        }
        
        if (cnt == 0) {
            return 0;
        }
        return res / cnt;
    }

    public void LoadDataTable() {
        
        for (Iterator it = list.iterator(); it.hasNext();) {
            TienTrinh i = (TienTrinh) it.next(); 
            String trangThai = (i.getKetQua() != 0) ? "Completed" : "Incompleted";
            Object[] rowData = new Object[]{i.getTenMon(), new Float(i.getKetQua()), trangThai};
            
            if (i.getHocKi() == 1) m1.addRow(rowData);
            else if (i.getHocKi() == 2) m2.addRow(rowData);
            else if (i.getHocKi() == 3) m3.addRow(rowData);
            else if (i.getHocKi() == 4) m4.addRow(rowData);
            else if (i.getHocKi() == 5) m5.addRow(rowData);
            else if (i.getHocKi() == 6) m6.addRow(rowData);
            else if (i.getHocKi() == 7) m7.addRow(rowData);
            else if (i.getHocKi() == 8) m8.addRow(rowData);
        }
    }

    
    
    private void initComponents() {
        
        jTabbedPane12 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DiemKi1Table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        GpaTab1Label = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        DiemKi2Table = new javax.swing.JTable();
        GpaTab2Label = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        DiemKi3Table = new javax.swing.JTable();
        GpaTab3Label = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        DiemKi4Table = new javax.swing.JTable();
        GpaTab4Label = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        DiemKi5Table = new javax.swing.JTable();
        GpaTab5Label = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        DiemKi6Table = new javax.swing.JTable();
        GpaTab6Label = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        DiemKi7Table = new javax.swing.JTable();
        GpaTab7Label = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        DiemKi8Table = new javax.swing.JTable();
        GpaTab8Label = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BackButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Student Management [Student]");
        getContentPane().setLayout(null);

        // --- Tab 1 ---
        setupTabPanel(jPanel3, jScrollPane1, DiemKi1Table, jLabel1, GpaTab1Label);
        jTabbedPane12.addTab("Term 1", jPanel3);
        
        // --- Tab 2 ---
        setupTabPanel(jPanel6, jScrollPane2, DiemKi2Table, jLabel3, GpaTab2Label);
        jTabbedPane12.addTab("Term 2", jPanel6);
        
        // --- Tab 3 ---
        setupTabPanel(jPanel7, jScrollPane3, DiemKi3Table, jLabel5, GpaTab3Label);
        jTabbedPane12.addTab("Term 3", jPanel7);

        // --- Tab 4 ---
        setupTabPanel(jPanel8, jScrollPane4, DiemKi4Table, jLabel6, GpaTab4Label);
        jTabbedPane12.addTab("Term 4", jPanel8);

        // --- Tab 5 ---
        setupTabPanel(jPanel9, jScrollPane5, DiemKi5Table, jLabel7, GpaTab5Label);
        jTabbedPane12.addTab("Term 5", jPanel9);
        
        // --- Tab 6 ---
        setupTabPanel(jPanel10, jScrollPane6, DiemKi6Table, jLabel8, GpaTab6Label);
        jTabbedPane12.addTab("Term 6", jPanel10);
        
        // --- Tab 7 ---
        setupTabPanel(jPanel11, jScrollPane7, DiemKi7Table, jLabel9, GpaTab7Label);
        jTabbedPane12.addTab("Term 7", jPanel11);
        
        // --- Tab 8 ---
        setupTabPanel(jPanel12, jScrollPane8, DiemKi8Table, jLabel2, GpaTab8Label);
        jTabbedPane12.addTab("Term 8", jPanel12);

        getContentPane().add(jTabbedPane12);
        jTabbedPane12.setBounds(0, 0, 550, 400);

        BackButton.setText("Back");
        getContentPane().add(BackButton);
        BackButton.setBounds(450, 400, 90, 25);
        
        setSize(565, 500);
    }
    
   
    private void setupTabPanel(JPanel panel, javax.swing.JScrollPane scrollPane, javax.swing.JTable table, javax.swing.JLabel gpaTextLabel, javax.swing.JLabel gpaValueLabel) {
        panel.setLayout(null);
        table.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, new String[]{}));
        scrollPane.setViewportView(table);
        panel.add(scrollPane);
        scrollPane.setBounds(10, 10, 510, 200);

        gpaTextLabel.setFont(new java.awt.Font("SansSerif", 1, 14));
        gpaTextLabel.setText("GPA:");
        panel.add(gpaTextLabel);
        gpaTextLabel.setBounds(400, 220, 40, 25);
        
        gpaValueLabel.setFont(new java.awt.Font("SansSerif", 1, 14));
        gpaValueLabel.setOpaque(true);
        panel.add(gpaValueLabel);
        gpaValueLabel.setBounds(450, 220, 60, 25);
    }

    public static void main(String args[]) {
        
    }

    // cac bien thanh phan
    private javax.swing.JButton BackButton;
    private javax.swing.JTable DiemKi1Table;
    private javax.swing.JTable DiemKi2Table;
    private javax.swing.JTable DiemKi3Table;
    private javax.swing.JTable DiemKi4Table;
    private javax.swing.JTable DiemKi5Table;
    private javax.swing.JTable DiemKi6Table;
    private javax.swing.JTable DiemKi7Table;
    private javax.swing.JTable DiemKi8Table;
    private javax.swing.JLabel GpaTab1Label;
    private javax.swing.JLabel GpaTab2Label;
    private javax.swing.JLabel GpaTab3Label;
    private javax.swing.JLabel GpaTab4Label;
    private javax.swing.JLabel GpaTab5Label;
    private javax.swing.JLabel GpaTab6Label;
    private javax.swing.JLabel GpaTab7Label;
    private javax.swing.JLabel GpaTab8Label;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane12;
   
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(BackButton)) {
            GD_Menu_SV winD_Menu_SV = new GD_Menu_SV(sv);
            winD_Menu_SV.setLocationRelativeTo(null);
            winD_Menu_SV.setVisible(true);
            this.dispose();
        }
    }
}