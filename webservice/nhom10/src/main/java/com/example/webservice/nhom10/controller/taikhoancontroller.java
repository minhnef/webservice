package com.example.webservice.nhom10.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.webservice.nhom10.dto.taikhoandto;
import com.example.webservice.nhom10.service.taikhoanser;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/apitaikhoan")
public class taikhoancontroller {
   @Autowired
   taikhoanser taikhoanser;

   @PostMapping("/dangnhap")
    public ResponseEntity<Map<String, String>> dangnhap(@RequestBody taikhoandto taikhoandto) {
        Map<String, String> response = taikhoanser.dangnhap(taikhoandto);
        return ResponseEntity.ok(response);
    }

}
