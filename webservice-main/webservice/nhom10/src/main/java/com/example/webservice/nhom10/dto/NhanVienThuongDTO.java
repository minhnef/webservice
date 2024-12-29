package com.example.webservice.nhom10.dto;

public class NhanVienThuongDTO {
    private int idnhanvien;
    private String hoten;
    private float luong;
    private String thuong;

    public NhanVienThuongDTO(int idnhanvien, String hoten, float luong, String thuong) {
        this.idnhanvien = idnhanvien;
        this.hoten = hoten;
        this.luong = luong;
        this.thuong = thuong;
    }

    // Getters and Setters
}
