package io.jejuwn;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = "io")
@ComponentScan({"io.*"})
@MapperScan(value = {"io.jejuwn.mapper"})

public class JejuwnBApplication {

	public static void main(String[] args) {
		SpringApplication.run(JejuwnBApplication.class, args);
	}

}
