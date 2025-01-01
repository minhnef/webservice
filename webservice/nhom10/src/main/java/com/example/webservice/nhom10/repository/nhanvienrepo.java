package com.example.webservice.nhom10.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.webservice.nhom10.entity.nhanvien;
@Repository
public interface nhanvienrepo extends JpaRepository<nhanvien, Integer>{
     List<nhanvien> findAll();
    @Query(value = "select * from nhanvien where hoten like :hoten", nativeQuery = true)
    nhanvien findByHoten(@Param("hoten") String hoten);
    nhanvien findByIdnhanvien(int idnhanvien);

}
