package com.example.webservice.nhom10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.webservice.nhom10.entity.chitietmonan;
@Repository
public interface chitietmonanrepo extends JpaRepository<chitietmonan, Integer>{
    @Query(value = "select * from chitietmonan where idmonan = :idmon and idchitiet = (select max(idchitiet) from chitietmonan where idmonan = :idmon)", nativeQuery = true)
    public chitietmonan findByIdmonan(@Param("idmon")int idmon);

}
