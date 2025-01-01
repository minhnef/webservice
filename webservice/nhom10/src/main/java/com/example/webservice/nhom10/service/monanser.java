package com.example.webservice.nhom10.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.webservice.nhom10.dto.TopMonanDTO;
import com.example.webservice.nhom10.entity.monan;
import com.example.webservice.nhom10.repository.chitietdonhangrepo;
import com.example.webservice.nhom10.repository.monanrepo;
import com.example.webservice.nhom10.service.impl.imonanser;

@Service
public class monanser implements imonanser{
    @Autowired
    monanrepo monanrepo;
    @Autowired
    chitietdonhangrepo chitietdonhangrepo;
    @Override
    public List<monan> menu() {
        return monanrepo.findAll();
    }

    public List<monan> getAllMonans(){
        return monanrepo.findAll();
    }

    public List<TopMonanDTO> getTop5MostSoldMonan() {
        Pageable pageable = PageRequest.of(0, 5);
        return chitietdonhangrepo.findTop5MostSoldMonan(pageable);
    }
}
