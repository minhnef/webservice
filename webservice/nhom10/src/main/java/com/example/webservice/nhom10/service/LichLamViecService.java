package com.example.webservice.nhom10.service;

import com.example.webservice.nhom10.dto.LichLamViecDTO;
import com.example.webservice.nhom10.entity.lichlamviec;
import com.example.webservice.nhom10.entity.nhanvien;

import com.example.webservice.nhom10.repository.ilichlamviecrepo;
import com.example.webservice.nhom10.repository.nhanvienrepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LichLamViecService {

    @Autowired
    private ilichlamviecrepo lichLamViecRepository;

    public List<LichLamViecDTO> getAllLichLamViec() {
        List<lichlamviec> lichLamViecs = lichLamViecRepository.findAll();
        if (lichLamViecs.isEmpty()) {
            // Thêm log để kiểm tra xem có dữ liệu không
            System.out.println("No data found in LichLamViec");
        }
        return lichLamViecs.stream()
                .map(lichLamViec -> new LichLamViecDTO(
                        lichLamViec.getIdlichlam(),
                        lichLamViec.getNgaybatdau(),
                        lichLamViec.getNgayketthuc(),
                        lichLamViec.getNhanvien().getIdnhanvien(),
                        lichLamViec.getNhanvien().getHoten()
                ))
                .collect(Collectors.toList());
    }



    @Autowired
    private nhanvienrepo nhanVienRepository;

    @Transactional
    public LichLamViecDTO addLichLamViec(String hoten, LocalDate ngayBatDau, LocalDate ngayKetThuc) {
        // Tìm kiếm nhân viên theo tên
        nhanvien nhanVien = nhanVienRepository.findByHoten(hoten);


        // Tạo một đối tượng LichLamViec mới và thiết lập các thông tin
        lichlamviec lichLamViec = new lichlamviec();
        lichLamViec.setNgaybatdau(ngayBatDau);
        lichLamViec.setNgayketthuc(ngayKetThuc);
        lichLamViec.setNhanvien(nhanVien);

        // Lưu lịch làm việc vào cơ sở dữ liệu
         lichLamViecRepository.save(lichLamViec);

        // Chuyển đổi đối tượng LichLamViec thành LichLamViecDTO để trả về
        LichLamViecDTO lichLamViecDTO = new LichLamViecDTO();
        lichLamViecDTO.setId(lichLamViec.getIdlichlam());
        lichLamViecDTO.setNgaybatdau(lichLamViec.getNgaybatdau());
        lichLamViecDTO.setNgayketthuc(lichLamViec.getNgayketthuc());
        lichLamViecDTO.setIdnhanvien(nhanVien.getIdnhanvien());
        lichLamViecDTO.setHoten(nhanVien.getHoten());

        return lichLamViecDTO;
    }


    public boolean updateLichLamViec(int id, LocalDate ngayBatDau, LocalDate ngayKetThuc) {
        // Tìm nhân viên trong cơ sở dữ liệu theo ID
        lichlamviec lichLamViec = lichLamViecRepository.findById(id).orElse(null);

        if (lichLamViec != null) {
            // Cập nhật ngày bắt đầu và ngày kết thúc
            lichLamViec.setNgaybatdau(ngayBatDau);
            lichLamViec.setNgayketthuc(ngayKetThuc);
            lichLamViecRepository.save(lichLamViec);  // Lưu lại thay đổi vào cơ sở dữ liệu
            return true;
        } else {
            return false;
        }
    }


    // Xóa các bản ghi liên quan đến nhân viên với idNhanVien
    // Xóa lịch làm việc của nhân viên theo ID
    // Phương thức xóa dữ liệu dựa trên idLichLamViec
    public boolean deleteLichLamViecById(int idLichLamViec) {
        // Kiểm tra xem có tồn tại bản ghi với idLichLamViec hay không
        if (lichLamViecRepository.existsById(idLichLamViec)) {
            // Xóa bản ghi
            lichLamViecRepository.deleteById(idLichLamViec);
            return true;
        }
        return false; // Nếu không tìm thấy idLichLamViec
    }
}
