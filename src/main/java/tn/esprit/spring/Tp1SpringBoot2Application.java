package tn.esprit.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import springfox.documentation.swagger2.annotations.EnableSwagger2;



@EnableScheduling
@SpringBootApplication
@EnableSwagger2
public class Tp1SpringBoot2Application {

	public static void main(String[] args) {
		SpringApplication.run(Tp1SpringBoot2Application.class, args);
	
		
	}

}
