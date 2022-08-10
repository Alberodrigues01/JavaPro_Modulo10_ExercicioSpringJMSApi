package br.com.mentorama.SpringJMS_Api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableReactiveMongoRepositories
@SpringBootApplication
public class SpringJmsApiApplication extends AbstractReactiveMongoConfiguration {

	public static void main(String[] args) {
		SpringApplication.run(SpringJmsApiApplication.class, args);
	}

	@Override
	protected String getDatabaseName() {
		return "javapro10";
	}
}
