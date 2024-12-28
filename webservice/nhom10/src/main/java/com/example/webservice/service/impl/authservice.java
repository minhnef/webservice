package com.example.webservice.nhom10.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.webservice.nhom10.dto.UserDTO;
import com.example.webservice.nhom10.entity.User;
import com.example.webservice.nhom10.repository.UserRepository;
import com.example.webservice.nhom10.service.impl.iauthservice;

@Service
public class authservice implements iauthservice {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Override
    public String register(UserDTO userDTO) {
        try {
            // Kiểm tra username đã tồn tại
            Optional<User> existingUser = userRepository.findByUsername(userDTO.getUsername());
            if (existingUser.isPresent()) {
                return "Tên người dùng đã tồn tại. Vui lòng thử lại!";
            }

            // Mã hóa mật khẩu
            String encodedPassword = passwordEncoder.encode(userDTO.getPassword());

            // Tạo User mới và lưu vào database
            User newUser = new User();
            newUser.setUsername(userDTO.getUsername());
            newUser.setPassword(encodedPassword);
            userRepository.save(newUser);

            return "Đăng ký thành công! Người dùng: " + userDTO.getUsername();
        } catch (Exception e) {
            // Ghi log lỗi
            e.printStackTrace();
            return "Đã xảy ra lỗi trong quá trình đăng ký: " + e.getMessage();
        }
    }

    @Override
    public String login(UserDTO userDTO) {
        try {
            // Tìm user theo username
            Optional<User> optionalUser = userRepository.findByUsername(userDTO.getUsername());
            if (optionalUser.isPresent()) {
                User user = optionalUser.get();

                // So sánh mật khẩu đã mã hóa
                if (passwordEncoder.matches(userDTO.getPassword(), user.getPassword())) {
                    return "Đăng nhập thành công! Xin chào, " + userDTO.getUsername();
                } else {
                    return "Mật khẩu không đúng. Vui lòng thử lại!";
                }
            } else {
                return "Người dùng không tồn tại. Vui lòng kiểm tra lại!";
            }
        } catch (Exception e) {
            // Ghi log lỗi
            e.printStackTrace();
            return "Đã xảy ra lỗi trong quá trình đăng nhập: " + e.getMessage();
        }
    }
}
