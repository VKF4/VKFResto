package com.expernet.vkf.resto.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.expernet.vkf.resto.utils.JwtRequestFilter;

@Configuration
public class WebSecurity {

	 	@Autowired
	    private JwtRequestFilter jwtRequestFilter;
	
	 	@Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	        http.csrf().disable()
	            .authorizeHttpRequests((authz) -> authz
				.requestMatchers("/register", "/login").permitAll()
	            .anyRequest().authenticated()
	        );
	            
	        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	        return http.build();
	    }
}
