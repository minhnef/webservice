package com.example.webservice.nhom10.repository;

import com.example.webservice.nhom10.entity.danhmucmonan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DanhMucRepo extends JpaRepository<danhmucmonan,Integer> {
}
