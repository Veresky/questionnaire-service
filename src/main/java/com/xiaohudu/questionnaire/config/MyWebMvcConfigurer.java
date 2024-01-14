package com.xiaohudu.questionnaire.config;

import com.xiaohudu.questionnaire.interceptor.LoginInterceptor;
import com.xiaohudu.questionnaire.interceptor.MonitorLogInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {
  @Bean
  public LoginInterceptor loginInterceptor() {
    return new LoginInterceptor();
  }
  @Bean
  public MonitorLogInterceptor monitorLogInterceptor() {
    return new MonitorLogInterceptor();
  }

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
            .allowedOriginPatterns("http://localhost:8080", "https://questionnaire-client-320a500d3b93.herokuapp.com")
            .allowedMethods("*")
            .allowedHeaders("*")
            .maxAge(3600)
            .allowCredentials(true);
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    // 监控日志
    registry.addInterceptor(monitorLogInterceptor())
            .addPathPatterns("/**");

    // 登录
    registry.addInterceptor(loginInterceptor())
            .addPathPatterns(new String[]{"/**"})
            .excludePathPatterns(new String[]{"/common/**", "/sys/dict/all", "/auth/login", "/questionnaire/questionnaire/detail", "/questionnaire/survey/save"});

  }
}