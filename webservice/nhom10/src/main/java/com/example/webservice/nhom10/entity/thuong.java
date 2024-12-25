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
public class thuong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int idthuong;
    @Column
    private String thuong;
    @Column
    private String lydo;

    @ManyToOne
    @JoinColumn(name = "idnhanvien")
    private nhanvien nhanvien;

}
