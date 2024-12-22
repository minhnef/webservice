package com.example.webservice.nhom10.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class response<T> {
    private int id;
    private String message;
    private T data;
}
