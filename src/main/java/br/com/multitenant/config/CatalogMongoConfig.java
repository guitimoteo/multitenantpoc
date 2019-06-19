package br.com.multitenant.config;

import br.com.multitenant.repository.CatalogRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackageClasses = CatalogRepository.class,
        mongoTemplateRef = "catalogMongoTemplate")
public class CatalogMongoConfig {
}