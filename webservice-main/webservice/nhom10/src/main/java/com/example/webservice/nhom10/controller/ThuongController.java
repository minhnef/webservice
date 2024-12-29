package com.example.webservice.nhom10.controller;

import com.example.webservice.nhom10.dto.ThuongDTO;
import com.example.webservice.nhom10.service.ThuongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ThuongController {

    @Autowired
    private ThuongService thuongService;

    @GetMapping("/thuong/{idnhanvien}")
    public List<ThuongDTO> getThuongByNhanVienId(@PathVariable int idnhanvien) {
        return thuongService.getThuongByNhanVienId(idnhanvien);
    }
    @GetMapping("/thuong")
    public List<ThuongDTO> getAllThuong() {
        return thuongService.getAllThuong();
    }
}
