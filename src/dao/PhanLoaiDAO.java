/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.Statement;
import database.JDBCUtil;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.PhanLoai;

/**
 *

 */

public class PhanLoaiDAO {
        public static ArrayList<String> getAllPhanLoai() {
            ArrayList<String> list = new ArrayList<>();
            String sql = "SELECT * FROM phanloai"; // Đổi thành tên đúng của cột

            try (java.sql.Connection conn = JDBCUtil.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {

                while (rs.next()) {
                    list.add(rs.getString("tenLoai")); // Đổi thành tên đúng của cột
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return list;
        }
        
        public static int getIdByTenPhanLoai(String tenPhanLoai) {
            int idLoai = -1; // Mặc định -1 nếu không tìm thấy
            String query = "SELECT IDLoai FROM PhanLoai WHERE TenLoai = ?";

            try (java.sql.Connection conn = JDBCUtil.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(query);) {
                stmt.setString(1, tenPhanLoai);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    idLoai = rs.getInt("idLoai");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return idLoai;
        }
        
        public static String getTenPhanLoaiById(int idLoai) {
            String tenPhanLoai = null;
            String sql = "SELECT TenLoai FROM PhanLoai WHERE idLoai = ?";

            try (java.sql.Connection conn = JDBCUtil.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql);) {

                stmt.setInt(1, idLoai);
                ResultSet rs = stmt.executeQuery();

                if (rs.next()) {
                    tenPhanLoai = rs.getString("TenLoai");
                }

            } catch (SQLException e) {
                System.out.println("Lỗi khi lấy tên phân loại: " + e.getMessage());
            }

            return tenPhanLoai;
        }
        
       public int insert(PhanLoai phanLoai) {
            int generatedId = 0;
            java.sql.Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet generatedKeys = null;

            // --- SQL chỉ INSERT cột tên phân loại ---
            // !!! QUAN TRỌNG: Thay 'TenPhanLoai' bằng tên cột CHÍNH XÁC trong bảng PhanLoai của bạn !!!
            // Có thể là TenPhanLoai, TenLoai, Name, CategoryName, v.v.
            String sql = "INSERT INTO PhanLoai (TenLoai) VALUES (?)";

            try {
                // 1. Lấy kết nối
                conn = JDBCUtil.getConnection(); // Sử dụng lớp tiện ích của bạn

                // 2. Tạo PreparedStatement, yêu cầu trả về key tự tăng
                pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                // 3. Thiết lập tham số cho TenPhanLoai (chỉ có 1 tham số)
                // Sử dụng getter đúng từ lớp PhanLoai
                pstmt.setString(1, phanLoai.getTenPhanLoai());

                // 4. Thực thi câu lệnh INSERT
                int affectedRows = pstmt.executeUpdate();

                // 5. Kiểm tra và lấy ID tự tăng
                if (affectedRows > 0) {
                    generatedKeys = pstmt.getGeneratedKeys();
                    if (generatedKeys != null && generatedKeys.next()) {
                        generatedId = generatedKeys.getInt(1); // Lấy ID
                        System.out.println("Đã thêm Phân Loại mới ('" + phanLoai.getTenPhanLoai() + "') với ID: " + generatedId);
                    } else {
                         System.err.println("Thêm Phân Loại ('" + phanLoai.getTenPhanLoai() + "') thành công nhưng không lấy được ID tự tăng.");
                         // Có thể bạn muốn trả về một giá trị khác 0 ở đây nếu insert thành công
                         // Ví dụ: return -1; // Để phân biệt với lỗi SQL hoàn toàn
                    }
                } else {
                     System.err.println("Thêm Phân Loại ('" + phanLoai.getTenPhanLoai() + "') thất bại, không có dòng nào bị ảnh hưởng.");
                }

            } catch (SQLException e) {
                // In chi tiết lỗi SQL, đặc biệt hữu ích nếu tên cột sai hoặc có ràng buộc UNIQUE
                System.err.println("Lỗi SQL khi thêm Phân Loại '" + phanLoai.getTenPhanLoai() + "': " + e.getMessage());
                e.printStackTrace();
            } finally {
                // 7. ĐÓNG TÀI NGUYÊN - Đừng quên bước này!

            }

            return generatedId; // Trả về ID đã tạo hoặc 0 nếu có lỗi
        }

}
