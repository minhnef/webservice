package com.example.webservice.nhom10.entity;

import java.time.LocalDate;
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
public class lichlamviec {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int idlichlam;

    @Column
    private LocalDate ngaybatdau;
    @Column
    private LocalDate ngayketthuc;
    
    @ManyToOne
    @JoinColumn(name = "idnhanvien")
    private nhanvien nhanvien;

    @OneToMany(mappedBy = "lichlamviec", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<calam> calams;


}
