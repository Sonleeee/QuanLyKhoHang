/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import controller.SearchProduct;
import controller.WritePDF;
import dao.AccountDAO;
import dao.ChiTietPhieuNhapDAO;
import dao.HangDAO;
import dao.NhaCungCapDAO;
import dao.PhieuNhapDAO;
import dao.PhieuXuatDAO;
import java.awt.Desktop;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.QUESTION_MESSAGE;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import model.Account;
import model.ChiTietPhieu;
import model.Hang;
import model.NhaCungCap;
import model.Phieu;
import model.PhieuNhap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class NhapHangForm extends javax.swing.JInternalFrame {

    /**
     * Creates new form NhapHang
     */
    private DefaultTableModel tblModel;
    DecimalFormat formatter = new DecimalFormat("###,###,###");
    private ArrayList<Hang> allProduct;
    private String MaPhieu;
    private ArrayList<ChiTietPhieu> CTPhieu;
    private static final ArrayList<NhaCungCap> arrNcc = NhaCungCapDAO.getInstance().selectAll();

    public NhapHangForm() {
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        initComponents();
        allProduct = HangDAO.getInstance().selectAllExist();
        initTable();
        loadDataToTableProduct(allProduct);
        loadNccToComboBox();
        tblSanPham.setDefaultEditor(Object.class, null);
        tblNhapHang.setDefaultEditor(Object.class, null);
        MaPhieu = createId(PhieuNhapDAO.getInstance().selectAll());
        txtMaPhieu.setText(MaPhieu);
        CTPhieu = new ArrayList<ChiTietPhieu>();
    }

    private void loadNccToComboBox() {
        for (NhaCungCap i : arrNcc) {
            cboNhaCungCap.addItem(i.getTenNhaCungCap());           
        }
    }

    public final void initTable() {
        tblModel = new DefaultTableModel();
        String[] headerTbl = new String[]{"Mã", "Tên sản phẩm", "Số lượng", "Đơn giá"};
        tblModel.setColumnIdentifiers(headerTbl);
        tblSanPham.setModel(tblModel);
        tblSanPham.getColumnModel().getColumn(0).setPreferredWidth(5);
        tblSanPham.getColumnModel().getColumn(1).setPreferredWidth(200);
        tblSanPham.getColumnModel().getColumn(2).setPreferredWidth(5);
        tblNhapHang.getColumnModel().getColumn(0).setPreferredWidth(5);
        tblNhapHang.getColumnModel().getColumn(1).setPreferredWidth(30);
        tblNhapHang.getColumnModel().getColumn(2).setPreferredWidth(250);
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
        for (var i : CTPhieu) {
            if (maHang.equals(i.getMaHang())) {
                return i;
            }
        }
        return null;
    }

    public void loadDataToTableNhapHang() {
        double sum = 0;
        try {
            DefaultTableModel tblNhapHangmd = (DefaultTableModel) tblNhapHang.getModel();
            tblNhapHangmd.setRowCount(0);

            for (int i = 0; i < CTPhieu.size(); i++) {
                tblNhapHangmd.addRow(new Object[]{
                    i + 1, CTPhieu.get(i).getMaHang(), findHang(CTPhieu.get(i).getMaHang()).getTenHang(), CTPhieu.get(i).getSoLuong(), formatter.format(CTPhieu.get(i).getDonGia()) + "đ"
                });
                sum += CTPhieu.get(i).getDonGia() * CTPhieu.get(i).getSoLuong();
            }
        } catch (Exception e) {
        }
        textTongTien.setText(formatter.format(sum) + "đ");
    }

    public void setNguoiNhapHang(String name) {
        txtNguoiTao.setText(name);
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
        jLabel2 = new javax.swing.JLabel();
        cboNhaCungCap = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtNguoiTao = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhapHang = new javax.swing.JTable();
        btnNhapHang = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        textTongTien = new javax.swing.JLabel();
        deleteProduct = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        importChiTietPhieuActionPerformed = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        addProduct = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        txtSearch = new javax.swing.JTextField();
        btnReset = new javax.swing.JButton();

        setBorder(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Mã phiếu nhập");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        txtMaPhieu.setEditable(false);
        txtMaPhieu.setEnabled(false);
        txtMaPhieu.setFocusable(false);
        jPanel2.add(txtMaPhieu, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 390, 36));

        jLabel2.setText("Nhà cung cấp");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jPanel2.add(cboNhaCungCap, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 390, 36));

        jLabel3.setText("Người tạo phiếu");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        txtNguoiTao.setEditable(false);
        jPanel2.add(txtNguoiTao, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 390, 36));

        tblNhapHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã SP", "Tên SP", "Số lượng", "Đơn giá"
            }
        ));
        jScrollPane1.setViewportView(tblNhapHang);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 580, 400));

        btnNhapHang.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Green"));
        btnNhapHang.setForeground(new java.awt.Color(255, 255, 255));
        btnNhapHang.setText("Nhập hàng");
        btnNhapHang.setBorder(null);
        btnNhapHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNhapHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapHangActionPerformed(evt);
            }
        });
        jPanel2.add(btnNhapHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 690, 123, 37));

        jLabel5.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        jLabel5.setText("Tổng tiền:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 690, 120, 30));

        textTongTien.setFont(new java.awt.Font("SF Pro Display", 1, 18)); // NOI18N
        textTongTien.setForeground(new java.awt.Color(255, 0, 0));
        textTongTien.setText("0đ");
        jPanel2.add(textTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 690, 190, 30));

        deleteProduct.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_delete_25px_1.png"))); // NOI18N
        deleteProduct.setText("Xoá sản phẩm ");
        deleteProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteProductActionPerformed(evt);
            }
        });
        jPanel2.add(deleteProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 610, 160, 40));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_edit_25px.png"))); // NOI18N
        jButton1.setText("Sửa số lượng");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 610, -1, 40));

        importChiTietPhieuActionPerformed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8-microsoft-excel-2019-25.png"))); // NOI18N
        importChiTietPhieuActionPerformed.setText("Nhập excel");
        importChiTietPhieuActionPerformed.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        importChiTietPhieuActionPerformed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importChiTietPhieuActionPerformedActionPerformed(evt);
            }
        });
        jPanel2.add(importChiTietPhieuActionPerformed, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 610, -1, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 620, 750));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

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

        jLabel4.setText("Số lượng");

        txtSoLuong.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSoLuong.setText("1");

        addProduct.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Green"));
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

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

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
                .addGap(86, 86, 86)
                .addComponent(jLabel4)
                .addGap(27, 27, 27)
                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(addProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(184, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 523, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(addProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNhapHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapHangActionPerformed
        // TODO add your handling code here:
        if (CTPhieu.size() == 0) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn sản phẩm để nhập hàng !", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
        } else {
            int check = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn nhập hàng ?", "Xác nhận nhập hàng", JOptionPane.YES_NO_OPTION);
            if (check == JOptionPane.YES_OPTION) {
                // Lay thoi gian hien tai
                long now = System.currentTimeMillis();
                Timestamp sqlTimestamp = new Timestamp(now);
                // Tao doi tuong phieu nhap
                PhieuNhap pn = new PhieuNhap(arrNcc.get(cboNhaCungCap.getSelectedIndex()).getMaNhaCungCap(), MaPhieu, sqlTimestamp, txtNguoiTao.getText(), CTPhieu, tinhTongTien());
                try {
                    PhieuNhapDAO.getInstance().insert(pn);
                    HangDAO mtdao = HangDAO.getInstance();
                    for (var i : CTPhieu) {
                        ChiTietPhieuNhapDAO.getInstance().insert(i);
                        mtdao.updateSoLuong(i.getMaHang(), mtdao.selectById(i.getMaHang()).getSoLuong() + i.getSoLuong());
                    }
                    JOptionPane.showMessageDialog(this, "Nhập hàng thành công !");
                    int res = JOptionPane.showConfirmDialog(this, "Bạn có muốn xuất file pdf ?","",JOptionPane.YES_NO_OPTION);
                    if (res == JOptionPane.YES_OPTION) {
                        WritePDF writepdf = new WritePDF();
                        writepdf.writePhieuNhap(MaPhieu);
                    }
                    ArrayList<Hang> productUp = HangDAO.getInstance().selectAllExist();
                    txtSoLuong.setText("1");
                    loadDataToTableProduct(productUp);
                    DefaultTableModel r = (DefaultTableModel) tblNhapHang.getModel();
                    r.setRowCount(0);
                    CTPhieu = new ArrayList<>();
                    textTongTien.setText("0");
                    this.MaPhieu = createId(PhieuNhapDAO.getInstance().selectAll());
                    txtMaPhieu.setText(this.MaPhieu);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi !");
                }
            }
        }
    }//GEN-LAST:event_btnNhapHangActionPerformed

    private void addProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProductActionPerformed
        // TODO add your handling code here:
        int i_row = tblSanPham.getSelectedRow();
        if (i_row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm để nhập hàng !");
        } else {
            int soluong;
            try {
                soluong = Integer.parseInt(txtSoLuong.getText().trim());
                if (soluong > 0) {
                    System.out.println("thai");
                    ChiTietPhieu mtl = findCTPhieu((String) tblSanPham.getValueAt(i_row, 0));
                    if (mtl != null) {
                        mtl.setSoLuong(mtl.getSoLuong() + soluong);
                    } else {
                        Hang mt = (Hang) SearchProduct.getInstance().searchId((String) tblSanPham.getValueAt(i_row, 0));
                        ChiTietPhieu ctp = new ChiTietPhieu(MaPhieu, mt.getMaHang(), soluong, mt.getGia());
                        CTPhieu.add(ctp);
                    }
                    loadDataToTableNhapHang();
                    textTongTien.setText(formatter.format(tinhTongTien()) + "đ");
                } else {
                    JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng lớn hơn 0");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng ở dạng số nguyên!");
            }
        }
    }//GEN-LAST:event_addProductActionPerformed

    private void deleteProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteProductActionPerformed
        // TODO add your handling code here:
        int i_row = tblNhapHang.getSelectedRow();
        if (i_row == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm để xoá khỏi bảng nhập hàng !");
        } else {
            CTPhieu.remove(i_row);
            loadDataToTableNhapHang();
            textTongTien.setText(formatter.format(tinhTongTien()) + "đ");
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
                    if (soLuong > 0) {
                        CTPhieu.get(i_row).setSoLuong(soLuong);
                        loadDataToTableNhapHang();
                        textTongTien.setText(formatter.format(tinhTongTien()) + "đ");
                    } else {
                        JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng lớn hơn 0");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Vui lòng nhập số lượng ở dạng số nguyên!");
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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

    private void importChiTietPhieuActionPerformedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importChiTietPhieuActionPerformedActionPerformed
        // TODO add your handling code here:
       File excelFile = null;
    FileInputStream excelFIS = null;
    BufferedInputStream excelBIS = null;
    Workbook excelWorkbook = null; // Sử dụng Workbook interface
    // ArrayList<ChiTietPhieu> listAccExcel = new ArrayList<ChiTietPhieu>(); // Biến này không được sử dụng

    JFileChooser jf = new JFileChooser();
    jf.setDialogTitle("Chọn file Excel (Tên SP, Số Lượng)"); // Chỉ cần 2 cột này
    javax.swing.filechooser.FileNameExtensionFilter filter = new javax.swing.filechooser.FileNameExtensionFilter("Excel Files (*.xlsx)", "xlsx");
    jf.setFileFilter(filter);
    jf.setAcceptAllFileFilterUsed(false);

    int result = jf.showOpenDialog(this);

    if (result == JFileChooser.APPROVE_OPTION) {
        HangDAO hangDAO = HangDAO.getInstance(); // Khởi tạo DAO
        String maPhieu = txtMaPhieu.getText(); // Lấy mã phiếu

        if (maPhieu == null || maPhieu.trim().isEmpty()) {
             JOptionPane.showMessageDialog(this, "Vui lòng nhập Mã Phiếu!", "Lỗi", JOptionPane.ERROR_MESSAGE);
             return;
        }

        int rowsSuccess = 0;
        int rowsFailed = 0;
        StringBuilder errorLog = new StringBuilder("--- Chi tiết lỗi import ---\n");

        try {
            excelFile = jf.getSelectedFile();
            excelFIS = new FileInputStream(excelFile);
            excelBIS = new BufferedInputStream(excelFIS);
            excelWorkbook = new XSSFWorkbook(excelBIS);
            Sheet excelSheet = excelWorkbook.getSheetAt(0);

            int lastRowNum = excelSheet.getLastRowNum();
            System.out.println("Bắt đầu đọc file Excel từ dòng 2 đến " + (lastRowNum + 1));

            // *** Sửa vòng lặp: Dùng <= ***
            for (int rowIndex = 1; rowIndex <= lastRowNum; rowIndex++) {
                Row excelRow = excelSheet.getRow(rowIndex);
                int currentRowForDisplay = rowIndex + 1;

                if (excelRow == null) {
                    System.out.println("Bỏ qua dòng " + currentRowForDisplay + ": Dòng trống.");
                    // Không tăng rowsFailed nếu coi dòng trống là bình thường
                    continue;
                }

                String tenSanPham = "";
                int soLuong = 0;
                // Không cần biến donGia ở đây ban đầu

                try {
                    // --- Đọc Tên Sản Phẩm (Cột A/0) ---
                    Cell tenCell = excelRow.getCell(0);
                    if (tenCell != null && tenCell.getCellType() == CellType.STRING) {
                        tenSanPham = tenCell.getStringCellValue().trim();
                    } else if (tenCell != null && tenCell.getCellType() == CellType.NUMERIC) {
                        tenSanPham = String.valueOf(tenCell.getNumericCellValue());
                    } else {
                        errorLog.append("Dòng ").append(currentRowForDisplay).append(": Tên sản phẩm (Cột A) không hợp lệ hoặc trống.\n");
                        rowsFailed++;
                        continue; // Bỏ qua dòng lỗi
                    }
                    if(tenSanPham.isEmpty()){
                        errorLog.append("Dòng ").append(currentRowForDisplay).append(": Tên sản phẩm (Cột A) không được để trống.\n");
                        rowsFailed++;
                        continue;
                    }

                    // --- Đọc Số Lượng (Cột B/1) ---
                    Cell slCell = excelRow.getCell(1);
                    if (slCell != null && slCell.getCellType() == CellType.NUMERIC) {
                        soLuong = (int) slCell.getNumericCellValue();
                        if (soLuong <= 0) {
                            errorLog.append("Dòng ").append(currentRowForDisplay).append(" (SP: ").append(tenSanPham).append("): Số lượng (Cột B) phải > 0.\n");
                            rowsFailed++;
                            continue;
                        }
                    } else {
                        errorLog.append("Dòng ").append(currentRowForDisplay).append(" (SP: ").append(tenSanPham).append("): Số lượng (Cột B) không phải số hoặc trống.\n");
                        rowsFailed++;
                        continue;
                    }

                    // --- Tìm Sản Phẩm và Lấy Đơn Giá từ DB ---
                    // *** GIẢ ĐỊNH: có phương thức getHangByTen trả về đối tượng Hang hoặc null ***
                    Hang foundHang = hangDAO.getHangByTen(tenSanPham);

                    if (foundHang == null) {
                        // Không tìm thấy sản phẩm trong DB
                        errorLog.append("Dòng ").append(currentRowForDisplay).append(": Sản phẩm '").append(tenSanPham).append("' không tồn tại trong CSDL. Đã bỏ qua.\n");
                        rowsFailed++;
                        continue; // Bỏ qua dòng này, không thêm chi tiết
                    }

                    // Nếu sản phẩm được tìm thấy
                    String maSanPham = foundHang.getMaHang(); // Giả sử Hang có getMaHang()
                    double donGia = foundHang.getGia();       // Giả sử Hang có getGia()

                    // Kiểm tra đơn giá lấy từ DB (tùy chọn)
                    if (donGia < 0) {
                         errorLog.append("Dòng ").append(currentRowForDisplay).append(": Sản phẩm '").append(tenSanPham).append("' có đơn giá âm trong CSDL (").append(donGia).append("). Đã bỏ qua.\n");
                         rowsFailed++;
                         continue; // Bỏ qua nếu giá trong DB không hợp lệ
                    }

                    // --- Tạo đối tượng ChiTietPhieu ---
                    ChiTietPhieu ctpnew = new ChiTietPhieu(maPhieu, maSanPham, soLuong, donGia);

                    // --- Thêm vào danh sách Chi Tiết Phiếu ---
                    CTPhieu.add(ctpnew); // Giả sử CTPhieu là List<ChiTietPhieu> của class
                    rowsSuccess++;
                    System.out.println("Thông tin dòng " + currentRowForDisplay + ": Đã thêm chi tiết cho SP '" + tenSanPham + "' (Mã: " + maSanPham + ", SL: " + soLuong + ", Giá DB: " + donGia + ")");

                } catch (Exception ex) {
                    // Bắt các lỗi không mong muốn khác trong quá trình xử lý dòng
                    rowsFailed++;
                    String errorMsg = "Lỗi xử lý dòng " + currentRowForDisplay + " (SP: " + tenSanPham + "): " + ex.getMessage();
                    System.err.println(errorMsg);
                    errorLog.append(errorMsg).append("\n");
                    ex.printStackTrace();
                }
            } // Kết thúc vòng lặp for

        } catch (FileNotFoundException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Không tìm thấy file Excel", ex);
             JOptionPane.showMessageDialog(this, "Lỗi: Không tìm thấy file Excel đã chọn.", "Lỗi File", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Lỗi IO khi đọc file", ex);
             JOptionPane.showMessageDialog(this, "Lỗi: Không thể đọc file Excel.", "Lỗi Đọc File", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex){
             Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Lỗi không mong muốn", ex);
             JOptionPane.showMessageDialog(this, "Lỗi không mong muốn xảy ra: " + ex.getMessage(), "Lỗi Chung", JOptionPane.ERROR_MESSAGE);
        }
        finally {
            // --- Đóng tài nguyên ---
            try {
                if (excelWorkbook != null) excelWorkbook.close();
                if (excelBIS != null) excelBIS.close();
                if (excelFIS != null) excelFIS.close();
                System.out.println("Đã đóng tài nguyên file Excel.");
            } catch (IOException ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "Lỗi khi đóng tài nguyên file Excel", ex);
            }

            // --- Thông báo kết quả ---
            String summaryMsg;
             if (rowsFailed == 0 && rowsSuccess > 0) {
                 summaryMsg = "Import hoàn tất.\nĐã thêm thành công " + rowsSuccess + " chi tiết.";
                 JOptionPane.showMessageDialog(this, summaryMsg, "Thành Công", JOptionPane.INFORMATION_MESSAGE);
             } else if (rowsSuccess > 0) {
                 summaryMsg = "Import hoàn tất với lỗi.\nThành công: " + rowsSuccess + ", Thất bại: " + rowsFailed + ".";
                  System.err.println(errorLog.toString()); // In log lỗi chi tiết ra console
                  // Hiển thị lỗi chi tiết nếu muốn
                  JTextArea textArea = new JTextArea(summaryMsg + "\n\nChi tiết lỗi:\n" + errorLog.toString());
                  JScrollPane scrollPane = new JScrollPane(textArea);
                  textArea.setLineWrap(true); textArea.setWrapStyleWord(true); textArea.setEditable(false);
                  scrollPane.setPreferredSize(new java.awt.Dimension(500, 300));
                  JOptionPane.showMessageDialog(this, scrollPane, "Kết Quả Import (Có Lỗi)", JOptionPane.WARNING_MESSAGE);
             } else if (rowsFailed > 0) {
                 summaryMsg = "Import thất bại.\nKhông có chi tiết nào được thêm (" + rowsFailed + " lỗi).";
                  System.err.println(errorLog.toString());
                  // Hiển thị lỗi chi tiết tương tự
                  JTextArea textArea = new JTextArea(summaryMsg + "\n\nChi tiết lỗi:\n" + errorLog.toString());
                  JScrollPane scrollPane = new JScrollPane(textArea);
                  textArea.setLineWrap(true); textArea.setWrapStyleWord(true); textArea.setEditable(false);
                  scrollPane.setPreferredSize(new java.awt.Dimension(500, 300));
                  JOptionPane.showMessageDialog(this, scrollPane, "Import Thất Bại", JOptionPane.ERROR_MESSAGE);
             } else { // Không có dòng nào được xử lý thành công hoặc thất bại (file trống/không hợp lệ)
                 summaryMsg = "Không có dữ liệu hợp lệ nào được xử lý từ file Excel.";
                  JOptionPane.showMessageDialog(this, summaryMsg, "Thông Báo", JOptionPane.WARNING_MESSAGE);
             }


            // --- Tải lại bảng ---
            System.out.println("Kết thúc import. Đang tải lại bảng...");
            loadDataToTableNhapHang();
             System.out.println("Đã tải lại bảng.");
        }
    } // Kết thúc if (result == JFileChooser.APPROVE_OPTION) 
    }//GEN-LAST:event_importChiTietPhieuActionPerformedActionPerformed
    

    public String createId(ArrayList<PhieuNhap> arr) {
        int id = arr.size() + 1;
        String check = "";
        for (PhieuNhap phieuNhap : arr) {
            if (phieuNhap.getMaPhieu().equals("PN" + id)) {
                check = phieuNhap.getMaPhieu();
            }
        }
        while (check.length() != 0) {
            String c = check;
            id++;
            for (int i = 0; i < arr.size(); i++) {
                if (arr.get(i).getMaPhieu().equals("PN" + id)) {
                    check = arr.get(i).getMaPhieu();
                }
            }
            if (check.equals(c)) {
                check = "";
            }
        }
        return "PN" + id;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addProduct;
    private javax.swing.JButton btnNhapHang;
    private javax.swing.JButton btnReset;
    private javax.swing.JComboBox<String> cboNhaCungCap;
    private javax.swing.JButton deleteProduct;
    private javax.swing.JButton importChiTietPhieuActionPerformed;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
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
