package edu.pucmm.practica11_Quiz3;

import edu.pucmm.practica11_Quiz3.service.SeguridadServices;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Practica11Quiz3Application {

	public static void main(String[] args) {
		SpringApplication.run(Practica11Quiz3Application.class, args);

//		ApplicationContext applicationContext = SpringApplication.run(Practica11Quiz3Application.class, args);

//		SeguridadServices seguridadServices = (SeguridadServices) applicationContext.getBean("seguridadServices");
	}
}
