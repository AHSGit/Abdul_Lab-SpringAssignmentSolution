package com.greatlearning.SecureStudentManagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity

// To enable global Method Security
// prePostEnabled property enables Spring Security pre/post annotations
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	// **AUTHENTICATION**
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	// **AUTHORIZATION**
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable()
		.authorizeRequests()		
				.antMatchers("/SecureStudentManagement/edit/**", "/SecureStudentManagement/update/**",
						"/SecureStudentManagement/delete/**").authenticated()
				.antMatchers("/SecureStudentManagement/add", "/SecureStudentManagement/save",
						"/SecureStudentManagement/allStudents").permitAll()
				.anyRequest().authenticated()
	            .and()
	            .formLogin().permitAll();
	}

	// BCryptPasswordEncoder to encode passwords
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
