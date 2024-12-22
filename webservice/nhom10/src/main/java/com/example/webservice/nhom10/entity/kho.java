package com.example.webservice.nhom10.entity;

import java.time.LocalDate;
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

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class kho {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Getter
    @Column
    private String tennguyenlieu;
    @Getter
    @Column
    private int gia;
    @Getter
    @Column
    private String noinhap;
    @Getter
    @Column
    private LocalDate ngaynhap;
    @Getter
    @Column
    private int soluong;
    @Getter
    @Column
    private String donvido;
    @Getter
    @Column
    private int tongtien;

    @OneToMany(mappedBy = "kho", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<chitietmonan> chitietmonans;

    @ManyToOne
    @JoinColumn(name = "idquanly")
    private quanly idquanly;

    public void setId(int id) {
        this.id = id;
    }

    public void setTennguyenlieu(String tennguyenlieu) {
        this.tennguyenlieu = tennguyenlieu;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public void setNoinhap(String noinhap) {
        this.noinhap = noinhap;
    }

    public void setNgaynhap(LocalDate ngaynhap) {
        this.ngaynhap = ngaynhap;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public void setDonvido(String donvido) {
        this.donvido = donvido;
    }

    public void setTongtien(int tongtien) {
        this.tongtien = tongtien;
    }

    public int getId() {
        return id;
    }

    public String getTennguyenlieu() {
        return tennguyenlieu;
    }

    public int getGia() {
        return gia;
    }

    public String getNoinhap() {
        return noinhap;
    }

    public LocalDate getNgaynhap() {
        return ngaynhap;
    }

    public int getSoluong() {
        return soluong;
    }

    public String getDonvido() {
        return donvido;
    }

    public int getTongtien() {
        return tongtien;
    }
}
