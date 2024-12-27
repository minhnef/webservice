package com.example.webservice.nhom10.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
    @JoinColumn(name = "idkm")
    private khuyenmai khuyenmai;
}
