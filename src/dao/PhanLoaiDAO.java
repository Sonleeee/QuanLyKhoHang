/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import com.sun.jdi.connect.spi.Connection;
import database.JDBCUtil;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

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

}
