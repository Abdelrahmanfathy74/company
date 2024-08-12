package com.springdata.first;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableCaching
public class FirstApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstApplication.class, args);
	}

//	@Bean
//	 ObjectMapper mapper(){
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//return mapper;
//	}
}
