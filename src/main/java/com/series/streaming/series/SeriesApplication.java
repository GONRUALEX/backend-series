package com.series.streaming.series;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "com.series.streaming.*"})
public class SeriesApplication implements ApplicationRunner {
    private static final Logger logger = LogManager.getLogger(SeriesApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SeriesApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        
    }
}