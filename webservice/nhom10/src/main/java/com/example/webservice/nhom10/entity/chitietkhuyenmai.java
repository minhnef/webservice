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
public class chitietkhuyenmai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int idchitiet;
    @Column
    private int dieukien;
    @Column
    private String giamgia;
    
    @ManyToOne
    @JsonBackReference(value = "km_ctkm")
    @JoinColumn(name = "idkm", foreignKey = @ForeignKey(name = "fk_km_ctkm"))
    private khuyenmai khuyenmai;
}
