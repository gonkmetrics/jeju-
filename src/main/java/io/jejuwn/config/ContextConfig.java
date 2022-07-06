package io.jejuwn.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.jejuwn.service.AddressServiceImpl;

@Configuration
public class ContextConfig {
	
	@Bean
	@Qualifier("AddressService")
	AddressServiceImpl addressService() {
		return new AddressServiceImpl();
	}

}
