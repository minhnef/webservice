package com.example.webservice.nhom10.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class chitietmonan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int idchitiet;
    @Column
    private String mota;
    @Column
    private String danhgia;
    
    @ManyToOne
    @JsonBackReference(value = "ma_ctma")
    @JoinColumn(name = "idmonan", foreignKey = @ForeignKey(name = "fk_ma_ctma"))
    private monan idmonan;

    @ManyToOne
    @JsonBackReference(value = "kho_ctma")
    @JoinColumn(name = "idkho",foreignKey = @ForeignKey(name = "fk_ctma_kho"))
    private kho kho;



}
