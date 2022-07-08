package io.jejuwn;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "io")
@ComponentScan({"io.*"})
@MapperScan(value = {"io.jejuwn.mapper"})
@EntityScan(value = {"io.jejuwn.*"})

public class JejuwnBApplication {

	public static void main(String[] args) {
		SpringApplication.run(JejuwnBApplication.class, args);
	}

}
