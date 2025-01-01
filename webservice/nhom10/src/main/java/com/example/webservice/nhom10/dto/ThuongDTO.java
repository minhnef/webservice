package com.example.webservice.nhom10.dto;

public class ThuongDTO {
    private int idthuong;  // ID của thưởng
    private String thuong; // Tên thưởng
    private String lydo;   // Lý do thưởng
    private int idnhanvien; // ID của nhân viên

    // Constructor với idthuong, thuong, lydo và idnhanvien
    public ThuongDTO(int idthuong, String thuong, String lydo, int idnhanvien) {
        this.idthuong = idthuong;
        this.thuong = thuong;
        this.lydo = lydo;
        this.idnhanvien = idnhanvien;
    }

    // Getter and Setter
    public int getIdthuong() {
        return idthuong;
    }

    public void setIdthuong(int idthuong) {
        this.idthuong = idthuong;
    }

    public String getThuong() {
        return thuong;
    }

    public void setThuong(String thuong) {
        this.thuong = thuong;
    }

    public String getLydo() {
        return lydo;
    }

    public void setLydo(String lydo) {
        this.lydo = lydo;
    }

    public int getIdnhanvien() {
        return idnhanvien;
    }

    public void setIdnhanvien(int idnhanvien) {
        this.idnhanvien = idnhanvien;
    }
}
