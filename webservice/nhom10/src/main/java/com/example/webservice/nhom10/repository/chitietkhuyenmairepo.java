package com.example.webservice.nhom10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.webservice.nhom10.entity.chitietkhuyenmai;
@Repository
public interface chitietkhuyenmairepo extends JpaRepository<chitietkhuyenmai, Integer>{

}