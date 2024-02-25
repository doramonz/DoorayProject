package com.nhnacademy.doorayProject.config;

import com.nhnacademy.doorayProject.config.handler.SessionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SessionHandler())
                .addPathPatterns("/**")
                .excludePathPatterns("/login_files/**")
                .excludePathPatterns("/login/**")
                .excludePathPatterns("/account/register/**");
    }
}
