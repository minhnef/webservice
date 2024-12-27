package com.example.webservice.nhom10.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.webservice.nhom10.entity.khuyenmai;
@Repository
public interface khuyenmairepo extends JpaRepository<khuyenmai, Integer>{
    @Query(value = "select * from khuyenmai where khuyenmai like :tenkhuyenmai", nativeQuery = true)
    public Optional<khuyenmai> findByKhuyenMai(@Param("tenkhuyenmai") String tenkhuyenmai);

}
