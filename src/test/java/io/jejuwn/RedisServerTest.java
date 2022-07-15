package io.jejuwn;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.data.redis.connection.RedisServer;



@TestConfiguration
public class RedisServerTest {
	
	private RedisServer redisServer;

    public RedisServerTest(RedisProperties redisProperties) {
        this.redisServer = new RedisServer(redisProperties.getHost(), redisProperties.getPort());
    }
}
