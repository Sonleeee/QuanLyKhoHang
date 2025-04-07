/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;
// CHUA SUA
import controller.SearchProduct;
import dao.HangDAO;
import dao.PhanLoaiDAO;
import database.JDBCUtil;
import java.awt.Desktop;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;
import model.Account;

import model.Hang;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import static view.AddProduct.generateProductCode;

/**
 *
 * @author
 */
public class ProductForm extends javax.swing.JInternalFrame {

    private DefaultTableModel tblModel;
    DecimalFormat formatter = new DecimalFormat("###,###,###");
    
    public ProductForm() {
        try {            
            initComponents();
            BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();            
            ui.setNorthPane(null);
            tblSanPham.setDefaultEditor(Object.class, null);            
            initTable();            
            loadDataToTable();
            changeTextFind();
        } catch (Exception e) {
            e.printStackTrace();  // In lỗi ra console
            System.out.println("Lỗi trong initTable: " + e.getMessage());
        }
    }
    
    public void checkRole(Account t) {
        if(t.getRole().equals("Nhân viên nhập") || t.getRole().equals("Nhân viên xuất")) {
            btnAdd.setEnabled(false);
            btnDelete.setEnabled(false);
            btnEdit.setEnabled(false);
            jButton6.setEnabled(false);
            jButton2.setEnabled(false);
        } else {
            System.out.println("abcdjad");
        }
    }

    public final void initTable() {
        tblModel = new DefaultTableModel();
        String[] headerTbl = new String[]{"STT","Mã", "Loại", "Tên", "Đơn giá", "Trạng thái"};
        tblModel.setColumnIdentifiers(headerTbl);
        tblSanPham.setModel(tblModel);
        tblSanPham.getColumnModel().getColumn(0).setPreferredWidth(5);  
        tblSanPham.getColumnModel().getColumn(1).setPreferredWidth(5);
        tblSanPham.getColumnModel().getColumn(2).setPreferredWidth(5);
        tblSanPham.getColumnModel().getColumn(3).setPreferredWidth(200);
        tblSanPham.getColumnModel().getColumn(4).setPreferredWidth(5);
        tblSanPham.getColumnModel().getColumn(5).setPreferredWidth(5);          
    }
    

    public void loadDataToTable() {
        try {
            HangDAO hangdao = new HangDAO();
            ArrayList<Hang> armt = hangdao.selectAll();
            tblModel.setRowCount(0);
            int stt=0;
            for (Hang i : armt) {       
                String trangThaiStr = (i.getTrangThai() == 1) ? "Hoạt động" : "Không hoạt động";
                tblModel.addRow(new Object[]{
                       ++stt , 
                        i.getMaHang(),
                        i.getTenPhanLoai(),
                        i.getTenHang(),                     
                        formatter.format(i.getGia()) + "đ",
                        trangThaiStr
                    });
            }
        } catch (Exception e) {
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
        jToolBar1 = new javax.swing.JToolBar();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        jButton6 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jComboBoxLuaChon = new javax.swing.JComboBox<>();
        jTextFieldSearch = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();

        setBorder(null);
        setTitle("Phần mềm quản lí kho hàng");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jToolBar1.setBackground(new java.awt.Color(255, 255, 255));
        jToolBar1.setBorder(javax.swing.BorderFactory.createTitledBorder("Chức năng"));
        jToolBar1.setRollover(true);

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_add_40px.png"))); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAdd);

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_delete_40px.png"))); // NOI18N
        btnDelete.setText("Xoá");
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDelete.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jToolBar1.add(btnDelete);

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_edit_40px.png"))); // NOI18N
        btnEdit.setText("Sửa");
        btnEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEdit.setFocusable(false);
        btnEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEdit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jToolBar1.add(btnEdit);
        jToolBar1.add(jSeparator1);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_spreadsheet_file_40px.png"))); // NOI18N
        jButton6.setText("Xuất Excel");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton6);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_xls_40px.png"))); // NOI18N
        jButton2.setText("Nhập Excel");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBoxLuaChon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Mã", "Loại", "Tên", "Số lượng", "Đơn giá" }));
        jComboBoxLuaChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxLuaChonActionPerformed(evt);
            }
        });
        jComboBoxLuaChon.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jComboBoxLuaChonPropertyChange(evt);
            }
        });
        jPanel3.add(jComboBoxLuaChon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 150, 40));

        jTextFieldSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldSearchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldSearchKeyReleased(evt);
            }
        });
        jPanel3.add(jTextFieldSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 360, 40));

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_reset_25px_1.png"))); // NOI18N
        jButton7.setText("Làm mới");
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 30, 140, 40));

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblSanPham);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1168, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1180, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        if (tblSanPham.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm cần xoá");
        } else {
            xoaHangSelect();
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        if (tblSanPham.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm cần sửa");
        } 
        else{
            Hang selectedHang = getHangSelect();
            if (selectedHang == null) {
                   JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm!");
                   return;
            }
            UpdateProduct a = new UpdateProduct(this, (JFrame) javax.swing.SwingUtilities.getWindowAncestor(this), rootPaneCheckingEnabled);
            a.setVisible(true);
        }
        
        
    }//GEN-LAST:event_btnEditActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        try {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.showSaveDialog(this);
            File saveFile = jFileChooser.getSelectedFile();
            if (saveFile != null) {
                saveFile = new File(saveFile.toString() + ".xlsx");
                Workbook wb = new XSSFWorkbook();
                Sheet sheet = wb.createSheet("Product");

                Row rowCol = sheet.createRow(0);
                for (int i = 0; i < tblSanPham.getColumnCount(); i++) {
                    Cell cell = rowCol.createCell(i);
                    cell.setCellValue(tblSanPham.getColumnName(i));
                }

                for (int j = 0; j < tblSanPham.getRowCount(); j++) {
                    Row row = sheet.createRow(j + 1);
                    for (int k = 0; k < tblSanPham.getColumnCount(); k++) {
                        Cell cell = row.createCell(k);
                        if (tblSanPham.getValueAt(j, k) != null) {
                            cell.setCellValue(tblSanPham.getValueAt(j, k).toString());
                        }

                    }
                }
                FileOutputStream out = new FileOutputStream(new File(saveFile.toString()));
                wb.write(out);
                wb.close();
                out.close();
                openFile(saveFile.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         File excelFile = null;
         JFileChooser jf = new JFileChooser();
        jf.setDialogTitle("Chọn file Excel để nhập (*.xlsx)");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel Files (*.xlsx)", "xlsx");
        jf.setFileFilter(filter);
        jf.setAcceptAllFileFilterUsed(false);

        int result = jf.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            int rowsProcessed = 0;
            int rowsSuccess = 0;
            int rowsFailed = 0;
            StringBuilder errorDetails = new StringBuilder(); // Lưu chi tiết lỗi từng dòng

            excelFile = jf.getSelectedFile();

            // Sử dụng try-with-resources cho streams
            try (FileInputStream excelFIS = new FileInputStream(excelFile);
                 BufferedInputStream excelBIS = new BufferedInputStream(excelFIS);
                 XSSFWorkbook excelWorkbook = new XSSFWorkbook(excelBIS))
            {
                XSSFSheet excelSheet = excelWorkbook.getSheetAt(0);
                PhanLoaiDAO phanLoaiDAO = new PhanLoaiDAO(); // Tạo DAO một lần
                HangDAO hangDAO = HangDAO.getInstance();   // Lấy instance DAO Hàng
                
                
                for (int row = 1; row <= excelSheet.getLastRowNum(); row++) {
                    XSSFRow excelRow = excelSheet.getRow(row);
                    String loaiCheck = getCellValueAsString(excelRow.getCell(0)).trim();
                    String tenCheck = getCellValueAsString(excelRow.getCell(1)).trim();

                    if (loaiCheck.isEmpty() && tenCheck.isEmpty()) {
                        // Nếu cả cột Loại và Tên đều trống, coi như hết dữ liệu hữu ích
                        System.out.println("Dừng đọc tại dòng " + (row + 1) + " (Cả cột Loại và Tên đều trống).");
                        break; // Dừng hoàn toàn vòng lặp
                    }
                    
                      // --- KIỂM TRA SỰ TỒN TẠI TRONG DB ---
                    if (hangDAO.kiemTraTonTaiTheoTen(tenCheck)) { // Hoặc kiemTraTonTaiTheoTenVaLoai(tenHang, idloai)
                        // Nếu đã tồn tại, ghi log/thông báo và bỏ qua dòng này
                        String skipMsg = "Sản phẩm '" + tenCheck + "' đã tồn tại trong hệ thống.";
                        System.out.println(skipMsg);
                        errorDetails.append(skipMsg).append(" (Đã bỏ qua)\n"); // Thêm vào chi tiết lỗi để người dùng biết
                        rowsFailed++; // Coi như đây là một dòng "thất bại" trong việc thêm mới
                        continue; // Chuyển sang xử lý dòng Excel tiếp theo
                    }                    
                    rowsProcessed++;
                    if (excelRow == null) {
                        System.out.println("Bỏ qua dòng Excel trống: " + (row + 1));
                        continue; // Bỏ qua dòng hoàn toàn trống
                    }

                    String tenHang = ""; // Khởi tạo để dùng trong log lỗi
                    String loai = "";    // Khởi tạo để dùng trong log lỗi
                    int currentExcelRow = row + 1; // Số dòng hiển thị cho người dùng

                    try {
                        // --- Đọc dữ liệu từ Excel ---
                        loai = getCellValueAsString(excelRow.getCell(0)).trim(); // Cột A - Loại
                        tenHang = getCellValueAsString(excelRow.getCell(1)).trim(); // Cột B - Tên sản phẩm
                        int soLuong = getCellValueAsInt(excelRow.getCell(2)); // Cột C - Số lượng
                        double gia = getCellValueAsDouble(excelRow.getCell(3)); // Cột D - Đơn giá
                        String xuatsu = getCellValueAsString(excelRow.getCell(4)).trim(); // Cột E - NCC
                        int trangThai = 1; // Mặc định trạng thái

                        // --- Kiểm tra dữ liệu cơ bản ---
                        if (loai.isEmpty()) {
                            throw new IllegalArgumentException("Tên loại hàng không được để trống.");
                        }
                         if (tenHang.isEmpty()) {
                             throw new IllegalArgumentException("Tên sản phẩm không được để trống.");
                         }
                         if (soLuong < 0) {
                             throw new IllegalArgumentException("Số lượng không được âm.");
                         }
                          if (gia < 0) {
                             throw new IllegalArgumentException("Giá không được âm.");
                         }

                        // --- Lấy ID loại và KIỂM TRA ---
                        // *** GIẢ SỬ: getIdByTenPhanLoai trả về 0 hoặc số âm nếu không tìm thấy ***
                        int idloai = phanLoaiDAO.getIdByTenPhanLoai(loai);

                        if (idloai <= 0) { // Hoặc điều kiện kiểm tra lỗi phù hợp với DAO của bạn
                            throw new Exception("Không tìm thấy loại hàng '" + loai + "' trong cơ sở dữ liệu.");
                        }

                        // --- Tạo mã hàng và đối tượng Hang ---
                        String maHang = generateProductCode(); // Đảm bảo hàm này tạo mã duy nhất
                        Hang hang = new Hang(maHang, tenHang, soLuong, gia, xuatsu, trangThai, idloai);

                        // --- Thêm vào DB (KHÔNG dùng transaction) ---
                        // Giả sử HangDAO.insert tự quản lý Connection (mở và đóng cho mỗi lần gọi)
                        hangDAO.insert(hang); // Gọi phương thức insert bình thường của DAO

                        rowsSuccess++; // Tăng biến đếm thành công

                    } catch (Exception ex) { // Bắt tất cả lỗi liên quan đến dòng này (bao gồm lỗi tìm ID, lỗi SQL từ DAO.insert,...)
                        rowsFailed++;
                        String errorMsg = "Lỗi ở dòng Excel " + currentExcelRow + " (Tên SP: '" + tenHang + "', Loại: '" + loai + "'): " + ex.getMessage();
                        System.err.println(errorMsg);
                        // Ghi lại stack trace vào log nếu cần chi tiết hơn
                        // Logger.getLogger(ProductForm.class.getName()).log(Level.WARNING, "Lỗi xử lý dòng Excel " + currentExcelRow, ex);
                        errorDetails.append(errorMsg).append("\n");
                        // Tiếp tục xử lý dòng tiếp theo
                    }
                } // Kết thúc vòng lặp for

            // --- Thông báo kết quả ---
            String summaryMsg;
            int messageType;
            if (rowsFailed == 0 && rowsProcessed > 0) {
                summaryMsg = "Nhập liệu hoàn tất.\nĐã thêm thành công " + rowsSuccess + " sản phẩm.";
                messageType = JOptionPane.INFORMATION_MESSAGE;
            } else if (rowsSuccess > 0) {
                 summaryMsg = "Nhập liệu hoàn tất với một số lỗi.\n"
                             + "Thành công: " + rowsSuccess + "/" + rowsProcessed + " dòng.\n"
                             + "Thất bại: " + rowsFailed + "/" + rowsProcessed + " dòng.\n\n"
                             + "Chi tiết lỗi:\n" + errorDetails.toString();
                 messageType = JOptionPane.WARNING_MESSAGE;
            } else if (rowsProcessed > 0){ // Tất cả đều lỗi
                 summaryMsg = "Nhập liệu thất bại.\n"
                             + "Không có sản phẩm nào được thêm.\n"
                             + "Thất bại: " + rowsFailed + "/" + rowsProcessed + " dòng.\n\n"
                             + "Chi tiết lỗi:\n" + errorDetails.toString();
                  messageType = JOptionPane.ERROR_MESSAGE;
            } else {
                 summaryMsg = "Không tìm thấy dữ liệu hợp lệ để nhập trong file Excel.";
                 messageType = JOptionPane.WARNING_MESSAGE;
            }

            // Hiển thị lỗi trong JTextArea nếu quá dài
             if (errorDetails.length() > 0 && (summaryMsg.length() > 500 || errorDetails.length() > 300)) {
                 JTextArea textArea = new JTextArea(summaryMsg);
                 JScrollPane scrollPane = new JScrollPane(textArea);
                 textArea.setLineWrap(true);
                 textArea.setWrapStyleWord(true);
                 textArea.setEditable(false);
                 scrollPane.setPreferredSize(new java.awt.Dimension(500, 300));
                 JOptionPane.showMessageDialog(this, scrollPane, "Kết Quả Nhập Liệu", messageType);
             } else {
                JOptionPane.showMessageDialog(this, summaryMsg, "Kết Quả Nhập Liệu", messageType);
             }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ProductForm.class.getName()).log(Level.SEVERE, "Không tìm thấy file Excel: " + (excelFile != null ? excelFile.getAbsolutePath() : "null"), ex);
            JOptionPane.showMessageDialog(this, "Lỗi: Không tìm thấy file Excel đã chọn.\n" + ex.getMessage(), "Lỗi File", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            Logger.getLogger(ProductForm.class.getName()).log(Level.SEVERE, "Lỗi đọc file Excel: " + (excelFile != null ? excelFile.getAbsolutePath() : "null"), ex);
            JOptionPane.showMessageDialog(this, "Lỗi: Không thể đọc file Excel.\n" + ex.getMessage(), "Lỗi Đọc File", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) { // Bắt các lỗi không mong muốn khác (ví dụ lỗi khởi tạo DAO)
            Logger.getLogger(ProductForm.class.getName()).log(Level.SEVERE, "Lỗi không mong muốn.", ex);
            JOptionPane.showMessageDialog(this, "Lỗi không mong muốn xảy ra:\n" + ex.getMessage(), "Lỗi Chung", JOptionPane.ERROR_MESSAGE);
        } finally {
             // Không cần đóng connection ở đây nữa vì không quản lý transaction
        }

        // Luôn tải lại bảng để hiển thị kết quả (kể cả khi chỉ thêm được một phần)
        // Bạn có thể thêm điều kiện if (rowsSuccess > 0) nếu chỉ muốn load lại khi có ít nhất 1 thành công
        System.out.println("Quá trình nhập liệu kết thúc, đang tải lại bảng...");
        loadDataToTable();
        System.out.println("Tải lại bảng hoàn tất.");
    }
             // Kết thúc if (result == JFileChooser.APPROVE_OPTION)
    }//GEN-LAST:event_jButton2ActionPerformed

    private double getCellValueAsDouble(Cell cell) {
        if (cell == null) {
            return 0.0;
        }

         CellType cellType = cell.getCellType();
         if (cellType == CellType.FORMULA) {
            cellType = cell.getCachedFormulaResultType();
        }

        switch (cellType) {
            case NUMERIC:
                return cell.getNumericCellValue();

            case STRING:
                String strValue = cell.getStringCellValue().trim();
                 if (strValue.isEmpty()) {
                    return 0.0; // Chuỗi rỗng coi là 0.0
                }
                try {
                    // Thay thế dấu phẩy bằng dấu chấm để chuẩn hóa trước khi parse
                    return Double.parseDouble(strValue.replace(',', '.'));
                } catch (NumberFormatException e) {
                    System.err.println("Lỗi: Không thể chuyển đổi chuỗi '" + strValue + "' thành số thực tại ô " + cell.getAddress().formatAsString());
                    return 0.0; // Trả về 0.0 nếu không chuyển đổi được
                }
            case BLANK:
            default:
                return 0.0; // Trả về 0.0 cho các trường hợp còn lại
        }
    }

    private String getCellValueAsString(Cell cell) {
    if (cell == null) {
        return ""; // Trả về rỗng nếu ô không tồn tại
    }

    CellType cellType = cell.getCellType();
    // Nếu là công thức, lấy kiểu dữ liệu của kết quả công thức
    if (cellType == CellType.FORMULA) {
        cellType = cell.getCachedFormulaResultType();
    }

    switch (cellType) {
        case STRING:
            return cell.getStringCellValue().trim(); // Lấy chuỗi và cắt khoảng trắng thừa

        case NUMERIC:
            // Kiểm tra xem có phải là định dạng ngày tháng không
            if (DateUtil.isCellDateFormatted(cell)) {
                // Xử lý định dạng ngày tháng
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); // Hoặc định dạng bạn muốn
                return dateFormat.format(cell.getDateCellValue());
            } else {
                // Xử lý số, tránh hiển thị dạng khoa học (E) và ".0" cho số nguyên
                double numValue = cell.getNumericCellValue();
                // Sử dụng DecimalFormat để tránh dạng khoa học và kiểm soát số thập phân
                // Định dạng này sẽ hiển thị tối đa 10 chữ số thập phân nếu có
                DecimalFormat df = new DecimalFormat("#.##########");
                return df.format(numValue);
                /* // Cách khác đơn giản hơn nếu không cần kiểm soát số thập phân nhiều:
                 if (numValue == Math.floor(numValue) && !Double.isInfinite(numValue)) {
                     // Là số nguyên
                     return String.valueOf((long) numValue);
                 } else {
                     // Là số thực
                     return String.valueOf(numValue);
                 }
                 */
            }

        case BOOLEAN:
            return String.valueOf(cell.getBooleanCellValue());

        case BLANK:
            return ""; // Trả về rỗng nếu ô trống

        case ERROR:
            return "ERROR:" + cell.getErrorCellValue(); // Trả về mã lỗi

        default:
            return ""; // Trường hợp khác trả về rỗng
    }
}

    
   private int getCellValueAsInt(Cell cell) {
    if (cell == null) {
        return 0;
    }

    CellType cellType = cell.getCellType();
     if (cellType == CellType.FORMULA) {
        cellType = cell.getCachedFormulaResultType();
    }

    switch (cellType) {
        case NUMERIC:
             // Lấy giá trị số và làm tròn (hoặc ép kiểu nếu chắc chắn là nguyên)
             double numValue = cell.getNumericCellValue();
             // Kiểm tra xem có phải là số nguyên không để tránh mất mát dữ liệu khi ép kiểu
             if (numValue >= Integer.MIN_VALUE && numValue <= Integer.MAX_VALUE && numValue == Math.floor(numValue)) {
                 return (int) numValue;
             } else {
                  System.err.println("Cảnh báo: Giá trị số " + numValue + " tại ô " + cell.getAddress().formatAsString() + " không phải là số nguyên hoặc nằm ngoài phạm vi int. Làm tròn và trả về.");
                  // Có thể ném lỗi ở đây nếu cần chặt chẽ hơn
                  // throw new NumberFormatException("Giá trị không phải số nguyên hợp lệ tại ô " + cell.getAddress().formatAsString());
                 return (int) Math.round(numValue); // Hoặc trả về 0, hoặc ném lỗi tùy yêu cầu
             }

        case STRING:
            String strValue = cell.getStringCellValue().trim();
            if (strValue.isEmpty()) {
                return 0; // Chuỗi rỗng coi là 0
            }
            try {
                 // Thử chuyển đổi chuỗi thành double trước để xử lý trường hợp "123.0"
                 double dValue = Double.parseDouble(strValue);
                 // Kiểm tra lại phạm vi và tính nguyên vẹn
                 if (dValue >= Integer.MIN_VALUE && dValue <= Integer.MAX_VALUE && dValue == Math.floor(dValue)) {
                      return (int) dValue;
                 } else {
                      System.err.println("Cảnh báo: Chuỗi '" + strValue + "' tại ô " + cell.getAddress().formatAsString() + " không biểu diễn số nguyên hợp lệ hoặc ngoài phạm vi int.");
                      // Ném lỗi hoặc trả về giá trị mặc định
                     return 0; // Hoặc (int) Math.round(dValue) nếu muốn làm tròn
                 }
            } catch (NumberFormatException e) {
                 System.err.println("Lỗi: Không thể chuyển đổi chuỗi '" + strValue + "' thành số nguyên tại ô " + cell.getAddress().formatAsString());
                return 0; // Trả về 0 nếu không chuyển đổi được
            }
        case BLANK:
        default:
            return 0; // Trả về 0 cho các trường hợp còn lại
    }
}

    // Hàm chuyển đổi giá tiền từ chuỗi sang số
    private static double parsePrice(String price) {
        if (price == null || price.isEmpty()) return 0;
        price = price.replace(".", "").replace("đ", "").trim(); // Xóa dấu . và ký tự đ
        try {
            return Double.parseDouble(price);
        } catch (NumberFormatException e) {
            return 0; // Nếu có lỗi thì trả về 0
        }
    }
    
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        jComboBoxLuaChon.setSelectedIndex(0);
        loadDataToTable();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTextFieldSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchKeyReleased
        // TODO add your handling code here:
        String luaChon = jComboBoxLuaChon.getSelectedItem().toString();
        String content = jTextFieldSearch.getText();
        ArrayList<Hang> result = searchFn(luaChon, content);
        loadDataToTableSearch(result);
    }//GEN-LAST:event_jTextFieldSearchKeyReleased

    private void jComboBoxLuaChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxLuaChonActionPerformed
        // TODO add your handling code here:
        String luaChon = jComboBoxLuaChon.getSelectedItem().toString();
        String content = jTextFieldSearch.getText();
        ArrayList<Hang> result = searchFn(luaChon, content);
        loadDataToTableSearch(result);
    }//GEN-LAST:event_jComboBoxLuaChonActionPerformed

    private void jTextFieldSearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldSearchKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_jTextFieldSearchKeyPressed

    private void jComboBoxLuaChonPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jComboBoxLuaChonPropertyChange
//         TODO add your handling code here:
        String luaChon = jComboBoxLuaChon.getSelectedItem().toString();
        String content = jTextFieldSearch.getText();
        ArrayList<Hang> result = searchFn(luaChon, content);
        loadDataToTableSearch(result);
    }//GEN-LAST:event_jComboBoxLuaChonPropertyChange

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        AddProduct a = new AddProduct(this, (JFrame) javax.swing.SwingUtilities.getWindowAncestor(this), rootPaneCheckingEnabled);
        a.setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed
//Tất cả, Mã, Loại, Tên, Số lượng, Đơn giá
    public ArrayList<Hang> searchFn(String luaChon, String content) {
        ArrayList<Hang> result = new ArrayList<>();
        SearchProduct searchPr = new SearchProduct();
        switch (luaChon) {
            case "Tất cả":
                result = searchPr.searchTatCa(content);
                break;
            case "Mã":
                result = searchPr.searchMaHang(content);
                break;
            case "Loại":
                int idLoai = PhanLoaiDAO.getIdByTenPhanLoai(content);
                if (idLoai != -1) {
                    result = searchPr.searchLoai(idLoai);
                }
                break;
            case "Tên":
                result = searchPr.searchTenHang(content);
                break;
            case "Đơn giá":
                result = searchPr.searchDonGia(content);
                break;
            case "Số lượng":
                result = searchPr.searchSoLuong(content);
                break;            
            case "Xuất xứ":
                result = searchPr.searchXuatXu(content);
                break;
        }
        return result;
    }


    public Hang getDetailHang() {
        Hang selectedHang = getHangSelect(); // Lấy sản phẩm được chọn
        if (selectedHang == null) {
            JOptionPane.showMessageDialog(this, "Không tìm thấy sản phẩm cần sửa!");
            return null;
        }
        return selectedHang;
    }
    public void xoaHangSelect() {
        System.out.println("Xóa hàng được gọi");
        DefaultTableModel table_acc = (DefaultTableModel) tblSanPham.getModel();
        int i_row = tblSanPham.getSelectedRow();
        int luaChon = JOptionPane.showConfirmDialog(this, "Bạn có muốn xoá sản phẩm này?", "Xoá sản phẩm",
                JOptionPane.YES_NO_OPTION);
        if (luaChon == JOptionPane.YES_OPTION) {
            Hang remove = getHangSelect();
            HangDAO.getInstance().deleteHang(remove.getMaHang());
        }
        loadDataToTable();
    }
//
    public Hang getHangSelect() {
        int i_row = tblSanPham.getSelectedRow();
        if (i_row == -1) return null; // Nếu không chọn dòng nào, trả về null

        Object value = tblModel.getValueAt(i_row, 1);
        if (value == null) return null; // Nếu không có dữ liệu, trả về null

        String maHang = value.toString();
        return HangDAO.getInstance().selectById(maHang);
    }
//
    public void loadDataToTableSearch(ArrayList<Hang> result) {
        try {
            tblModel.setRowCount(0);
            int stt=0;
            for (Hang i : result) {  
                String trangThaiStr = (i.getTrangThai() == 1) ? "Hoạt động" : "Không hoạt động";
                tblModel.addRow(new Object[]{
                    ++stt,
                    i.getMaHang(),
                        PhanLoaiDAO.getTenPhanLoaiById(i.getIdLoai()),
                        i.getTenHang(), 
//                        i.getSoLuong(),                         
                        formatter.format(i.getGia()) + "đ",
                        trangThaiStr
                });
            }
        } catch (Exception e) {
        }
    }

    public void changeTextFind() {
        jTextFieldSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                /* do nothing */
                if (jTextFieldSearch.getText().length() == 0) {
                    loadDataToTable();
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                /* do nothing */

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBoxLuaChon;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JTextField jTextFieldSearch;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable tblSanPham;
    // End of variables declaration//GEN-END:variables

    private void openFile(String file) {
        try {
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
