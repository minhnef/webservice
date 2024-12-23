package com.example.webservice.nhom10.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
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
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JsonIgnore
    private taikhoan taikhoan_nv;


}
