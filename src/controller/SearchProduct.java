package controller;

import dao.HangDAO;
import dao.PhanLoaiDAO;
import database.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Hang;
import model.PhanLoai;

/**
 *

 */
public class SearchProduct {

    public static SearchProduct getInstance() {
        return new SearchProduct();
    }

    public ArrayList<Hang> searchTatCa(String text) {
        ArrayList<Hang> result = new ArrayList<>();
        ArrayList<Hang> armt = HangDAO.getInstance().selectAllExist();
        for (var mt : armt) {
            if (mt.getTrangThai() == 1) {
                if (mt.getMaHang().toLowerCase().contains(text.toLowerCase()) || mt.getTenHang().toLowerCase().contains(text.toLowerCase())
                        || mt.getXuatXu().toLowerCase().contains(text.toLowerCase())) {
                    result.add(mt);
                }
            }
        }
        return result;
    }

    public ArrayList<Hang> searchMaHang(String text) {
        ArrayList<Hang> result = new ArrayList<>();
        ArrayList<Hang> armt = HangDAO.getInstance().selectAllExist();
        for (var mt : armt) {
            if (mt.getTrangThai() == 1) {
                if (mt.getMaHang().toLowerCase().contains(text.toLowerCase())) {
                    result.add(mt);
                }
            }
        }
        return result;
    }

    public ArrayList<Hang> searchTenHang(String text) {
        ArrayList<Hang> result = new ArrayList<>();
        ArrayList<Hang> armt = HangDAO.getInstance().selectAllExist();
        for (var mt : armt) {
            if (mt.getTrangThai() == 1) {
                if (mt.getTenHang().toLowerCase().contains(text.toLowerCase())) {
                    result.add(mt);
                }
            }
        }
        return result;
    }

    public ArrayList<Hang> searchSoLuong(String text) {
        ArrayList<Hang> result = new ArrayList<>();
        ArrayList<Hang> armt = HangDAO.getInstance().selectAllExist();
        for (var mt : armt) {
            if (mt.getTrangThai() == 1) {
                if (text.length() != 0) {
                    if (mt.getSoLuong() > Integer.parseInt(text)) {
                        result.add(mt);
                    }
                } else {
                    result.add(mt);
                }
            }
        }
        return result;
    }

    public ArrayList<Hang> searchDonGia(String text) {
        ArrayList<Hang> result = new ArrayList<>();
        ArrayList<Hang> armt = HangDAO.getInstance().selectAllExist();
        for (var mt : armt) {
            if (mt.getTrangThai() == 1) {

                if (text.length() != 0) {
                    if (mt.getGia() > Integer.parseInt(text)) {
                        result.add(mt);
                    }
                }
                else {
                    result.add(mt);
                }
            } 
        }
        return result;
    }



    public ArrayList<Hang> searchXuatXu(String text) {
        ArrayList<Hang> result = new ArrayList<>();
        ArrayList<Hang> armt = HangDAO.getInstance().selectAllExist();
        for (var mt : armt) {
            if (mt.getXuatXu().toLowerCase().contains(text.toLowerCase())) {
                result.add(mt);
            }
        }
        return result;
    }

    public ArrayList<Hang> searchLoai(int idLoai) {
        ArrayList<Hang> result = new ArrayList<>();
        String sql = "Select * from Hang Where idloai = ?";  
        try(Connection con = JDBCUtil.getConnection();            
            PreparedStatement stmt = con.prepareStatement(sql)){
            stmt.setInt(1, idLoai);
            ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                Hang hang = new Hang();
                hang.setMaHang(rs.getString("maHang"));
                hang.setIdLoai(rs.getInt("idLoai"));
                hang.setTenHang(rs.getString("tenHang"));
                hang.setSoLuong(rs.getInt("soLuong"));
                hang.setGia(rs.getDouble("gia"));
                hang.setXuatXu(rs.getString("xuatXu"));
                hang.setTrangThai(rs.getInt("trangThai"));
                result.add(hang);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    
    public Hang searchId(String maHang) {
        Hang hang = null;
        String sql = "SELECT * FROM Hang WHERE MaHang = ?";
        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, maHang);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                hang = new Hang();
                hang.setMaHang(rs.getString("maHang"));
                hang.setIdLoai(rs.getInt("idLoai"));
                hang.setTenHang(rs.getString("tenHang"));
                hang.setSoLuong(rs.getInt("soLuong"));
                hang.setGia(rs.getDouble("gia"));
                hang.setXuatXu(rs.getString("xuatXu"));
                hang.setTrangThai(rs.getInt("trangThai"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hang;
    }


}
