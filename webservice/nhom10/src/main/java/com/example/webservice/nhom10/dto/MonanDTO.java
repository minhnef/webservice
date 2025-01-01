package com.example.webservice.nhom10.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MonanDTO {
    private int idmonan;
    private String tenmon;
    private int gia;
    private String image;
}
