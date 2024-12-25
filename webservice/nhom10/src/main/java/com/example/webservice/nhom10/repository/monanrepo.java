package com.example.webservice.nhom10.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.webservice.nhom10.entity.monan;




@Repository
public interface monanrepo extends JpaRepository<monan, Integer>{
    @Query(value = "select m.idmonan from monan m where m.tenmon like :tenmonan", nativeQuery = true)
    public int findIdByTenmon(@Param("tenmonan")String tenmonan);

}
