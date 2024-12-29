package com.example.webservice.nhom10.entity;

import java.time.LocalDate;
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
@NoArgsConstructor
@AllArgsConstructor
public class khuyenmai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int idkm;
    @Column
    private String khuyenmai;
    @Column
    private LocalDate ngaybatdau;
    @Column
    private LocalDate ngayketthuc;

    @ManyToOne
    @JsonBackReference(value = "kh_km")
    @JoinColumn(name = "idkh", foreignKey = @ForeignKey(name = "fk_kh_km"))
    private khachhang khachhang;
    
    @ManyToOne
    @JsonBackReference(value = "ddh_km")
    @JoinColumn(name = "iddh", foreignKey = @ForeignKey(name = "fk_ddh_km"))
    private dondathang dondathang;

    @OneToMany(mappedBy = "khuyenmai", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "km_ctkm")
    private List<chitietkhuyenmai> chitietkhuyenmais;


}
