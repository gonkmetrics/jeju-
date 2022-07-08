package io.jejuwn.config;


import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import io.jejuwn.mapper.AddressMapper;

@Configuration
@MapperScan(value= {"io.jejuwn.mapper"})
@ConfigurationProperties(prefix = "params.datasource")
//@EnableTransactionManagement
public class MybatisConfig {
	
	@Bean
    public DataSource dataSource() throws SQLException {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:oracle:thin:@//localhost:1522/XEPDB1");
		config.setUsername("jejutest");
		config.setPassword("jejutest");
		config.setDriverClassName("oracle.jdbc.OracleDriver");
		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

		HikariDataSource ds = new HikariDataSource(config);
		
        return ds;
    }
	
	/*
	@Bean
	public DataSource dataSource() {
		return DataSourceBuilder.create()
				.url("jdbc:oracle:thin:@//localhost:1522/XEPDB1")
				.driverClassName("oracle.jdbc.OracleDriver")
				.username("jejutest")
				.password("jejutest")
				.build();
	}
	*/
	
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception{
		SqlSessionFactoryBean sf = new SqlSessionFactoryBean();
		sf.setDataSource(dataSource());
		
		Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:*/mapper/*Mapper.xml");
        
        sf.setMapperLocations(res);
        
        return sf.getObject();
	}
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
	

}
