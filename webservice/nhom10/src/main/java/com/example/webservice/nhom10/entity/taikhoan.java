package com.example.webservice.nhom10.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
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
    @Column(unique = true)
    private String taikhoan;
    @Column
    @Pattern(regexp = "")
    private String matkhau;
    @Column
    private String quyenhan;
    @Column
    private String maxacthuc;
    @Column
    private boolean trangthai;

    @OneToOne(mappedBy = "taikhoanqly", cascade = CascadeType.ALL)
    private quanly quanly;

    @OneToOne(mappedBy = "taikhoannv", cascade = CascadeType.ALL)
    private nhanvien nhanvien;

    @OneToOne(mappedBy = "taikhoankh", cascade = CascadeType.ALL)
    private khachhang khachhang;
    

}
