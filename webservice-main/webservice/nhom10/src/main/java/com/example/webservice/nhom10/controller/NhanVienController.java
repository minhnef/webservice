package com.example.webservice.nhom10.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import com.example.webservice.nhom10.entity.nhanvien;
import com.example.webservice.nhom10.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:63342")
@RequestMapping("/nhanvien")
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService;

    // Lấy tất cả thông tin nhân viên
    @GetMapping("/all")
    public List<nhanvien> getAllNhanVien() {
        return nhanVienService.getAllNhanVien();
    }
}

