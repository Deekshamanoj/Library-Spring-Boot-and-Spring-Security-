package com.tyss.Library.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.tyss.Library.entity.enums.Role;

@Configuration
@EnableWebSecurity
public class CustomAuthentiactionManager {

	@Autowired
	private ApplicationUserDetailsService userDetailService;
	
	private static final String[] PUBLIC_URLS = { "/api/register" };

	private static final String[] ADMIN_URLS = { "/api/"};

	private static final String[] USER_URLS = { "/api" };



	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.csrf(customizer -> customizer.disable())
				.authorizeHttpRequests(request -> request
						.requestMatchers(PUBLIC_URLS).permitAll()
						.requestMatchers(ADMIN_URLS).hasRole(Role.ADMIN.name())
						.anyRequest().authenticated())
				.httpBasic(Customizer.withDefaults())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
		return http.build();
	}

	
//	@Bean
//	public UserDetailsService userDetailsService() {
//		UserDetails user1 = User
//				.withDefaultPasswordEncoder()
//				.username("dee")
//				.password("123")
//				.build();
//		UserDetails user2 = User
//				.withDefaultPasswordEncoder()
//				.username("vini")
//				.password("123")
//				.build();
//		return new InMemoryUserDetailsManager(user1,user2);
//	}
	
	@Bean 
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
		provider.setUserDetailsService(userDetailService);
		return provider;
	}
}
