package com.doctorhere;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class) //spring security i exclude etmek için
public class DhserviceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DhserviceApplication.class, args);
    }

}