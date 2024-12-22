package com.example.webservice.nhom10.dto;

import lombok.Data;

@Data
public class request<T> {
    private int id;
    private String message;
    private T data;
}
