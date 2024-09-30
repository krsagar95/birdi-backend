package com.birdi.TaskManager.config;

 

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import org.springframework.web.cors.CorsConfiguration;

import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import org.springframework.web.cors.CorsConfigurationSource;

import org.springframework.web.servlet.config.annotation.CorsRegistry;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

 

@Configuration

public class WebConfig implements WebMvcConfigurer {

 

    @Override

    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**") // Allow all paths

                .allowedOrigins("http://localhost:3000") // Allow your frontend URL

                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allow necessary methods

                .allowedHeaders("*") // Allow all headers

                .allowCredentials(true); // Allow cookies (if needed)

    }

}