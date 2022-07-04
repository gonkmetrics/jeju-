package io.jejuwn.config;


import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
@MapperScan(value= {"io.jejuwn.mapper"})
//@EnableTransactionManagement
public class MybatisConfig {
	
	@Bean
	public DataSource customDs() {
		return DataSourceBuilder.create()
				.url("jdbc:oracle:thin:@//localhost:1522/XEPDB1")
				.driverClassName("oracle.jdbc.OracleDriver")
				.username("JTEST")
				.password("123")
				.build();
	}
	
	@Bean
	public SqlSessionFactory ssf(DataSource ds) throws Exception{
		SqlSessionFactoryBean sf = new SqlSessionFactoryBean();
		sf.setDataSource(ds);
		
		Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*Mapper.xml");
        
        sf.setMapperLocations(res);
        
        return sf.getObject();
	}
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
	

}
