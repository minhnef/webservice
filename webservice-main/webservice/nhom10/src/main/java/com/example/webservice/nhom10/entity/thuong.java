package com.example.webservice.nhom10.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class thuong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int idthuong;
    @Column
    private String thuong;
    @Column
    private String lydo;

    @ManyToOne
    @JoinColumn(name = "idnhanvien")
    private com.example.webservice.nhom10.entity.nhanvien nhanvien;
    // Thêm getter và setter thủ công nếu Lombok không sinh ra
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
    public nhanvien getNhanvien() {
        return nhanvien;
    }

    public void setNhanvien(nhanvien nhanvien) {
        this.nhanvien = nhanvien;
    }
}

