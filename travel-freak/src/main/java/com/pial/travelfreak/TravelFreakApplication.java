package com.pial.travelfreak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class TravelFreakApplication {

    public static void main(String[] args) {
        SpringApplication.run(TravelFreakApplication.class, args);
    }

}
