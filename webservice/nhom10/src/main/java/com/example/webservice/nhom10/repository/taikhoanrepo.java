package com.example.webservice.nhom10.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.webservice.nhom10.entity.taikhoan;
@Repository
public interface taikhoanrepo extends JpaRepository<taikhoan, Integer>{
    @Query(value = "select * from taikhoan where taikhoan like :username", nativeQuery = true)
    public Optional<taikhoan> findByUsername(@Param("username") String username);

}
