package com.example.webservice.nhom10.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
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
@AllArgsConstructor
@NoArgsConstructor
public class dondathang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int iddonhang;
    @Column
    private String diachigiaohang;
    @Column
    private int tonggia;

    @ManyToOne
    @JsonBackReference(value = "ddh_nv")
    @JoinColumn(name = "idnhanvien", foreignKey = @ForeignKey(name = "fk_nv_ddh"))
    private nhanvien nhanvien;

    @OneToMany(mappedBy = "donhang", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonManagedReference(value = "ddh_ctdh")
    private List<chitietdonhang> chitietdonhangs;

    @ManyToOne
    @JsonBackReference(value = "kh_ddh")
    @JoinColumn(name = "idkh", foreignKey = @ForeignKey(name = "kh_ddh"))
    private khachhang khachhang;

    @OneToMany(mappedBy = "dondathang", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "ddh_km")
    private List<khuyenmai> khuyenmais;


}
