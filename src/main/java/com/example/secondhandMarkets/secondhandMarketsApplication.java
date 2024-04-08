package com.example.secondhandMarkets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.example"})
public class secondhandMarketsApplication extends SpringBootServletInitializer  {

	public static void main(String[] args) {
		SpringApplication.run(secondhandMarketsApplication.class, args);
	}
	
	 protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
	        return builder.sources(secondhandMarketsApplication.class);
	    }

}
