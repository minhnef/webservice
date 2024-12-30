package com.example.webservice.nhom10.controller;

import com.example.webservice.nhom10.dto.LichLamViecDTO;
import com.example.webservice.nhom10.dto.LichLamViecRequest;
import com.example.webservice.nhom10.service.LichLamViecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lichlamviec")
@CrossOrigin(origins = "http://localhost:63342")
public class LichLamViecController {

    @Autowired
    private LichLamViecService lichLamViecService;

    @GetMapping
    public List<LichLamViecDTO> getAllLichLamViec() {
        return lichLamViecService.getAllLichLamViec();
    }

    @PostMapping("/add")
    public ResponseEntity<LichLamViecDTO> addLichLamViec(@RequestBody LichLamViecRequest request) {
        // Gọi service để xử lý yêu cầu
        LichLamViecDTO lichLamViecDTO = lichLamViecService.addLichLamViec(
                request.getHoTen(),
                request.getNgayBatDau(),
                request.getNgayKetThuc()
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(lichLamViecDTO);
    }




    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateLichLamViec(
            @PathVariable("id") int id,
            @RequestBody LichLamViecRequest request) {

        boolean updated = lichLamViecService.updateLichLamViec(id, request.getNgayBatDau(), request.getNgayKetThuc());

        if (updated) {
            return ResponseEntity.status(HttpStatus.OK).body("Cập nhật lịch làm việc thành công.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy nhân viên với ID này.");
        }
    }


    // API để xóa dữ liệu theo idLichLamViec
    @DeleteMapping("/delete/{idLichLamViec}")
    public ResponseEntity<String> deleteLichLamViec(@PathVariable int idLichLamViec) {
        boolean isDeleted = lichLamViecService.deleteLichLamViecById(idLichLamViec);
        if (isDeleted) {
            return ResponseEntity.ok("Lịch làm việc đã được xóa.");
        } else {
            return ResponseEntity.status(404).body("Không tìm thấy lịch làm việc với idLichLamViec này.");
        }
    }
}
