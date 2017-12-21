package com.cmancode.load.app;

import java.nio.file.Paths;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class MvcConfig implements WebMvcConfigurer{

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addResourceHandlers(registry);
		String absolutePath = Paths.get("uploads").toUri().toString();
		registry.addResourceHandler("/uploads/**")
		.addResourceLocations(absolutePath);
	}
	
	
}
