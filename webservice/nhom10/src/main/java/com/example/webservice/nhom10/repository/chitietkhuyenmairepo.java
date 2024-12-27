package com.example.webservice.nhom10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.webservice.nhom10.entity.chitietkhuyenmai;
@Repository
public interface chitietkhuyenmairepo extends JpaRepository<chitietkhuyenmai, Integer>{
    @Query(value = "select dieukien from chitietkhuyenmai where idkm =:idkm", nativeQuery = true)
    public int[] getDieuKienByTenKM(@Param("idkm") int idkm);

    @Query(value = "select max(giamgia) from chitietkhuyenmai where idkm =:idkm and dieukien <= :diemtichluy", nativeQuery = true)
    public String getGiamgia(@Param("idkm")int idkm, @Param("diemtichluy") int diemtichluy);
}
