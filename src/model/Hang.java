/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Objects;

public class Hang {
    private String maHang;
    private String tenPhanLoai;
    private String tenHang;
    private int soLuong;
    private double gia;
    private String xuatXu;
    private int trangThai;
    private int idLoai;
    public Hang() {
    }

    public Hang(String maHang, String tenHang, int soLuong, double gia, String xuatXu, int trangThai, int idLoai) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.soLuong = soLuong;
        this.gia = gia;
        this.xuatXu = xuatXu;
        this.trangThai = trangThai;
        this.idLoai = idLoai;
    }

    public int getIdLoai(){
        return idLoai;
    }
    
    public void setIdLoai(int idLoai){
        this.idLoai = idLoai;
    }
    
    public String getTenPhanLoai(){
        return tenPhanLoai;
    }
    
    public void setTenPhanLoai(String tenPhanLoai){
        this.tenPhanLoai = tenPhanLoai;
    }
    
    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getMaHang() {
        return maHang;
    }

    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }
    
   

    public String getXuatXu() {
        return xuatXu;
    }

    public void setXuatXu(String xuatXu) {
        this.xuatXu = xuatXu;
    }

    public void xuatHang(int sl) {
        this.soLuong -= sl;
    }

    @Override
    public String toString() {
        return "Hang{" + "maHang=" + maHang + ", tenHang=" + tenHang + ", soLuong=" + soLuong + ", gia=" + gia + ", xuatXu=" + xuatXu + ", trangThai=" + trangThai + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.maHang);
        hash = 37 * hash + Objects.hashCode(this.tenHang);
        hash = 37 * hash + this.soLuong;
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.gia) ^ (Double.doubleToLongBits(this.gia) >>> 32));
        hash = 37 * hash + Objects.hashCode(this.xuatXu);
        hash = 37 * hash + this.trangThai;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Hang other = (Hang) obj;
        if (this.soLuong != other.soLuong) {
            return false;
        }
        if (Double.doubleToLongBits(this.gia) != Double.doubleToLongBits(other.gia)) {
            return false;
        }
        if (this.trangThai != other.trangThai) {
            return false;
        }
        if (!Objects.equals(this.maHang, other.maHang)) {
            return false;
        }
        if (!Objects.equals(this.tenHang, other.tenHang)) {
            return false;
        }
        return Objects.equals(this.xuatXu, other.xuatXu);
    }
}
