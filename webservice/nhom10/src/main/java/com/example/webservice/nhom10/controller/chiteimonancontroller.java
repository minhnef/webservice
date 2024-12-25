package com.example.webservice.nhom10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.webservice.nhom10.service.chitietmonanser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/apidanhgia")
public class chiteimonancontroller {
    @Autowired
    chitietmonanser chitietmonanser;

    @GetMapping("/danhgia")
    public String danhgiatheoten(@RequestParam String tenmon, @RequestParam String danhgia) {
        return chitietmonanser.danhgiamonan(tenmon, danhgia);
    }
    
}
