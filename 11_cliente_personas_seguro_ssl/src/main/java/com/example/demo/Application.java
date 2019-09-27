package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;
@ComponentScan(basePackages="controller")
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public RestTemplate getTemplate() {
		RestTemplate template=new RestTemplate();
		System.setProperty("javax.net.ssl.keyStore", "C:\\temporal\\almacenes\\cliente\\clavesCliente.jks");
		System.setProperty("javax.net.ssl.keyStorePassword", "clientePass");
		//System.setProperty("javax.net.ssl.keyStoreType", "jks");
       // System.setProperty("javax.net.ssl.trustStoreType", "jks");
        System.setProperty("javax.net.ssl.trustStore", "C:\\temporal\\almacenes\\cliente\\clienteConfianzaCerts.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "clientePass");
        System.setProperty("logging.level.org.springframework.security","DEBUG");
		/*System.setProperty("javax.net.ssl.keyStore", "C:\\almacenes_certificados\\cliente\\almacenCliente.p12");
        System.setProperty("javax.net.ssl.keyStorePassword", "clientePass");
        System.setProperty("javax.net.ssl.trustStore", "C:\\almacenes_certificados\\cliente\\clienttruststore.p12");
        System.setProperty("javax.net.ssl.trustStorePassword", "clientePass");
        System.setProperty("logging.level.org.springframework.security","DEBUG");*/
		return template;
	}
}
