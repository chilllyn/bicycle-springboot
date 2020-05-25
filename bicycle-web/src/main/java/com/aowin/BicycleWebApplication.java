package com.aowin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author 83998
 */
@SpringBootApplication
@EnableTransactionManagement
public class BicycleWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(BicycleWebApplication.class,args);
    }
}
