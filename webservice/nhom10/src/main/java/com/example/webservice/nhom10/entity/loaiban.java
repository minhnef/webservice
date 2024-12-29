package com.example.webservice.nhom10.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class loaiban {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int idloaiban;
    @Column
    private String loaiban;
    @Column
    private String mota;
    @Column
    private int gia;

    @OneToMany(mappedBy = "loaiban", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "ban_loaiban")
    private List<ban> bans;


}
