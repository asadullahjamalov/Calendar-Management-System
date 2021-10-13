package com.company.calendarmanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CalendarManagementSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(CalendarManagementSystemApplication.class, args);
    }
}
