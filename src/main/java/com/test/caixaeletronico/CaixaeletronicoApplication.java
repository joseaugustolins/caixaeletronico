package com.test.caixaeletronico;

import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CaixaeletronicoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CaixaeletronicoApplication.class, args);
	}

	@Bean
	public Queue queue() {
		return new Queue("AporteQueue", true);
	}

}
