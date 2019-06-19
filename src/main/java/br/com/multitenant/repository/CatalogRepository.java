package br.com.multitenant.repository;

import br.com.multitenant.model.entity.Catalog;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "catalog")
@Qualifier("catalog")
public interface CatalogRepository extends CrudRepository<Catalog, Long> {
}