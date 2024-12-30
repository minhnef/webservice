package com.example.webservice.nhom10.service;

import com.example.webservice.nhom10.dto.NhanVienDTO;
import com.example.webservice.nhom10.dto.NhanVienUpdateDTO;
import com.example.webservice.nhom10.entity.nhanvien;
import com.example.webservice.nhom10.dto.NhanVienThuongDTO;
import com.example.webservice.nhom10.entity.thuong;
import com.example.webservice.nhom10.repository.NhanVienRepository;
import com.example.webservice.nhom10.repository.ThuongRepository;
import com.example.webservice.nhom10.repository.ThuongUpdateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NhanVienService {
    @Autowired
    private NhanVienRepository nhanVienRepository;

//    public List<NhanVienThuongDTO> getNhanVienWithThuong() {
//        return nhanVienRepository.findNhanVienWithThuong()
//                .stream()
//                .map(record -> new NhanVienThuongDTO(
//                        (int) record[0],
//                        (String) record[1],
//                        (float) record[2],
//                        (String) record[3]))
//                .collect(Collectors.toList());
//    }

    public List<NhanVienDTO> getAllNhanVien() {
        // Lấy danh sách tất cả nhân viên
        List<nhanvien> nhanViens = nhanVienRepository.findAll();

        // Chuyển đổi nhân viên thành NhanVienDTO
        return nhanViens.stream().map(nv -> {
            NhanVienDTO dto = new NhanVienDTO();
            dto.setIdnhanvien(nv.getIdnhanvien());
            dto.setHoten(nv.getHoten());
            dto.setLuong(nv.getLuong());
            dto.setNgaysinh(nv.getNgaysinh());
            dto.setDiachi(nv.getDiachi());
            dto.setSdt(nv.getSdt());
            return dto;
        }).collect(Collectors.toList());
    }

    @Autowired
    private ThuongUpdateRepository thuongRepository;

    public nhanvien updateNhanVien(int idnhanvien, NhanVienUpdateDTO dto) {
        nhanvien existingNhanVien = nhanVienRepository.findByIdnhanvien(idnhanvien);
        if (existingNhanVien != null) {
            // Cập nhật lương
            existingNhanVien.setLuong(dto.getLuong());

            // Cập nhật thưởng cho tất cả các phần thưởng của nhân viên
            List<thuong> thuongs = existingNhanVien.getThuongs();
            for (thuong existingThuong : thuongs) {
                existingThuong.setThuong(dto.getThuong());
                existingThuong.setLydo(dto.getLydo());
                thuongRepository.save(existingThuong);  // Lưu thưởng đã cập nhật
            }

            nhanVienRepository.save(existingNhanVien);  // Lưu nhân viên đã cập nhật
            return existingNhanVien;
        } else {
            return null;  // Nếu nhân viên không tồn tại
        }
    }

}

