package com.csti.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.csti.app.services.DBService;

@Configuration
@Profile("test")
public class TestConfig {
	@Autowired
	private DBService service;

	@Bean
	void instanciaBaseDeDados() {
		this.service.instanciaBase();
	}

}
