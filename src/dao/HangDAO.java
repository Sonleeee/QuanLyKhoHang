/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.JDBCUtil;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Hang;
public class HangDAO implements DAOInterface<Hang> {

    public static HangDAO getInstance() {
        return new HangDAO();
    }

    @Override
    public int insert(Hang hang)  {
        int ketqua = 0;
        String sql = "INSERT INTO Hang (maHang, tenHang, soLuong, gia, xuatXu, trangThai, idLoai) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = JDBCUtil.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)){
        stmt.setString(1, hang.getMaHang());
        stmt.setString(2, hang.getTenHang());
        stmt.setInt(3, hang.getSoLuong());
        stmt.setDouble(4, hang.getGia());
        stmt.setString(5, hang.getXuatXu());
        stmt.setInt(6, hang.getTrangThai());
        stmt.setInt(7, hang.getIdLoai());
        stmt.executeUpdate();
    }   catch (SQLException ex) {
            Logger.getLogger(HangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    return ketqua;
}


    @Override
    public int update(Hang h) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE Hang SET tenHang=?, soLuong=?, gia=?, xuatXu=?, trangThai=? WHERE maHang=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, h.getTenHang());
            pst.setInt(2, h.getSoLuong());
            pst.setDouble(3, h.getGia());
            pst.setString(4, h.getXuatXu());
            pst.setInt(5, h.getTrangThai());
            pst.setString(6, h.getMaHang());
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (SQLException ex) {
            Logger.getLogger(HangDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ketQua;
    }

    @Override
    public int delete(Hang h) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM Hang WHERE maHang=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, h.getMaHang());
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public ArrayList<Hang> selectAll() {
        ArrayList<Hang> ketQua = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT h.*, p.TenLoai FROM Hang h " +
                     "JOIN PhanLoai p ON h.idLoai = p.idLoai " +
                     "ORDER BY p.TenLoai ASC";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Hang h = new Hang(
                    rs.getString("maHang"),
                    rs.getString("tenHang"),
                    rs.getInt("soLuong"),
                    rs.getDouble("gia"),
                    rs.getString("xuatXu"),
                    rs.getInt("trangThai"),
                        rs.getInt("idLoai")
                );
                h.setTenPhanLoai(rs.getString("TenLoai")); // Gán tên phân loại vào đối tượng
                ketQua.add(h);
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    @Override
    public Hang selectById(String maHang) {
        Hang ketQua = null;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT h.*, p.TenLoai FROM Hang h " +
                 "JOIN PhanLoai p ON h.idLoai = p.idLoai" + 
                 " WHERE maHang = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, maHang);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                ketQua = new Hang(
                    rs.getString("maHang"),
                    rs.getString("tenHang"),
                    rs.getInt("soLuong"),
                    rs.getDouble("gia"),
                    rs.getString("xuatXu"),
                    rs.getInt("trangThai"),
                        rs.getInt("idLoai")
                );
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }

    public int updateSoLuong(String maHang, int soLuong) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "UPDATE Hang SET soLuong=? WHERE maHang=?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, soLuong);
            pst.setString(2, maHang);
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    
    public int deleteHang(String maHang) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "DELETE FROM Hang WHERE maHang = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, maHang);
            ketQua = pst.executeUpdate();
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
    
    public ArrayList<Hang> selectAllExist() {
        ArrayList<Hang> ketQua = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM Hang";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Hang h = new Hang(
                    rs.getString("maHang"),
                    rs.getString("tenHang"),
                    rs.getInt("soLuong"),
                    rs.getDouble("gia"),
                    rs.getString("xuatXu"),
                    rs.getInt("trangThai"),
                        rs.getInt("idLoai")
                );
                ketQua.add(h);
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ketQua;
    }
        
    public int getSl() {
        int soluong = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            String sql = "SELECT * FROM Hang WHERE trangThai = 1";
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                soluong++;
            }
            JDBCUtil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return soluong;
    }
    
    public boolean kiemTraTonTaiTheoTen(String tenHang) {        
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        boolean tonTai = false;
        // Tên cột Tên Hàng trong DB của bạn có thể khác (ví dụ: TenSP)
        String sql = "SELECT COUNT(*) FROM hang WHERE TenHang = ?"; // Hoặc tên cột đúng

        // Cân nhắc chuẩn hóa tên trước khi kiểm tra nếu cần
        // Ví dụ: tìm kiếm không phân biệt hoa thường (phụ thuộc DB)
        // String sql = "SELECT COUNT(*) FROM hang WHERE LOWER(TenHang) = LOWER(?)";

        try {
             pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, tenHang); // Đặt tên hàng cần tìm
            rs = pstmt.executeQuery();

            if (rs.next()) {
                tonTai = (rs.getInt(1) > 0); // Nếu count > 0 thì tên đã tồn tại
            }
        } catch (SQLException e) {
            System.err.println("Lỗi khi kiểm tra sự tồn tại của sản phẩm theo tên: " + tenHang);
            e.printStackTrace();
            // Trong trường hợp lỗi, trả về false để tránh bỏ qua import không cần thiết
            // Hoặc bạn có thể ném lại lỗi để xử lý ở tầng trên
            return false;
        } finally {
            // Đóng resources
            try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (pstmt != null) pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
        return tonTai;
    }
    
    public Hang getHangByTen(String tenHang) {
        Hang hang = null;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT MaHang, TenHang, SoLuong, Gia, TrangThai, IDLoai FROM Hang WHERE TenHang = ?"; // Lấy các cột cần thiết

//        if (tenHang == null || tenHang.trim().isEmpty()) return null;

        try {
            con = JDBCUtil.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, tenHang);
            rs = pstmt.executeQuery();
             
            if (rs.next()) {
                hang = new Hang();
                hang.setMaHang(rs.getString("MaHang"));
                hang.setTenHang(rs.getString("TenHang"));
                hang.setSoLuong(rs.getInt("SoLuong")); // Có thể không cần thiết ở đây
                hang.setGia(rs.getDouble("Gia"));     // Quan trọng
//                hang.setXuatXu(rs.getString("XuatSu")); // Ví dụ
                hang.setTrangThai(rs.getInt("TrangThai")); // Ví dụ
                hang.setIdLoai(rs.getInt("IDLoai"));     // Ví dụ
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return hang;
    }
    
    
}
