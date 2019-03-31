package com.pc.blogger.bloggerservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.*;

@EnableDiscoveryClient

@SpringBootApplication


@EnableFeignClients("com.pc.blogger.bloggerservice")


public class BloggerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BloggerServiceApplication.class, args);
	}

}
