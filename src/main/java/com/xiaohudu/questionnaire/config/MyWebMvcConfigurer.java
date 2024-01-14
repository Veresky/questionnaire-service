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
            //是否发送Cookie
            .allowCredentials(true)
            //放行哪些原始域
            .allowedOrigins("https://questionnaire-client-320a500d3b93.herokuapp.com", "http://localhost:[*]")
            .allowedMethods(new String[]{"GET", "POST", "PUT", "DELETE"})
            .allowedHeaders("*")
            .exposedHeaders("*");
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