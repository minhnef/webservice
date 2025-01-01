package com.example.webservice.nhom10.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webservice.nhom10.dto.NhanVienDTO;
import com.example.webservice.nhom10.dto.NhanVienUpdateDTO;
import com.example.webservice.nhom10.entity.chamcong;
import com.example.webservice.nhom10.entity.nhanvien;
import com.example.webservice.nhom10.entity.thuong;
import com.example.webservice.nhom10.repository.nhanvienrepo;
import com.example.webservice.nhom10.repository.ThuongUpdateRepository;
import com.example.webservice.nhom10.repository.chamcongrepo;
import com.example.webservice.nhom10.service.impl.inhanvienser;

@Service
public class nhanvienser implements inhanvienser {
    @Autowired
    nhanvienrepo nhanvienrepo;
    @Autowired
    chamcongrepo chamcongrepo;
    @Autowired
    private ThuongUpdateRepository thuongRepository;

    @Override
    public String chamcCongNhanVien(int id, String maxt) {
        
        try {
            Optional<nhanvien> optional = nhanvienrepo.findById(id);
            if (optional.isPresent()) {
                nhanvien nhanvien = optional.get();
                if(!nhanvien.getTaikhoannv().getMaxacthuc().equals(maxt)){
                    return "Mã xác thực không hợp lệ";
                }
                LocalDateTime time = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");
                String thoigian = time.format(formatter);
                
                String code = "Nhan vien: " + id + " diem danh luc " + thoigian;
        
                chamcong chamcong = new chamcong();
                chamcong.setIdnhanvien(id);
                chamcong.setChamcong(thoigian);
        
                // Lưu chamcong
                chamcongrepo.save(chamcong);
                
                int ngaycong = nhanvien.getNgaycong();   
                nhanvien.setNgaycong(ngaycong + 1);
                
                // Lưu nhanvien
                nhanvienrepo.save(nhanvien);
                
                return code;
            } else {
                return "Vui lòng kiểm tra lại ID";
            }
        } catch (Exception e) {
            // Ghi log lỗi
            e.printStackTrace();
            return "Đã xảy ra lỗi: " + e.getMessage();
        }
        
    }
    public List<NhanVienDTO> getAllNhanVien() {
        // Lấy danh sách tất cả nhân viên
        List<nhanvien> nhanViens = nhanvienrepo.findAll();

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

    

    public nhanvien updateNhanVien(int idnhanvien, NhanVienUpdateDTO dto) {
        nhanvien existingNhanVien = nhanvienrepo.findByIdnhanvien(idnhanvien);
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

            nhanvienrepo.save(existingNhanVien);  // Lưu nhân viên đã cập nhật
            return existingNhanVien;
        } else {
            return null;  // Nếu nhân viên không tồn tại
        }
    }

    

}
