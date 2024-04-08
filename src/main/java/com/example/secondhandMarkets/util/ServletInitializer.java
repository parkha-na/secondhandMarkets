package com.example.secondhandMarkets.util;

import com.example.secondhandMarkets.secondhandMarketsApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(secondhandMarketsApplication.class);
	}

}
