package com.example.webservice.nhom10.dto;

import java.time.LocalDate;

public class LichLamViecRequest {
    private String hoTen;
    private LocalDate ngayBatDau;
    private LocalDate ngayKetThuc;

    public LocalDate getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(LocalDate ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public LocalDate getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(LocalDate ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }


    public String getHoTen() { // Getter cho hoTen
        return hoTen;
    }

    public void setHoTen(String hoTen) { // Setter cho hoTen
        this.hoTen = hoTen;
    }

}

