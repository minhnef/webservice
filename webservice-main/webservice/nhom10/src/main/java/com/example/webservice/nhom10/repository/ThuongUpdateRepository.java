package com.example.webservice.nhom10.repository;

import com.example.webservice.nhom10.entity.thuong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThuongUpdateRepository extends JpaRepository<thuong, Integer> {
    thuong findByNhanvienIdnhanvien(int idnhanvien);
}
