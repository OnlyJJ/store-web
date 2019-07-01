package com.xy.sczl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xy.sczl.dao")
public class SczlWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(SczlWebApplication.class, args);
	}

}
