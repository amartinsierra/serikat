package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;
@ComponentScan(basePackages="controllers")
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@LoadBalanced
	@Bean
	public RestTemplate getTemplate() {
		RestTemplate template=new RestTemplate();
		//creación de credenciales
		BasicAuthenticationInterceptor bs=new BasicAuthenticationInterceptor("user1", "user1");
		//Añadimos el interceptor de credenciales a la lista
		template.getInterceptors().add(bs);
		return template;
	}
}
