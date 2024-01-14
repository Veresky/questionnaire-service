package com.xiaohudu.questionnaire.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 对所有路径应用 CORS 设置
                .allowedOrigins("*") // 允许的源
                .allowedMethods("GET", "POST", "PUT", "DELETE"); // 允许的 HTTP 方法
    }
}
