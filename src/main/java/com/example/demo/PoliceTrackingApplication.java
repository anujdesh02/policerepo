package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.example.demo.controller.HomeController;

@SpringBootApplication
//@ComponentScan(basePackageClasses=HomeController.class)


//@SpringBootApplication(scanBasePackages={
//"com.example.demo.controller.HomeController", "com.example.demo.service.UserService"})

public class PoliceTrackingApplication {

	public static void main(String[] args) {
		SpringApplication.run(PoliceTrackingApplication.class, args);
		System.out.println("Police");
	}  
}    