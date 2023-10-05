package com.insurance.life.img2txt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class Img2TxtApplication {

	public static void main(String[] args) {
		SpringApplication.run(Img2TxtApplication.class, args);
	}
}
