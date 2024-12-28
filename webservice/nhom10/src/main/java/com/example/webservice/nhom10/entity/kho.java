package com.example.webservice.nhom10.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class kho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "tennguyenlieu")
    private String tennguyenlieu;

    @Column(name = "gia")
    private int gia;

    @Column(name = "noinhap")
    private String noinhap;

    @Column(name = "ngaynhap")

    private LocalDate ngaynhap;

    @Column(name = "soluong")
    private int soluong;

    @Column(name = "donvido")
    private String donvido;

    @Column(name = "tongtien")
    private int tongtien;

    @OneToMany(mappedBy = "kho", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<chitietmonan> chitietmonans;

    @ManyToOne
    @JoinColumn(name = "idquanly")
    private quanly idquanly;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTennguyenlieu() {
        return tennguyenlieu;
    }

    public void setTennguyenlieu(String tennguyenlieu) {
        this.tennguyenlieu = tennguyenlieu;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getNoinhap() {
        return noinhap;
    }

    public void setNoinhap(String noinhap) {
        this.noinhap = noinhap;
    }

    public LocalDate getNgaynhap() {

      return ngaynhap;
    }

    public void setNgaynhap(LocalDate ngaynhap) {
        this.ngaynhap = ngaynhap;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public String getDonvido() {
        return donvido;
    }

    public void setDonvido(String donvido) {
        this.donvido = donvido;
    }

    public int getTongtien() {
        return tongtien;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    public List<chitietmonan> getChitietmonans() {
        return chitietmonans;
    }

    public void setChitietmonans(List<chitietmonan> chitietmonans) {
        this.chitietmonans = chitietmonans;
    }

    public quanly getIdquanly() {
        return idquanly;
    }

    public void setIdquanly(quanly idquanly) {
        this.idquanly = idquanly;
    }
}
