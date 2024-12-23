package com.example.webservice.nhom10.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class taikhoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int idtk;
    @Column
    private String taikhoan;
    @Column
    private String matkhau;
    @Column
    private String quyenhan;
    @Column
    private String maxacthuc;
    @Column
    private boolean trangthai;

    @OneToOne(mappedBy = "taikhoan_ql", cascade = CascadeType.ALL, orphanRemoval = true)
    @PrimaryKeyJoinColumn
    private quanly quanly;

    @OneToOne(mappedBy = "taikhoan_nv", cascade = CascadeType.ALL, orphanRemoval = true)
    @PrimaryKeyJoinColumn
    private nhanvien nhanvien;

}
