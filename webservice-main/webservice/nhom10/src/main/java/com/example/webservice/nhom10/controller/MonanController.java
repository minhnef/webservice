package com.example.webservice.nhom10.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import com.example.webservice.nhom10.entity.monan;
import com.example.webservice.nhom10.service.MonanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.webservice.nhom10.dto.TopMonanDTO;
import java.util.List;

@RestController
@RequestMapping("/api/monan")
@CrossOrigin(origins = "http://localhost:63342")
public class MonanController {

    @Autowired
    private MonanService monanService;

    @GetMapping
    public List<monan> getAllMonans() {
        return monanService.getAllMonans();
    }

    @GetMapping("/top5")
    public List<TopMonanDTO> getTop5MostSoldMonan() {
        return monanService.getTop5MostSoldMonan();
    }
}
