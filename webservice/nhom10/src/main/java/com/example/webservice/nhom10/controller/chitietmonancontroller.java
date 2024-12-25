package com.example.webservice.nhom10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.webservice.nhom10.service.chitietmonanser;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/apichitiet")
public class chitietmonancontroller {
    @Autowired
    chitietmonanser chitietmonanser;

    @GetMapping("/danhgia")
    public String danhgia(@RequestParam String tenmon, @RequestParam String danhgia) {
        //TODO: process POST request
        
        return chitietmonanser.danhgiamonan(tenmon, danhgia);
    }
    



}
