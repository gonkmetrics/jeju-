package io.jejuwn.config;

import java.util.Arrays;

import javax.servlet.Filter;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenStoreUserApprovalHandler;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import io.jejuwn.repository.UserRepository;
import io.jejuwn.security.jwt.CustomAuthenticationFilter;
import io.jejuwn.security.jwt.CustomAuthorizationFilter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@SuppressWarnings("deprecation")
@Log4j2
@EnableWebSecurity(debug = true)
@RequiredArgsConstructor
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	//class is deprecated. check securityconfig class
	//@Autowired
	//private UserRepository userRepo;
	// watch me autowire this one bro
	//@Autowired
	//private JwtAuthenticationFilter filter;
	
	//@Autowired
	//private CustomAuthenticationFilter filter;
	
	private final UserDetailsService uds;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	/*
	@Autowired
	private UserDetailsService uds;
	*/
	/*
	@Bean
	public BCryptPasswordEncoder pwEncoder() {
		return new BCryptPasswordEncoder();
	}*/
	
	
	@Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
	
	/*
	@Autowired
    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
        .withUser("jejuadmin").password("abc123").roles("ADMIN");
    }*/
	
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(uds)
                .passwordEncoder(bCryptPasswordEncoder);
        super.configure(auth);
    }
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean());
        customAuthenticationFilter.setFilterProcessesUrl("/login");
		
        http.cors().and().csrf().disable()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)   
        .and()
        .addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
        .authorizeRequests()
        .antMatchers("/login/**","/login","/logout", "/logout/**", "/user/save", "/token/refresh/**", "/blog/**").permitAll()
        .antMatchers(HttpMethod.GET, "/user/**").hasAnyAuthority("ROLE_USER")
        .antMatchers(HttpMethod.POST, "/user/save/**").hasAnyAuthority("ROLE_ADMIN")
        .anyRequest().fullyAuthenticated()
        //.and().oauth2Login()
        ;
                
                
        log.info("configured httpsecurity");
       
    }
	
	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers(
				"/v2/api-docs",
				"/configuration/ui",
				"/swagger-ui.html",
				"/swagger-ui",
				"/swagger-resources",
				"/webjars/**",
				"/configuration/security",
				"/swagger-resources/configuration/ui",
				"/swagger-resources/configuration/security",
				"/swagger-ui/**",
				
				"/files/**",
				"/logout",
				"/logout/**"
				);
	}
	
	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.addAllowedOriginPattern("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}
	
	
	
}
