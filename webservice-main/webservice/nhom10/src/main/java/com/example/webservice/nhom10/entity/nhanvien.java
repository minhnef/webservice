package com.example.webservice.nhom10.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class nhanvien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int idnhanvien;
    @Column
    private String hoten;
    @Column
    private LocalDate ngaysinh;
    @Column
    private String diachi;
    @jakarta.validation.constraints.Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Số điện thoại không hợp lệ")
    @Column
    private String sdt;
    @Column
    private String lichlamviec;
    @Column
    private float luong;
    @Column
    private int ngaycong;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idtk", referencedColumnName = "idtk")
    private taikhoan taikhoannv;

    @OneToMany(mappedBy = "nhanvien", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<dondathang> dondathangs;

    @OneToMany(mappedBy = "nhanvien", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<com.example.webservice.nhom10.entity.lichlamviec> lichlamviecs;


    @OneToMany(mappedBy = "nhanvien", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<thuong> thuongs;
    public List<com.example.webservice.nhom10.entity.lichlamviec> getLichLamViecs() {
        return lichlamviecs;
    }
    public int getIdnhanvien() {
        return idnhanvien;
    }

    public String getHoten() {
        return hoten;
    }

    // Getter and Setter methods for all fields

    public void setIdnhanvien(int idnhanvien) {
        this.idnhanvien = idnhanvien;
    }


    public void setHoten(String hoten) {
        this.hoten = hoten;
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

    public float getLuong() {
        return luong;
    }

    public void setLuong(float luong) {
        this.luong = luong;
    }

    public int getNgaycong() {
        return ngaycong;
    }

    public void setNgaycong(int ngaycong) {
        this.ngaycong = ngaycong;
    }
    public List<thuong> getThuongs() {
        return thuongs;
    }

}
