package io.jejuwn.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import io.jejuwn.service.AddressServiceImpl;

@Configuration
public class ContextConfig {
	
	@Bean
	@Qualifier("ads1")
	@Primary
	AddressServiceImpl addressService() {
		return new AddressServiceImpl();
	}

}
