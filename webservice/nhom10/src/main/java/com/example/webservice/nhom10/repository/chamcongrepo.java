package com.example.webservice.nhom10.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.webservice.nhom10.entity.chamcong;
@Repository
public interface chamcongrepo extends JpaRepository<chamcong, Integer>{
    @Query(value = "select max(id) from chamcong")
    public Integer getMaxID();
    

}
