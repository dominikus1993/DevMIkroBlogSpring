package com.devmikroblog.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

/**
 * Created by domin_000 on 17.05.2016.
 */
@Configuration class StaticResourceConfiguration : WebMvcConfigurerAdapter() {
    override fun addResourceHandlers(registry: ResourceHandlerRegistry?) {
        registry?.addResourceHandler("bower_components/**")
                ?.addResourceLocations("/static/bower_components/");
        registry?.addResourceHandler("js/**")
                ?.addResourceLocations("/static/js/");
        registry?.addResourceHandler("views/**")
                ?.addResourceLocations("/static/views/");
    }
}