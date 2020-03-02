package com.hinton.staging.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/******
 /*  @Description:
 /*  @author zzk
 /*  @date   2020/3/2 13:45
 ******/
@RestController
@EnableAutoConfiguration
public class StagingMainApplicationContext {
    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        SpringApplication.run(StagingMainApplicationContext.class, args);
    }
}
