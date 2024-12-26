package com.example.webservice.nhom10.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webservice.nhom10.entity.chitietdonhang;
import com.example.webservice.nhom10.entity.dondathang;
import com.example.webservice.nhom10.repository.chitietdonhangrepo;
import com.example.webservice.nhom10.repository.chitietkhuyenmairepo;
import com.example.webservice.nhom10.repository.dondathangrepo;
import com.example.webservice.nhom10.service.impl.idonhangser;

@Service
public class donhangser implements idonhangser{
    @Autowired
    dondathangrepo dondathangrepo;
    @Autowired
    chitietkhuyenmairepo chitietkhuyenmairepo;
    @Autowired
    chitietdonhangrepo chitietdonhangrepo;

    @Override
    public String thanhtoan(int iddh, int tientra) {
        Optional<dondathang> opdonhang = dondathangrepo.findById(iddh);
        if(opdonhang.isPresent()){
            dondathang dondathang = opdonhang.get();
            int tienthua = dondathang.getTonggia() - tientra;
            List<chitietdonhang> listchitiet = chitietdonhangrepo.findByIddonhang(dondathang.getIddonhang());
            
                for (chitietdonhang chitietdonhang2 : listchitiet) {
                    chitietdonhang2.setTrangthai("Đã thanh toán");
                    chitietdonhangrepo.save(chitietdonhang2);
                }
           if(tienthua == 0){
            return "Cảm ơn quý khách đã thanh toán!";
            }else{
                return "Cảm ơn quý khách đã thanh toán! Vui lòng nhận lại: "+tienthua+"VND";
            }
        }else{
            
        }
        return "";
    }

    @Override
    public String khuyenmai(int iddh, int idkm) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'khuyenmai'");
    }

}
