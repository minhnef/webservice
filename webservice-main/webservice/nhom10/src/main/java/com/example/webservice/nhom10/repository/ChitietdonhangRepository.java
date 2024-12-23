package com.example.webservice.nhom10.repository;

import com.example.webservice.nhom10.dto.TopMonanDTO;
import com.example.webservice.nhom10.entity.chitietdonhang;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChitietdonhangRepository extends JpaRepository<chitietdonhang, Integer> {

    @Query("SELECT new com.example.webservice.nhom10.dto.TopMonanDTO(c.idmonan.idmonan, c.idmonan.tenmon, COUNT(c.idmonan)) " +
            "FROM chitietdonhang c " +
            "GROUP BY c.idmonan " +
            "ORDER BY COUNT(c.idmonan) DESC")
    List<TopMonanDTO> findTop5MostSoldMonan(Pageable pageable);
}
