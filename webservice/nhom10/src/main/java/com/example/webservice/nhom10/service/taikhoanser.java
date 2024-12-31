package com.example.webservice.nhom10.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webservice.nhom10.dto.taikhoandto;
import com.example.webservice.nhom10.entity.taikhoan;
import com.example.webservice.nhom10.repository.taikhoanrepo;
import com.example.webservice.nhom10.service.impl.itaikhoanser;

@Service
public class taikhoanser implements itaikhoanser {
    @Autowired
    taikhoanrepo taikhoanrepo;

    @Override
    public String dangnhap(taikhoandto taikhoandto) {
        Optional<taikhoan> optaikhoan = taikhoanrepo.findByUsername(taikhoandto.getUsername());
        if (optaikhoan.isPresent()) {
            taikhoan taikhoan = optaikhoan.get();
            if (taikhoan.getMatkhau().equals(taikhoandto.getPassword())) {
                if (taikhoan.getQuyenhan().equals("quanly")) {
                    // điều hướng tới trang chủ quản lý
                    return "";
                } else if (taikhoan.getQuyenhan().equals("nhanvien")) {
                    // điều hướng tới trang chủ nhân viên
                    return "";
                } else {
                    return "Bạn chưa được cập nhật quyền đăng nhập vào hệ thống.";
                }
            }
            return "Mật khẩu không chính xác";

        }
        return "Vui lòng kiểm tra lại tên đăng nhập";
    }

}
