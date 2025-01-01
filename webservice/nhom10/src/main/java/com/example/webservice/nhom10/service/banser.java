package com.example.webservice.nhom10.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webservice.nhom10.entity.ban;
import com.example.webservice.nhom10.entity.chitietdonhang;
import com.example.webservice.nhom10.entity.dondathang;
import com.example.webservice.nhom10.repository.banrepo;
import com.example.webservice.nhom10.repository.chitietdonhangrepo;
import com.example.webservice.nhom10.repository.dondathangrepo;
import com.example.webservice.nhom10.service.impl.ibanser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class banser implements ibanser {
    @Autowired
    banrepo banrepo;
    @Autowired
    dondathangrepo dondathangrepo;
    @Autowired
    chitietdonhangrepo chitietdonhangrepo;

    @Override
    public List<ban> hienThiBan() {
        return banrepo.findAll();
    }

    @Override
    public String datban(List<Integer> idbans) {
        dondathang dondathang = new dondathang();

        dondathangrepo.save(dondathang);
        chitietdonhang chitietdonhang = new chitietdonhang();
        chitietdonhangrepo.save(chitietdonhang);

        List<ban> list = banrepo.findAllById(idbans);
        int tonggiaban = 0;
        for (ban ban : list) {
            ban.setTrangthai("đã đặt");
            tonggiaban += ban.getLoaiban().getGia();
            ban.setChitietdonhang(chitietdonhang);
            // banrepo.save(ban);
        }

        chitietdonhang.setBans(list);
        chitietdonhang.setTrangthai("Chưa thanh toán");
        List<chitietdonhang> chitietdonhangs = new ArrayList<>();

        chitietdonhangs.add(chitietdonhang);
        dondathang.setChitietdonhangs(chitietdonhangs);
        chitietdonhang.setDonhang(dondathang);
        dondathang.setTonggia(tonggiaban);
        dondathangrepo.save(dondathang);
        chitietdonhangrepo.save(chitietdonhang);
        banrepo.saveAll(list);
        // return "Cảm ơn quý khách đã đặt bàn.";
        Map<String, String> response = new HashMap<>();
    response.put("message", "Cảm ơn quý khách đã đặt bàn.");

    // Use ObjectMapper to convert the object to JSON string
    ObjectMapper objectMapper = new ObjectMapper();
    try {
        return objectMapper.writeValueAsString(response);
    } catch (JsonProcessingException e) {
        // Handle potential exception during conversion
        e.printStackTrace();
        return "Error"; // Or a more user-friendly error message
    }

    }

}
