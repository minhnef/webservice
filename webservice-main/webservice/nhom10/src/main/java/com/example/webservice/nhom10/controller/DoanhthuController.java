package com.example.webservice.nhom10.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import com.example.webservice.nhom10.dto.DoanhthuDTO;
import com.example.webservice.nhom10.service.DondathangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:63342")
@RequestMapping("/api/dondathang")
public class DoanhthuController {

    @Autowired
    private DondathangService dondathangService;

    @GetMapping("/doanhthu")
    public List<DoanhthuDTO> getTotalRevenue() {
        return dondathangService.calculateTotalRevenue();
    }

    @GetMapping("/doanhthu/{id}")
    public DoanhthuDTO getRevenueForOrder(@PathVariable int id) {
        return dondathangService.calculateRevenueForOrder(id);
    }
}
