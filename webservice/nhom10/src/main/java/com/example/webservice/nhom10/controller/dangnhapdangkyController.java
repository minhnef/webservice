package com.example.webservice.nhom10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.webservice.nhom10.service.dangnhapdangkyser;
import com.example.webservice.nhom10.dto.UserDTO;

@RestController
@RequestMapping(value = "/api/auth")
public class dangnhapdangkycontroller {
    
    @Autowired
    dangnhapdangkyser dangnhapdangkyser;

    // API Đăng ký
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserDTO userDTO) {
        try {
            return ResponseEntity.ok(dangnhapdangkyser.register(userDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    // API Đăng nhập
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDTO userDTO) {
        try {
            return ResponseEntity.ok(dangnhapdangkyser.login(userDTO));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}
