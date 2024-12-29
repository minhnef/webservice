package com.example.webservice.nhom10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.webservice.nhom10.entity.ban;
import com.example.webservice.nhom10.service.banser;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("apidatban")
public class bancontroller {
    @Autowired
    banser banser;

    @GetMapping("ban")
    public List<ban> hienThList() {
        return banser.hienThiBan();
    }

    @PutMapping("datban")
    public String datban(@RequestBody List<Integer> listId) {
        
        return banser.datban(listId);
    }
    

}
