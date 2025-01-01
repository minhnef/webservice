package com.example.webservice.nhom10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.webservice.nhom10.dto.TopMonanDTO;
import com.example.webservice.nhom10.entity.monan;
import com.example.webservice.nhom10.service.monanser;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("apithucdon")
public class monancontroller {
    @Autowired
    monanser monanser;
    @GetMapping
    public List<monan> getAllMonans() {
        return monanser.getAllMonans();
    }

    @GetMapping("menu")
    public List<monan> menuList() {
        return monanser.menu();
    }
   

    @GetMapping("/top5")
    public List<TopMonanDTO> getTop5MostSoldMonan() {
        return monanser.getTop5MostSoldMonan();
    }

}
