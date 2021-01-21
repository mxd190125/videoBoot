package com.mxd.video.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        String imgPath = "D:\\myVideo\\img\\";
//        String videoPath = "D:\\myVideo\\video\\";
//        registry.addResourceHandler("/img/**").addResourceLocations("file:" + imgPath);
//        registry.addResourceHandler("/video/**").addResourceLocations("file:" + videoPath);

        String imgPath = "/usr/local/myVideo/img/";
        String videoPath = "/usr/local/myVideo/video/";
        registry.addResourceHandler("/img/**").addResourceLocations("file:"  + imgPath);
        registry.addResourceHandler("/video/**").addResourceLocations("file:" + videoPath);
    }
}
