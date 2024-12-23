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


}
