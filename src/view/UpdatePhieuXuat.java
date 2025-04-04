/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package view;

import com.formdev.flatlaf.FlatLightLaf;
import controller.SearchProduct;
import dao.AccountDAO;
import dao.ChiTietPhieuXuatDAO;
import java.sql.Timestamp;
import dao.HangDAO;
import dao.NhaCungCapDAO;
import dao.PhieuXuatDAO;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import model.ChiTietPhieu;
import model.Hang;
import model.NhaCungCap;
import model.PhieuXuat;


public class UpdatePhieuXuat extends javax.swing.JDialog {

    /**
     * Creates new form UpdatePhieuXuat
     */
    private DefaultTableModel tblModel;
    DecimalFormat formatter = new DecimalFormat("###,###,###");
    private ArrayList<Hang> allProduct;
    private PhieuXuat phieuxuat;
    private ArrayList<ChiTietPhieu> CTPhieu;
    private ArrayList<ChiTietPhieu> CTPhieuOld;
    private PhieuXuatForm parent;
    private static final ArrayList<NhaCungCap> arrNcc = NhaCungCapDAO.getInstance().selectAll();

    public UpdatePhieuXuat(javax.swing.JInternalFrame parent, javax.swing.JFrame owner, boolean modal) throws UnsupportedLookAndFeelException {
        super(owner, modal);
        UIManager.setLookAndFeel(new FlatLightLaf());
        initComponents();
        setLocationRelativeTo(null);
        // Lay thong tin 
        allProduct = HangDAO.getInstance().selectAllExist();
        this.parent = (PhieuXuatForm) parent;
        this.phieuxuat = this.parent.getPhieuXuatSelect();                    
        CTPhieu = ChiTietPhieuXuatDAO.getInstance().selectAll(this.parent.getPhieuXuatSelect().getMaPhieu());
//        System.out.println(CTPhieu);
        CTPhieuOld = ChiTietPhieuXuatDAO.getInstance().selectAll(phieuxuat.getMaPhieu());
        // Hien thi thong tin
        initTable();
        loadDataToTableProduct(allProduct);       
        loadDataToTableXuatHang();
//         System.out.println("load khoi tao");
        displayInfo();
    }

    private UpdatePhieuXuat(JFrame jFrame, boolean b) {
        super(jFrame, b);
        initComponents();
        setLocationRelativeTo(null);
    }

    private void displayInfo() {
        txtMaPhieu.setText(phieuxuat.getMaPhieu());
        textTongTien.setText(formatter.format(phieuxuat.getTongTien()) + "đ");
        txtNguoiTao.setText(AccountDAO.getInstance().selectById(phieuxuat.getNguoiTao()).getUserName());
    }

        public final void initTable() {
        tblModel = new DefaultTableModel();
        String[] headerTbl = new String[]{"Mã hàng", "Tên hàng", "Số lượng", "Đơn giá"};
        tblModel.setColumnIdentifiers(headerTbl);
        tblSanPham.setModel(tblModel);
        tblSanPham.getColumnModel().getColumn(0).setPreferredWidth(5);
        tblSanPham.getColumnModel().getColumn(1).setPreferredWidth(200);
        tblSanPham.getColumnModel().getColumn(2).setPreferredWidth(5);
        tblNhapHang.getColumnModel().getColumn(0).setPreferredWidth(5);
        tblNhapHang.getColumnModel().getColumn(1).setPreferredWidth(10);
        tblNhapHang.getColumnModel().getColumn(2).setPreferredWidth(250);
        tblSanPham.setDefaultEditor(Object.class, null);
    }

    private void loadDataToTableProduct(ArrayList<Hang> arrProd) {
        try {
            tblModel.setRowCount(0);
            for (var i : arrProd) {
                tblModel.addRow(new Object[]{
                    i.getMaHang(), i.getTenHang(), i.getSoLuong(), formatter.format(i.getGia()) + "đ"
                });
            }
        } catch (Exception e) {
        }
    }

    public double tinhTongTien() {
        double tt = 0;
        for (var i : CTPhieu) {
            tt += i.getDonGia() * i.getSoLuong();
        }
        return tt;
    }

    public Hang findHang(String maHang) {
        for (var i : allProduct) {           
            if (maHang.equals(i.getMaHang())) {
                return i;
            }
        }
        return null;
    }

    public ChiTietPhieu findCTPhieu(String maHang) {
//        System.out.println(maHang);   
        for (var i : CTPhieu) {
            if (maHang.equals(i.getMaHang())) {
//                System.out.println("ma hang:" + i.getMaHang()); 
                return i;
            }
        }
        return null;    
    }

    private void loadDataToTableXuatHang() {
        try {
            
//            CTPhieu = ChiTietPhieuXuatDAO.getInstance().selectAll(this.parent.getPhieuXuatSelect().getMaPhieu());
            DefaultTableModel tblNhapHangmd = (DefaultTableModel) tblNhapHang.getModel();
            tblNhapHangmd.setRowCount(0);
            for (int i = 0; i < CTPhieu.size(); i++) {       
//                System.out.println(CTPhieu.get(i).getMaHang());    
//                System.out.println( findHang(CTPhieu.get(i).getMaHang()).getTenHang());               
                tblNhapHangmd.addRow(new Object[]{                   
                    i + 1, 
                    CTPhieu.get(i).getMaHang(), 
                    findHang(CTPhieu.get(i).getMaHang()).getTenHang(), 
                    CTPhieu.get(i).getSoLuong(), 
                    formatter.format(CTPhieu.get(i).getDonGia()) + "đ"
                });
            }
//            System.out.println("da load");    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.toString());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMaPhieu = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNguoiTao = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhapHang = new javax.swing.JTable();
        btnNhapHang = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        textTongTien = new javax.swing.JLabel();
        deleteProduct = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        addProduct = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        btnReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sửa phiếu xuất");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("SF Pro Display", 0, 15)); // NOI18N
        jLabel1.setText("Mã phiếu nhập");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        txtMaPhieu.setEditable(false);
        txtMaPhieu.setFont(new java.awt.Font("SF Pro Display", 0, 15)); // NOI18N
        txtMaPhieu.setEnabled(false);
        txtMaPhieu.setFocusable(false);
        jPanel2.add(txtMaPhieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 390, 36));

        jLabel3.setFont(new java.awt.Font("SF Pro Display", 0, 15)); // NOI18N
        jLabel3.setText("Người tạo phiếu");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        txtNguoiTao.setEditable(false);
        txtNguoiTao.setFont(new java.awt.Font("SF Pro Display", 0, 15)); // NOI18N
        jPanel2.add(txtNguoiTao, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 390, 36));

        tblNhapHang.setFont(new java.awt.Font("SF Pro Display", 0, 15)); // NOI18N
        tblNhapHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã SP", "Tên SP", "Số lượng", "Đơn giá"
            }
        ));
        jScrollPane1.setViewportView(tblNhapHang);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 580, 350));

        btnNhapHang.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Green"));
        btnNhapHang.setFont(new java.awt.Font("SF Pro Display", 0, 15)); // NOI18N
        btnNhapHang.setForeground(new java.awt.Color(255, 255, 255));
        btnNhapHang.setText("Lưu thay đổi");
        btnNhapHang.setBorder(null);
        btnNhapHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNhapHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapHangActionPerformed(evt);
            }
        });
        jPanel2.add(btnNhapHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 590, 123, 37));

        jLabel5.setFont(new java.awt.Font("SF Pro Display", 1, 19)); // NOI18N
        jLabel5.setText("Tổng tiền:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 590, 120, 30));

        textTongTien.setFont(new java.awt.Font("SF Pro Display", 1, 19)); // NOI18N
        textTongTien.setForeground(new java.awt.Color(255, 0, 0));
        textTongTien.setText("0đ");
        jPanel2.add(textTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 590, -1, 30));

        deleteProduct.setFont(new java.awt.Font("SF Pro Display", 0, 15)); // NOI18N
        deleteProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_delete_25px_1.png"))); // NOI18N
        deleteProduct.setText("Xoá sản phẩm");
        deleteProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteProductActionPerformed(evt);
            }
        });
        jPanel2.add(deleteProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 520, 160, 40));

        jButton1.setFont(new java.awt.Font("SF Pro Display", 0, 15)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_edit_25px.png"))); // NOI18N
        jButton1.setText("Sửa số lượng");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 520, -1, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 630, 750));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tblSanPham.setFont(new java.awt.Font("SF Pro Display", 0, 15)); // NOI18N
        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã hàng", "Tên hàng", "Số lượng", "Đơn giá"
            }
        ));
        jScrollPane2.setViewportView(tblSanPham);

        jLabel4.setFont(new java.awt.Font("SF Pro Display", 0, 15)); // NOI18N
        jLabel4.setText("Số lượng");

        txtSoLuong.setFont(new java.awt.Font("SF Pro Display", 0, 15)); // NOI18N
        txtSoLuong.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSoLuong.setText("1");

        addProduct.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Green"));
        addProduct.setFont(new java.awt.Font("SF Pro Display", 0, 15)); // NOI18N
        addProduct.setForeground(new java.awt.Color(255, 255, 255));
        addProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_add_25px_5.png"))); // NOI18N
        addProduct.setText("Thêm");
        addProduct.setBorder(null);
        addProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProductActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        txtSearch.setFont(new java.awt.Font("SF Pro Display", 0, 15)); // NOI18N
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("SF Pro Display", 0, 15)); // NOI18N
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_reset_25px_1.png"))); // NOI18N
        btnReset.setText("Làm mới");
        btnReset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jLabel4)
                .addGap(32, 32, 32)
                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(addProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(128, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 750));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNhapHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapHangActionPerformed
        // TODO add your handling code here:
        if (CTPhieu.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn sản phẩm để xuất hàng !", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
        } else {
            // Set so luong san pham cua tung loai ve ban dau        
            for (var ct : CTPhieuOld) {
                HangDAO.getInstance().updateSoLuong(ct.getMaHang(), HangDAO.getInstance().selectById(ct.getMaHang()).getSoLuong() + ct.getSoLuong());
//                System.out.println(ct.getSoLuong());
            }
            for (var ct : CTPhieu) {
                HangDAO.getInstance().updateSoLuong(ct.getMaHang(), HangDAO.getInstance().selectById(ct.getMaHang()).getSoLuong() - ct.getSoLuong());
//                System.out.println(ct.getSoLuong());
            }
            // Lay thoi gian hien tai
            long now = System.currentTimeMillis();
            Timestamp sqlTimestamp = new Timestamp(now);
            // Tao doi tuong phieu nhap
            PhieuXuat pn = new PhieuXuat(phieuxuat.getMaPhieu(), sqlTimestamp, txtNguoiTao.getText(), CTPhieu, tinhTongTien());
            try {
                PhieuXuatDAO.getInstance().update(pn);
                ChiTietPhieuXuatDAO.getInstance().delete(CTPhieuOld.get(CTPhieuOld.size() - 1));
                for (var i : CTPhieu) {
                    ChiTietPhieuXuatDAO.getInstance().insert(i);
                }
                JOptionPane.showMessageDialog(this, "Cập nhật thành công !");
                this.parent.loadDataToTable();
                this.dispose();
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(this, "Đã xảy ra lỗi !");
            }
        }
    }//GEN-LAST:event_btnNhapHangActionPerformed

    private void deleteProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteProductActionPerformed
        // TODO add your handling code here:
        int i_row = tblNhapHang.getSelectedRow();
        if (i_row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm để xoá khỏi bảng nhập hàng !");
        } else {
            CTPhieu.remove(i_row);
            textTongTien.setText(formatter.format(tinhTongTien()) + "đ");           
            loadDataToTableXuatHang();
//            System.out.println("Da xoa load");
        }
    }//GEN-LAST:event_deleteProductActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int i_row = tblNhapHang.getSelectedRow();
        if (i_row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm để xoá sửa số lượng !");
        } else {
            String newSL = JOptionPane.showInputDialog(this, "Nhập số lượng cần thay đổi", "Thay đổi số lượng", QUESTION_MESSAGE);
            if (newSL != null) {
                int soLuong;
                try {
                    soLuong = Integer.parseInt(newSL);
                    if (soLuong > findHang(CTPhieu.get(i_row).getMaHang()).getSoLuong()) {
                        JOptionPane.showMessageDialog(this, "Số lượng không đủ !");
                    } else {
//                        System.out.println("1");
                        CTPhieu.get(i_row).setSoLuong(soLuong);
                        loadDataToTableXuatHang();
//                        System.out.println("da load doi so luong");
                        textTongTien.setText(formatter.format(tinhTongTien()) + "đ");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng ở dạng số nguyên!");
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void addProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductActionPerformed
            // TODO add your handling code here:
            try {           
                int i_row = tblSanPham.getSelectedRow();                
                if (i_row == -1) {
                    JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm để nhập hàng !");
                } else {
                    ChiTietPhieu ctp = new ChiTietPhieu();                
                    Hang mt = (Hang) SearchProduct.getInstance().searchId((String) tblSanPham.getValueAt(i_row, 0));
                    int soluongselect = allProduct.get(i_row).getSoLuong();
//                    System.out.println(soluongselect);   
                    if (soluongselect == 0) {                        
                        JOptionPane.showMessageDialog(this, "Sản phẩm đã hết hàng !");
                    } else {
                        int soluong = Integer.parseInt(txtSoLuong.getText().trim());
//                        System.out.println(soluong);   
                        if (soluongselect < soluong) {
                            JOptionPane.showMessageDialog(this, "Số lượng không đủ!");    
                        } else { 
//                            System.out.println("1");   
                             ctp = findCTPhieu((String) tblSanPham.getValueAt(i_row, 0));
//                             System.out.println(mtl + " k null");    
                            if (ctp != null)
                            {  
//                                System.out.println("1");    
//                                System.out.println((String) tblSanPham.getValueAt(i_row, 0));
//                                System.out.println(findHang((String) tblSanPham.getValueAt(i_row, 0)));    
//                                System.out.println(findHang((String) tblSanPham.getValueAt(i_row, 0)).getSoLuong());    
//                                System.out.println(mtl.getSoLuong());    
//                                System.out.println(soluong);    
                                if (findHang((String) tblSanPham.getValueAt(i_row, 0)).getSoLuong() < ctp.getSoLuong() + soluong) 
                                {
                                    JOptionPane.showMessageDialog(this, "Số lượng không đủ!");    
                                } 
                                else 
                                {                                    
                                    ctp.setSoLuong(ctp.getSoLuong() + soluong);
                                    mt.setSoLuong(soluong);
//                                    System.out.println(soluong);    
//                                    System.out.println(mtl.getSoLuong() );    
//                                    System.out.println(mtl.getSoLuong() + soluong);    
                                    textTongTien.setText(formatter.format(tinhTongTien()) + "đ");
                                }
                            } 
                            else 
                            {
//                                System.out.println("hang:");                                    
                                System.err.println("hang can tim: " + mt);    
                                ctp = new ChiTietPhieu(phieuxuat.getMaPhieu(), mt.getMaHang(), soluong, mt.getGia());
//                                System.out.println(ctp);    
                                CTPhieu.add(ctp);
                            }                                                        
                        }
                    }
                    loadDataToTableXuatHang();            
                    loadDataToTableProduct(updateProductQuantityInList(allProduct, mt));
                }
//                System.out.println(CTPhieu);
                
            
//            System.out.println("load chi tiet phieu");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.toString());
        }
        
    }//GEN-LAST:event_addProductActionPerformed

    public ArrayList<Hang> updateProductQuantityInList(ArrayList<Hang> allProduct, Hang product) {
        // Kiểm tra đầu vào cơ bản
        if (allProduct == null || product == null || product.getMaHang() == null) {
            System.err.println(allProduct);
            System.err.println(product);
            System.err.println("Lỗi: Danh sách sản phẩm hoặc sản phẩm đầu vào không hợp lệ.");
            return allProduct; // Trả về danh sách gốc
        }

        String productIdToUpdate = product.getMaHang();
        int quantityToSubtract = product.getSoLuong(); // Số lượng cần trừ đi
        boolean found = false;

        // Duyệt qua danh sách
        for (Hang existingHang : allProduct) {
            // Kiểm tra null và so sánh mã hàng (ID)
            if (existingHang != null && existingHang.getMaHang() != null && existingHang.getMaHang().equals(productIdToUpdate)) {
                int currentQuantity = existingHang.getSoLuong(); // Lấy số lượng hiện tại

                // Kiểm tra xem có đủ số lượng để trừ hay không
                if (currentQuantity >= quantityToSubtract) {
                    int newQuantity = currentQuantity - quantityToSubtract; // Tính số lượng mới
                    existingHang.setSoLuong(newQuantity); // Cập nhật số lượng cho đối tượng Hang hiện có trong list
                    found = true;
                    System.out.println("Đã cập nhật số lượng sản phẩm có mã: " + productIdToUpdate + ". Số lượng mới: " + newQuantity);
                } else {
                    // Xử lý trường hợp không đủ số lượng
                    System.err.println("Lỗi: Không đủ số lượng tồn kho cho sản phẩm mã: " + productIdToUpdate +
                                       ". Hiện có: " + currentQuantity + ", Cần trừ: " + quantityToSubtract);
                    found = true; // Đã tìm thấy nhưng không thể cập nhật do thiếu hàng
                }

                // Giả sử mã hàng là duy nhất, thoát vòng lặp sau khi xử lý
                break;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy sản phẩm có mã: " + productIdToUpdate + " để cập nhật số lượng.");
        }

        // Trả về danh sách (các đối tượng bên trong có thể đã bị thay đổi)
        return allProduct;
    }
    
    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        DefaultTableModel tblsp = (DefaultTableModel) tblSanPham.getModel();
        String textSearch = txtSearch.getText().toLowerCase();
        ArrayList<Hang> Mtkq = new ArrayList<>();
        for (Hang i : allProduct) {
            if (i.getMaHang().concat(i.getTenHang()).toLowerCase().contains(textSearch)) {
                Mtkq.add(i);
            }
        }
        loadDataToTableProduct(Mtkq);
    }//GEN-LAST:event_txtSearchKeyReleased

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        txtSearch.setText("");
        loadDataToTableProduct(allProduct);
    }//GEN-LAST:event_btnResetActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(new FlatLightLaf());
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UpdatePhieuXuat dialog = new UpdatePhieuXuat(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public void setNguoiTao(String name) {
        txtNguoiTao.setText(name);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addProduct;
    private javax.swing.JButton btnNhapHang;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton deleteProduct;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblNhapHang;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JLabel textTongTien;
    private javax.swing.JTextField txtMaPhieu;
    private javax.swing.JTextField txtNguoiTao;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSoLuong;
    // End of variables declaration//GEN-END:variables
}
