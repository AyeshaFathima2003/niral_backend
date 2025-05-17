package com.example.demo.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Apply to all endpoints
                .allowedOrigins("http://localhost:5173") // Allow requests from React dev server
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Explicitly define allowed methods
                .allowedHeaders("*") // Allow all headers
                .allowCredentials(true); // Allow cookies if needed (e.g., for sessions)
    }
}
