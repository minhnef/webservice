package com.example.webservice.nhom10.repository;

import com.example.webservice.nhom10.entity.nhanvien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhanVienRepository extends JpaRepository<nhanvien, Integer> {

    List<nhanvien> findAll();
}


