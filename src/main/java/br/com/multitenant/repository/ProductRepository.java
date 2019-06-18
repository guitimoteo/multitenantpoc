package br.com.multitenant.repository;

import br.com.multitenant.model.entity.Catalog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("catalog")
public interface ProductRepository extends CrudRepository<Catalog, Long> {
}