package com.titanhelix.mathematica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class HelixMathematicaApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(HelixMathematicaApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(HelixMathematicaApplication.class, args);
	}

}
