package com.example.webservice.nhom10.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webservice.nhom10.entity.chitietmonan;
import com.example.webservice.nhom10.entity.monan;
import com.example.webservice.nhom10.repository.chitietmonanrepo;
import com.example.webservice.nhom10.repository.monanrepo;
import com.example.webservice.nhom10.service.impl.ichitietmonanser;

@Service
public class chitietmonanser implements ichitietmonanser {
    @Autowired
    monanrepo monanrepo;
    @Autowired
    chitietmonanrepo chitietmonanrepo;
    @Override
    public String danhgiamonan(String tenmon, String danhgia) {
       
        Optional<monan> optional = monanrepo.findById(monanrepo.findIdByTenmon(tenmon));
        if(optional.isPresent()){
            chitietmonan chitietmonan = chitietmonanrepo.findByIdmonan(optional.get().getIdmonan());
        
            chitietmonan newchitiet = new chitietmonan();
            newchitiet.setDanhgia(danhgia);
            newchitiet.setIdmonan(chitietmonan.getIdmonan());
            newchitiet.setKho(chitietmonan.getKho());
            newchitiet.setMota(chitietmonan.getMota());

            chitietmonanrepo.save(newchitiet);
            return "Cảm ơn quý khách đã đánh giá món ăn.";

        }
        return "Vui lòng kiểm tra lại tên món ăn!";

    }

    

}
