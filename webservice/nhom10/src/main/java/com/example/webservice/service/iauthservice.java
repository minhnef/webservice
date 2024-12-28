package com.example.webservice.nhom10.service.impl;

import com.example.webservice.nhom10.dto.UserDTO;

public interface iauthservice {
    String register(UserDTO userDTO);
    String login(UserDTO userDTO);
}
