package com.example.webservice.nhom10.repository;

import com.example.webservice.nhom10.entity.nhanvien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhanVienRepository extends JpaRepository<nhanvien, Integer> {
//    @Query("SELECT nv.idnhanvien, nv.hoten, nv.luong, t.thuong " +
//            "FROM nhanvien nv " +
//            "LEFT JOIN nv.thuongs t")
//    List<Object[]> findNhanVienWithThuong();
    List<nhanvien> findAll();
    nhanvien findByHoten(String hoten);
    nhanvien findByIdnhanvien(int idnhanvien);
}


