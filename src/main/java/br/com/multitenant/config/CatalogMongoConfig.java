package br.com.multitenant.config;

import com.mongodb.MongoClientURI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import java.net.UnknownHostException;

@Configuration
public class CatalogMongoConfig {
    @Primary
    @Bean(name = "catalogMongoTemplate")
    public MongoTemplate mongoTemplateCatalog() throws UnknownHostException {
        return new MongoTemplate(new SimpleMongoDbFactory(new MongoClientURI("mongodb://root:password@localhost:27017/catalog")));
    }
}