package com.example.webservice.nhom10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.webservice.nhom10.service.donhangser;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/apidonhang")
public class dondathangcontroller {
    @Autowired
    donhangser donhangser;

    @PutMapping("thanhtoandonhang")
    public String thanhtoan(@RequestParam int id, @RequestParam int tientra) { 
        return donhangser.thanhtoan(id, tientra);
    }
}
