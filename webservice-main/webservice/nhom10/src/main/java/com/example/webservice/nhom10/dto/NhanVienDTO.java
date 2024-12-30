package com.example.webservice.nhom10.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public class NhanVienDTO {

    private int idnhanvien;
    private String hoten;
    private float luong;
    private LocalDate ngaysinh;
    private String diachi;
    private String sdt;

    // Constructor mặc định
    public NhanVienDTO() {
    }

    // Constructor có tham số
    public NhanVienDTO(int idnhanvien, String hoten, float luong, LocalDate ngaysinh, String diachi, String sdt) {
        this.idnhanvien = idnhanvien;
        this.hoten = hoten;
        this.luong = luong;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.sdt = sdt;
    }

    // Getter và Setter
    public int getIdnhanvien() {
        return idnhanvien;
    }

    public void setIdnhanvien(int idnhanvien) {
        this.idnhanvien = idnhanvien;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public float getLuong() {
        return luong;
    }

    public void setLuong(float luong) {
        this.luong = luong;
    }

    public LocalDate getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(LocalDate ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }
}


