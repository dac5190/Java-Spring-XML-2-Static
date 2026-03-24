package com.poc.engine.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private StaticExportInterceptor staticExportInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // This registers the logic that swaps /setup for /setup/index.html
        registry.addInterceptor(staticExportInterceptor);
    }
}
