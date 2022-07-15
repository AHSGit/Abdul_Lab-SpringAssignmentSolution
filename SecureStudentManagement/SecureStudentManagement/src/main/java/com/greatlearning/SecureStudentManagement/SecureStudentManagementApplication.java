package com.greatlearning.SecureStudentManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.greatlearning.SecureStudentManagement.repository.UserRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class SecureStudentManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecureStudentManagementApplication.class, args);
	}

}
