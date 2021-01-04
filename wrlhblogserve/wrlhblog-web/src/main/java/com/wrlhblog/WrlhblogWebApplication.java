package com.wrlhblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wrlhblog.mapper")
public class WrlhblogWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(WrlhblogWebApplication.class, args);
	}

}
