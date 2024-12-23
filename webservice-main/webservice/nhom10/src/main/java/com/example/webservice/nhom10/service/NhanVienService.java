package com.example.webservice.nhom10.service;

import com.example.webservice.nhom10.entity.nhanvien;
import com.example.webservice.nhom10.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhanVienService {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    public List<nhanvien> getAllNhanVien() {
        return nhanVienRepository.findAll();
    }
}

