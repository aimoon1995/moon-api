package com.moon.moon_openfeign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MoonOpenfeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoonOpenfeignApplication.class, args);
    }

}
