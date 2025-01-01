package com.example.webservice.nhom10.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.webservice.nhom10.dto.TopMonanDTO;
import com.example.webservice.nhom10.entity.chitietdonhang;
@Repository
public interface chitietdonhangrepo extends JpaRepository<chitietdonhang, Integer>{
    @Query(value = "select * from chitietdonhang where iddonhang = :iddonhang", nativeQuery = true)
    public List<chitietdonhang> findByIddonhang(@Param("iddonhang")int iddonhang);
    @Query("SELECT new com.example.webservice.nhom10.dto.TopMonanDTO(c.idmonan.idmonan, c.idmonan.tenmon, COUNT(c.idmonan)) " +
            "FROM chitietdonhang c " +
            "GROUP BY c.idmonan " +
            "ORDER BY COUNT(c.idmonan) DESC")
    public List<TopMonanDTO> findTop5MostSoldMonan(Pageable pageable);

}
