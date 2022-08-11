package br.com.mentorama.SpringJMS_Api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;


@EnableReactiveMongoRepositories
@SpringBootApplication
public class SpringJmsApiApplication{

	public static void main(String[] args) {
		SpringApplication.run(SpringJmsApiApplication.class, args);
	}

}
