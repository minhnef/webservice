package com.example.webservice.nhom10.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.webservice.nhom10.entity.thuong;

@Repository
public interface Ithuongrepo extends JpaRepository<thuong, Integer>{
    List<thuong> findByNhanvienIdnhanvien(int idnhanvien);  // Tìm thưởng theo id nhân viên
    List<thuong> findAll();
}
