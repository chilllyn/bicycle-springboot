package com.aowin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableJms
public class BicycleManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BicycleManagerApplication.class, args);
    }

}
