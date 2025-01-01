package com.example.webservice.nhom10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.webservice.nhom10.dto.NhanVienDTO;
import com.example.webservice.nhom10.dto.NhanVienUpdateDTO;
import com.example.webservice.nhom10.entity.nhanvien;
import com.example.webservice.nhom10.service.nhanvienser;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping(value = "/apinhanvien")
public class nhanviencontroller {
    @Autowired
    nhanvienser nhanvienser;

    @GetMapping("/chamcong")
    public ResponseEntity<?> chamCong(@RequestParam int id, @RequestParam String maxt) {
       return ResponseEntity.ok(nhanvienser.chamcCongNhanVien(id, maxt));
    }

     @GetMapping("/all")
    public List<NhanVienDTO> getAllNhanVien() {
        return nhanvienser.getAllNhanVien();
    }


    @PutMapping("/update/{idnhanvien}")
    public ResponseEntity<nhanvien> updateNhanVien(@PathVariable int idnhanvien,
                                                   @RequestBody NhanVienUpdateDTO dto) {
        nhanvien updatedNhanVien = nhanvienser.updateNhanVien(idnhanvien, dto);
        if (updatedNhanVien != null) {
            return new ResponseEntity<>(updatedNhanVien, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
