package io.jejuwn.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/* @Configuration
@Getter
@Setter
public class RedisProperties {
	private int redisPort;
	private String redisHost;
	
	@Builder
	public RedisProperties(
	@Value("${spring.redis.port}") int redisPort,
	@Value("${spring.redis.host}") String redisHost) {
		this.redisHost = redisHost;
		this.redisPort = redisPort;
	}
	
	

} */
