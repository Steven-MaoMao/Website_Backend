package com.Website.Website_Backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.Website.Website_Backend.Mapper")
public class WebsiteBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebsiteBackendApplication.class, args);
	}

}
