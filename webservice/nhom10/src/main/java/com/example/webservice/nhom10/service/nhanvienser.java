package com.example.webservice.nhom10.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webservice.nhom10.dto.response;
import com.example.webservice.nhom10.entity.chamcong;
import com.example.webservice.nhom10.entity.nhanvien;

import com.example.webservice.nhom10.repository.nhanvienrepo;
import com.example.webservice.nhom10.repository.chamcongrepo;
import com.example.webservice.nhom10.service.impl.inhanvienser;

@Service
public class nhanvienser implements inhanvienser {
    @Autowired
    nhanvienrepo nhanvienrepo;
    @Autowired
    chamcongrepo chamcongrepo;


    @Override
    public String chamcCongNhanVien(int id) {
        
        try {
            Optional<nhanvien> optional = nhanvienrepo.findById(id);
            if (optional.isPresent()) {
                nhanvien nhanvien = optional.get();
        
                LocalDateTime time = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");
                String thoigian = time.format(formatter);
                
                String code = "Nhan vien: " + id + " diem danh luc " + thoigian;
        
                chamcong chamcong = new chamcong();
                chamcong.setIdnhanvien(id);
                chamcong.setChamcong(thoigian);
        
                // Lưu chamcong
                chamcongrepo.save(chamcong);
                
                int ngaycong = nhanvien.getNgaycong();   
                nhanvien.setNgaycong(ngaycong + 1);
                
                // Lưu nhanvien
                nhanvienrepo.save(nhanvien);
                
                return code;
            } else {
                return "Vui lòng kiểm tra lại ID";
            }
        } catch (Exception e) {
            // Ghi log lỗi
            e.printStackTrace();
            return "Đã xảy ra lỗi: " + e.getMessage();
        }
        
    }

}
