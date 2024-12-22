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
    @JoinColumn(name = "idnhanvien")
    private nhanvien nhanvien;

    @OneToMany(mappedBy = "dondathang", cascade = CascadeType.ALL, fetch =  FetchType.LAZY)
    private List<ban> bans;

    @OneToMany(mappedBy = "iddonhang", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<chitietdonhang> chitietdonhangs;


}
