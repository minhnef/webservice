package com.example.webservice.nhom10.service;

import com.example.webservice.nhom10.dto.ThuongDTO;
import com.example.webservice.nhom10.entity.thuong;
import com.example.webservice.nhom10.repository.ThuongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ThuongService {

    @Autowired
    private ThuongRepository thuongRepository;

    public List<ThuongDTO> getThuongByNhanVienId(int idnhanvien) {
        List<thuong> thuongList = thuongRepository.findByNhanvienIdnhanvien(idnhanvien);
        return thuongList.stream()
                .map(t -> new ThuongDTO(t.getIdthuong(), t.getThuong(), t.getLydo(), t.getNhanvien().getIdnhanvien())) // Truyền idthuong, thuong và lydo
                .collect(Collectors.toList());
    }

    // Lấy tất cả thông tin thưởng
    public List<ThuongDTO> getAllThuong() {
        List<thuong> thuongList = thuongRepository.findAll();
        return thuongList.stream()
                .map(thuong -> new ThuongDTO(thuong.getIdthuong(), thuong.getThuong(), thuong.getLydo(), thuong.getNhanvien().getIdnhanvien()))
                .collect(Collectors.toList());
    }
}
