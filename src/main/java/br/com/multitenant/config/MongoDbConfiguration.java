package br.com.multitenant.config;

import br.com.multitenant.repository.ProductRepository;
import com.mongodb.MongoClientURI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackageClasses = ProductRepository.class,
        mongoTemplateRef = "tenant")
public class MongoDbConfiguration {

    @Bean
    public MongoDbFactory mongoDbFactory() {
        MongoClientURI mongoClientURI = new MongoClientURI("mongodb://root:password@localhost:27017/admin");
        return new MultiTenantMongoFactory(mongoClientURI);
    }

    @Bean(name = "tenant")
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoDbFactory());
    }
}