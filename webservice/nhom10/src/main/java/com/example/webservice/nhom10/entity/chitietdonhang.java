package com.example.webservice.nhom10.entity;

import java.time.LocalDate;

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
public class chitietdonhang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int idchitiet;
    @Column
    private String yeucaukh;
    @Column
    private LocalDate ngaydat;
    @Column
    private String trangthai;

    @ManyToOne
    @JoinColumn(name = "idmonan")
    private monan idmonan;

    @ManyToOne
    @JoinColumn(name = "iddonhang")
    private dondathang iddonhang;
}
