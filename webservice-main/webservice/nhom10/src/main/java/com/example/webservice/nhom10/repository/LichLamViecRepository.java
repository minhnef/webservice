package com.example.webservice.nhom10.repository;

import com.example.webservice.nhom10.entity.lichlamviec;
import com.example.webservice.nhom10.service.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LichLamViecRepository extends JpaRepository<lichlamviec, Integer> {

}
