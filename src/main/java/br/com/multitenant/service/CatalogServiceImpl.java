package br.com.multitenant.service;

import br.com.multitenant.model.entity.Catalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    @Resource(name = "catalogMongoTemplate")
    private MongoTemplate template;

    @Override
    public String findDatabase(Long id) {
        return Optional.of(template.findById(id, Catalog.class))
                       .map(Catalog::getDatabase)
                       .orElseThrow(() -> new IllegalArgumentException("Tenant id not found"));
    }
}