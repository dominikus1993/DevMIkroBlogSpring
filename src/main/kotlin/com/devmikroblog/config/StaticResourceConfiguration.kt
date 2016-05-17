package com.devmikroblog.config

import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

/**
 * Created by domin_000 on 17.05.2016.
 */
open class StaticResourceConfiguration : WebMvcConfigurerAdapter() {
    override fun addResourceHandlers(registry: ResourceHandlerRegistry?) {
        registry?.addResourceHandler("bower_components/**")
                ?.addResourceLocations("classpath:/static/bower_components/");
        registry?.addResourceHandler("js/**")
                ?.addResourceLocations("classpath:/static/js/");
        registry?.addResourceHandler("view/**")
                ?.addResourceLocations("classpath:/static/view/");
        super.addResourceHandlers(registry)
    }
}