package com.thientvse.devopsintegration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class DevopsIntegrationApplication {
    private static Logger LOGGER = LoggerFactory.getLogger(DevopsIntegrationApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DevopsIntegrationApplication.class, args);
        //test
        LOGGER.info("Springboot profiles application is running successfully.");
    }

}
