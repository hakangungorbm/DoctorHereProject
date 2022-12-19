package com.doctorhere.reference;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author hakangungorbm
 * @date 4.12.2022
 */

@SpringBootApplication
@EnableConfigurationProperties
public class ReferenceApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ReferenceApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(ReferenceApplication.class, args);
    }
}