package com.example.webservice.nhom10.repository;

import com.example.webservice.nhom10.entity.kho;
import com.example.webservice.nhom10.entity.monan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MonanRepo extends JpaRepository<monan, Integer> {
    @Query("SELECT k FROM monan k WHERE k.tenmon LIKE %:value%")
    List<kho> search(@Param("value") String tenmon);
}