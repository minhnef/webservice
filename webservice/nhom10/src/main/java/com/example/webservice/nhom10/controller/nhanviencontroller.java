package com.example.webservice.nhom10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.example.webservice.nhom10.service.nhanvienser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping(value = "/apinhanvien")
public class nhanviencontroller {
    @Autowired
    nhanvienser nhanvienser;

    @GetMapping("/chamcong")
    public String chamCong(@RequestParam int id) {
        try {   
            return nhanvienser.chamcCongNhanVien(id);
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }

}
