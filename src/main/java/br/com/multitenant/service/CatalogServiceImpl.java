package br.com.multitenant.service;

import br.com.multitenant.model.entity.Catalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    @Resource(name = "catalogMongoTemplate")
    private MongoTemplate template;

    @Override
    @Cacheable(value = "catalog", key = "#id")
    public String findDatabase(Long id) {
        return Optional.ofNullable(template.findById(id, Catalog.class))
                       .map(Catalog::getDatabase)
                       .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tenant id not found"));
    }
}