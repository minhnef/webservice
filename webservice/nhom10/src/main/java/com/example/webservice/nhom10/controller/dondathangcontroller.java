package com.example.webservice.nhom10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.webservice.nhom10.dto.DonHangDTO;
import com.example.webservice.nhom10.service.donhangser;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/apidonhang")
public class dondathangcontroller {
    @Autowired
    donhangser donhangser;

    @GetMapping("xemdon")
    public ResponseEntity<?> hienthidon(@RequestParam int id ) {
        return  ResponseEntity.ok(donhangser.hienthi(id));
    }
    

    @PutMapping("thanhtoandonhang")
    public String thanhtoan(@RequestBody DonHangDTO donHangDTO) {
        try {
            int iddh = donHangDTO.getId();
            int tientradh = donHangDTO.getTientra();
            return donhangser.thanhtoan(iddh, tientradh);
        } catch (Exception e) {
            // TODO: handle exception
            return e.getMessage();
        }

    }

    @PutMapping("apmavoucher")
    public String putMethodName( @RequestBody DonHangDTO donHangDTO) {
        int iddh = donHangDTO.getId();
        String voucher= donHangDTO.getVoucher();
        
        return donhangser.khuyenmai(iddh, voucher);
    }
}
