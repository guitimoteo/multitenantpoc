package br.com.multitenant.config;

import com.mongodb.MongoClientURI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import java.net.UnknownHostException;

@Configuration
public class MongoDbConfiguration {

    @Bean
    @Primary
    public MongoDbFactory mongoDbFactory() throws UnknownHostException {
        MongoClientURI mongoClientURI = new MongoClientURI("mongodb://localhost:27017");
        return new MultiTenantMongoFactory(mongoClientURI);
    }

    @Bean(name = "tenant")
    public MongoTemplate mongoTemplate() throws UnknownHostException {
        return new MongoTemplate(mongoDbFactory());
    }

    @Bean(name = "catalog")
    public MongoTemplate mongoTemplateCatalog() throws UnknownHostException {
        return new MongoTemplate(new SimpleMongoDbFactory(new MongoClientURI("mongodb://localhost:27017/catalog")));
    }
}