package com.example.webservice.nhom10.controller;

import java.net.URLDecoder;

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
    public String danhgia(@RequestParam String mahoatenmon, @RequestParam String mahoadanhgia) {
        // String tenmon, danhgia;
        // try {
        //      tenmon = URLDecoder.decode(mahoatenmon, "UTF-8");
        //      danhgia = URLDecoder.decode(mahoadanhgia, "UTF-8");
        // } catch (Exception e) {
        //     // TODO: handle exception
        //     return e.getMessage();
        // }
        
        
        return chitietmonanser.danhgiamonan(mahoatenmon, mahoadanhgia);
    }

}
