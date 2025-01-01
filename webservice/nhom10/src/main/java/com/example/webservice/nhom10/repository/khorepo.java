package com.example.webservice.nhom10.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.webservice.nhom10.entity.kho;

@Repository
public interface KhoRepo extends JpaRepository<kho, Integer>{
@Query("SELECT k FROM kho k WHERE k.tennguyenlieu LIKE %:value%")
    List<kho> search(@Param("value") String value);
}
