package com.example.webservice.nhom10.controller;
import com.example.webservice.nhom10.dto.NhanVienDTO;
import com.example.webservice.nhom10.dto.NhanVienUpdateDTO;
import com.example.webservice.nhom10.entity.thuong;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import com.example.webservice.nhom10.entity.nhanvien;
import com.example.webservice.nhom10.service.NhanVienService;
import com.example.webservice.nhom10.dto.NhanVienThuongDTO;
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
//
//    @GetMapping("/thuong")
//    public List<NhanVienThuongDTO> getNhanVienWithThuong() {
//        return nhanVienService.getNhanVienWithThuong();
//    }
    // Lấy tất cả thông tin nhân viên
    @GetMapping("/all")
    public List<NhanVienDTO> getAllNhanVien() {
        return nhanVienService.getAllNhanVien();
    }


    @PutMapping("/update/{idnhanvien}")
    public ResponseEntity<nhanvien> updateNhanVien(@PathVariable int idnhanvien,
                                                   @RequestBody NhanVienUpdateDTO dto) {
        nhanvien updatedNhanVien = nhanVienService.updateNhanVien(idnhanvien, dto);
        if (updatedNhanVien != null) {
            return new ResponseEntity<>(updatedNhanVien, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}

