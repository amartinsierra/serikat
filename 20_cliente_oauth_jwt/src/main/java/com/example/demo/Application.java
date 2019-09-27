package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.StandardEnvironment;
@ComponentScan(basePackages="controllers")
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		//cargando un perfil desde código
		/*SpringApplication application = new SpringApplication(Application.class);
		ConfigurableEnvironment environment = new StandardEnvironment();
		environment.setActiveProfiles("prod");
		application.setEnvironment(environment);
		application.run(args);*/
	}

}
