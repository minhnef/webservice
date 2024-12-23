package com.example.webservice.nhom10.service;

import com.example.webservice.nhom10.dto.DoanhthuDTO;
import com.example.webservice.nhom10.entity.dondathang;
import com.example.webservice.nhom10.repository.DondathangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DondathangService {

    @Autowired
    private DondathangRepository dondathangRepository;

    public List<DoanhthuDTO> calculateTotalRevenue() {
        List<dondathang> allOrders = dondathangRepository.findAll();
        List<DoanhthuDTO> doanhthuDTOList = new ArrayList<>();

        for (dondathang order : allOrders) {
            doanhthuDTOList.add(new DoanhthuDTO(order.getIddonhang(), order.getTonggia()));
        }

        return doanhthuDTOList;
    }

    public DoanhthuDTO calculateRevenueForOrder(int id) {
        dondathang order = dondathangRepository.findById(id).orElse(null);
        if (order != null) {
            return new DoanhthuDTO(order.getIddonhang(), order.getTonggia());
        } else {
            return null;
        }
    }
}
