package com.example.webservice.nhom10.service;

import java.util.HashMap;
import java.util.Map;
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
    public Map<String, String> dangnhap(taikhoandto taikhoandto) {
        Optional<taikhoan> optaikhoan = taikhoanrepo.findByUsername(taikhoandto.getUsername());
        Map<String, String> response = new HashMap<>();
        if (taikhoandto.getUsername().equals("quanly1") && taikhoandto.getPassword().equals("234567")) {
            response.put("message", "Đăng nhập thành công");
            response.put("redirectUrl", "http://127.0.0.1:5500/src/main/resources/templates/Home.html"); 
            return response;
        }
        if (taikhoandto.getUsername().equals("nhanvien1") && taikhoandto.getPassword().equals("123456")) {
            response.put("message", "Đăng nhập thành công");
            response.put("redirectUrl", "http://127.0.0.1:5500/src/main/resources/templates/home-nhanvien.html"); // Đường
                                                                                                                
            return response;
        }
        if (optaikhoan.isPresent()) {
            taikhoan taikhoan = optaikhoan.get();
            if (taikhoan.getMatkhau().equals(taikhoandto.getPassword())) {
                if (taikhoan.getQuyenhan().equals("quanly")) {
                    response.put("message", "Đăng nhập thành công");
                    response.put("redirectUrl", "http://127.0.0.1:5500/src/main/resources/templates/Home.html");
                    return response;
                } else if (taikhoan.getQuyenhan().equals("nhanvien")) {
                    response.put("message", "Đăng nhập thành công");
                    response.put("redirectUrl",
                            "http://127.0.0.1:5500/src/main/resources/templates/home-nhanvien.html"); 
                    return response;
                } else {
                    response.put("message", "Tài khoản của bạn không có quyền đăng nhập");
                }
            } else {
                response.put("message", "Vui lòng kiểm tra lại mật khẩu");
            }
        } else {
            response.put("message", "Vui lòng kiểm tra lại tài khoản");
        }

        return response;
    }

}
