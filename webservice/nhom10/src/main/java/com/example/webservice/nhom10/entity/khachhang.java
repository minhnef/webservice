package com.example.webservice.nhom10.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class khachhang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int idkh;
    @Column
    private String hoten;
    @Column
    private LocalDate ngaysinh;
    @Column
    private String diachi;
    @Pattern(regexp = "^\\[0-9]{10,15}$", message = "Số điện thoại không hợp lệ")
    @Column
    private String sdt;
    @Column
    private int diemtichluy;
    
    @OneToMany(mappedBy = "khachhang", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "kh_ddh")
    private List<dondathang> dondathangs;
  

    @OneToMany(mappedBy = "khachhang", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonManagedReference(value = "kh_km")
    private List<khuyenmai> khuyenmais;
    


}
