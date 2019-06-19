package br.com.multitenant.config;

import br.com.multitenant.repository.CatalogRepository;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.net.UnknownHostException;

@Configuration
@EnableMongoRepositories(basePackageClasses = CatalogRepository.class,
                         mongoTemplateRef   = "catalogMongoTemplate")
public class CatalogMongoConfig {
    @Primary
    @Bean(name = "catalogMongoTemplate")
    public MongoTemplate mongoTemplateCatalog() throws UnknownHostException {
        return new MongoTemplate(new SimpleMongoDbFactory(new MongoClientURI("mongodb://root:password@localhost:27017/catalog")));
    }
}