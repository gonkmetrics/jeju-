package io.jejuwn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "io.jejuwn")
@MapperScan(value = {"io.jejuwn.mapper"})
public class JejuwnBApplication {

	public static void main(String[] args) {
		SpringApplication.run(JejuwnBApplication.class, args);
	}

}
