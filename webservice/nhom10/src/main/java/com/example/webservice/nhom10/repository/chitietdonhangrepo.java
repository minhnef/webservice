package com.example.webservice.nhom10.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.webservice.nhom10.entity.chitietdonhang;
@Repository
public interface chitietdonhangrepo extends JpaRepository<chitietdonhang, Integer>{
    @Query(value = "select * from chitietdonhang where iddonhang = :iddonhang", nativeQuery = true)
    public List<chitietdonhang> findByIddonhang(@Param("iddonhang")int iddonhang);

}
