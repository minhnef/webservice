package com.example.webservice.nhom10.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
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

    @OneToOne
    @JoinColumn(name = "idquanly")
    private quanly quanly;


}
