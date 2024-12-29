package com.example.webservice.nhom10.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data

public class LichLamViecDTO {

    @JsonProperty("id")
    private int id;

    @JsonProperty("ngayBatDau")
    private LocalDate ngaybatdau;

    @JsonProperty("ngayKetThuc")
    private LocalDate ngayketthuc;

    @JsonProperty("idNhanVien")
    private int idnhanvien;

    @JsonProperty("hoTenNhanVien")
    private String hoten;

    // Constructor không có đối số (có thể giữ lại nếu cần)
    public LichLamViecDTO() {}

    // Constructor có đối số để khởi tạo với các giá trị cụ thể
    public LichLamViecDTO(int id, LocalDate ngaybatdau, LocalDate ngayketthuc, int idNhanVien, String hoTenNhanVien) {
        this.id = id;  // Đảm bảo sử dụng 'id' thay vì 'idlichlam'
        this.ngaybatdau = ngaybatdau;
        this.ngayketthuc = ngayketthuc;
        this.idnhanvien = idNhanVien;  // Lưu ý dùng đúng tên trường 'idnhanvien'
        this.hoten = hoTenNhanVien;  // Lưu ý dùng đúng tên trường 'hoten'
    }

}
