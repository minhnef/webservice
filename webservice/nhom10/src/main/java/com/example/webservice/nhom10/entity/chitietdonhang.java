package com.example.webservice.nhom10.entity;

import java.time.LocalDate;
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
    @JsonBackReference(value = "ma_ctdh")
    @JoinColumn(name = "idmonan", foreignKey = @ForeignKey(name = "fk_ma_ctdh"))
    private monan idmonan;

    @ManyToOne
    @JsonBackReference(value = "ddh_ctdh")
    @JoinColumn(name = "iddonhang", foreignKey = @ForeignKey(name = "fk_ddh_ctdh"))
    private dondathang donhang;

    @OneToMany(mappedBy = "chitietdonhang",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonManagedReference(value = "ban_ctddh")
    private List<ban> bans;
}
