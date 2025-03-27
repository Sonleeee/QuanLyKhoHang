/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Objects;

/**
 *
 * @author
 */
public class ThongKeProduct {
    private String maHang;
    private String tenHang;
    private int slNhap;
    private int slXuat;

    public ThongKeProduct() {
    }

    public ThongKeProduct(String maHang, String tenHang, int slNhap, int slXuat) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.slNhap = slNhap;
        this.slXuat = slXuat;
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

    public int getSlNhap() {
        return slNhap;
    }

    public void setSlNhap(int slNhap) {
        this.slNhap = slNhap;
    }

    public int getSlXuat() {
        return slXuat;
    }

    public void setSlXuat(int slXuat) {
        this.slXuat = slXuat;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.maHang);
        hash = 53 * hash + Objects.hashCode(this.tenHang);
        hash = 53 * hash + this.slNhap;
        hash = 53 * hash + this.slXuat;
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
        final ThongKeProduct other = (ThongKeProduct) obj;
        if (this.slNhap != other.slNhap) {
            return false;
        }
        if (this.slXuat != other.slXuat) {
            return false;
        }
        if (!Objects.equals(this.maHang, other.maHang)) {
            return false;
        }
        return Objects.equals(this.tenHang, other.tenHang);
    }

    @Override
    public String toString() {
        return "ThongKeProduct{" + "maHang=" + maHang + ", tenHang=" + tenHang + ", slNhap=" + slNhap + ", slXuat=" + slXuat + '}';
    }
    
    
}
