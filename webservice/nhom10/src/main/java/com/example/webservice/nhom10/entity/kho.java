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
@AllArgsConstructor
@NoArgsConstructor
public class kho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private String tennguyenlieu;
    @Column
    private int gia;
    @Column
    private String noinhap;
    @Column
    private LocalDate ngaynhap;
    @Column
    private int soluong;
    @Column
    private String donvido;
    @Column
    private int tongtien;

    @OneToMany(mappedBy = "kho", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "kho_ctma")
    private List<chitietmonan> chitietmonans;

    @ManyToOne
    @JsonBackReference(value = "kho_ql")
    @JoinColumn(name = "idquanly", foreignKey = @ForeignKey(name = "fk_kho_ql"))
    private quanly idquanly;

}
