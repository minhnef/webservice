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
import lombok.val;

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
    @JsonBackReference(value = "dm_ma")
    @JoinColumn(name = "danhmucdoan", foreignKey = @ForeignKey(name = "fk_dm_ma"))
    private danhmucmonan danhmuc;

    @ManyToOne
    @JsonBackReference(value = "ma_ql")
    @JoinColumn(name = "idquanly", foreignKey = @ForeignKey(name = "fk_ql_ma"))
    private quanly idquanly;

    @OneToMany(mappedBy = "idmonan", cascade =  CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "ma_ctma")
    private List<chitietmonan> chitietmonans;

    @OneToMany(mappedBy = "idmonan", cascade =  CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "ma_ctdh")
    private List<chitietdonhang> chitietdonhangs;

}
