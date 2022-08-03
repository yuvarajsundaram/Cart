package com.mariadb.mariadbdemo.Config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;

@Configuration
public class ProjectSecurityConfig {

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
		jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeyCloakRoleConverter());

		http.cors().configurationSource(new CorsConfigurationSource() {
					@Override
					public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
						CorsConfiguration config = new CorsConfiguration();
						config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
						config.setAllowedMethods(Collections.singletonList("*"));
						config.setAllowCredentials(true);
						config.setAllowedHeaders(Collections.singletonList("*"));
						config.setMaxAge(3600L);
						return config;
					}
				}).and().csrf().disable()
		.oauth2ResourceServer().jwt().jwtAuthenticationConverter(jwtAuthenticationConverter);
//		.authorizeHttpRequests((auth) -> auth
//						.antMatchers("/customers").hasRole("admin")
//						.antMatchers("/addItem").hasRole("admin")
//						.antMatchers("/customer/{id}").hasRole("user")
//						.antMatchers("/addCustomer").hasRole("user")
//						.antMatchers("/updateCustomer").hasRole("user")
//						.antMatchers("/orderItem").hasRole("user")
//						.antMatchers("/deleteOrder/{custId}/{itemId}").hasRole("user"))
//				.csrf().disable()
//				.oauth2ResourceServer().jwt().jwtAuthenticationConverter(jwtAuthenticationConverter);

		http.headers().frameOptions().sameOrigin();
		return http.build();
	}

}
