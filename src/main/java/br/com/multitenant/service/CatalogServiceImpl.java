package br.com.multitenant.service;

import br.com.multitenant.model.entity.Catalog;
import br.com.multitenant.repository.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    private CatalogRepository catalogRepository;

    @Override
    public String findDatabase(Long id) {
        return catalogRepository.findById(id)
                .map(Catalog::getDatabase)
                .orElseThrow(() -> new IllegalArgumentException("Tenant id not found"));
    }
}



