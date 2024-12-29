package com.example.webservice.nhom10.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webservice.nhom10.entity.monan;
import com.example.webservice.nhom10.repository.monanrepo;
import com.example.webservice.nhom10.service.impl.imonanser;

@Service
public class monanser implements imonanser{
    @Autowired
    monanrepo monanrepo;
    @Override
    public List<monan> menu() {
        return monanrepo.findAll();
    }

}
