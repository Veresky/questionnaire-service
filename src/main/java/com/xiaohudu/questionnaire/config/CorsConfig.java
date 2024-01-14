package com.xiaohudu.questionnaire.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // 允许跨域的路径
                .allowedOrigins("https://questionnaire-client-664fab06639a.herokuapp.com") // 前端应用的地址
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH"); // 允许的HTTP方法
    }
}
