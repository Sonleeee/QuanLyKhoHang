/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class PhanLoai {
    private int idLoai;
    private String tenPhanLoai;

    // Constructor
    public PhanLoai() {
    }

    public PhanLoai(int idLoai, String tenPhanLoai) {
        this.idLoai = idLoai;
        this.tenPhanLoai = tenPhanLoai;
    }

    // Getter và Setter
    public int getIdLoai() {
        return idLoai;
    }

    public void setIdLoai(int idLoai) {
        this.idLoai = idLoai;
    }

    public String getTenPhanLoai() {
        return tenPhanLoai;
    }

    public void setTenPhanLoai(String tenPhanLoai) {
        this.tenPhanLoai = tenPhanLoai;
    }

    // Phương thức hiển thị thông tin phân loại
    @Override
    public String toString() {
        return tenPhanLoai; // Dùng khi hiển thị trong ComboBox
    }
}