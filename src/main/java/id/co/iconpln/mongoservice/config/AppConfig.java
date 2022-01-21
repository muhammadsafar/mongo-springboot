package id.co.iconpln.mongoservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class AppConfig {

	@Bean
	public MongoClient mongoClient() {
		return MongoClients.create("mongodb://neon_apps:Tre%40nt.Prot3ctor%21@10.14.205.79:27017/?authSource=neon_db&readPreference=primary&appname=MongoDB%20Compass&ssl=false");
	}

	@Bean
	public MongoTemplate mongoTemplate() {
		return new MongoTemplate(mongoClient(), "neon_db");
	}
}