package com.example.webservice.nhom10.entity;

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
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class monan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int idmonan;
    @Column
    private String tenmon;
    @Column
    private int gia;
    @Column
    private String image;

    @ManyToOne
    @JoinColumn(name = "danhmucdoan")
    private danhmucmonan danhmuc;

    @ManyToOne
    @JoinColumn(name = "idquanly")
    private quanly idquanly;

    @OneToMany(mappedBy = "idmonan", cascade =  CascadeType.ALL, fetch = FetchType.LAZY)
    private List<chitietmonan> chitietmonans;

    public int getIdmonan() {
        return idmonan;
    }

    public void setIdmonan(int idmonan) {
        this.idmonan = idmonan;
    }

    public String getTenmon() {
        return tenmon;
    }

    public void setTenmon(String tenmon) {
        this.tenmon = tenmon;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public danhmucmonan getDanhmuc() {
        return danhmuc;
    }

    public void setDanhmuc(danhmucmonan danhmuc) {
        this.danhmuc = danhmuc;
    }

    public quanly getIdquanly() {
        return idquanly;
    }

    public void setIdquanly(quanly idquanly) {
        this.idquanly = idquanly;
    }

    public List<chitietmonan> getChitietmonans() {
        return chitietmonans;
    }

    public void setChitietmonans(List<chitietmonan> chitietmonans) {
        this.chitietmonans = chitietmonans;
    }

}
