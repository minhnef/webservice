package com.example.webservice.nhom10.repository;

import com.example.webservice.nhom10.entity.thuong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThuongRepository extends JpaRepository<thuong, Integer> {
    List<thuong> findByNhanvienIdnhanvien(int idnhanvien);  // Tìm thưởng theo id nhân viên
    List<thuong> findAll();
}
