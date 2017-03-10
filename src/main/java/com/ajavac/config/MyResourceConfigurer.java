package com.ajavac.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by wyp0596 on 09/03/2017.
 */
@Configuration
public class MyResourceConfigurer extends WebMvcConfigurerAdapter {

    private static final String pre = "file:";

    @Value("${my.file.dir}")
    private String dir;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/my/**").addResourceLocations(pre + dir);
        super.addResourceHandlers(registry);
    }
}
