package br.com.daniloboccomino.epictask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class EpictaskApplication {

	public static void main(String[] args) {
		SpringApplication.run(EpictaskApplication.class, args);
	}

}
