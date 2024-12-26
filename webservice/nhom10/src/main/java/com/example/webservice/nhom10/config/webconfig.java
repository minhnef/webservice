package com.example.webservice.nhom10.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class webconfig implements WebMvcConfigurer {

    // @Override
    // public void configureHttpMessageConverters(List<HttpMessageConverter<?>> converters) {
    //     // ... các cấu hình khác ...
    // }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") 
                .allowedOrigins("http://127.0.0.1:5500") // Thay thế bằng miền của frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("Content-Type", "Authorization");
    }
}