package com.example.webservice.nhom10.service;

import com.example.webservice.nhom10.entity.monan;
import com.example.webservice.nhom10.repository.MonanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.webservice.nhom10.dto.TopMonanDTO;
import com.example.webservice.nhom10.repository.ChitietdonhangRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class MonanService {
    @Autowired
    private MonanRepository monanRepository;

    public List<monan> getAllMonans() {
        return monanRepository.findAll();
    }
    @Autowired
    private ChitietdonhangRepository chitietdonhangRepository;

    public List<TopMonanDTO> getTop5MostSoldMonan() {
        Pageable pageable = PageRequest.of(0, 5);
        return chitietdonhangRepository.findTop5MostSoldMonan(pageable);
    }
}
