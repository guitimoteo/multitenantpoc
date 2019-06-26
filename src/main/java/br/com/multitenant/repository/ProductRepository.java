package br.com.multitenant.repository;

import br.com.multitenant.model.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("catalog")
public interface ProductRepository extends CrudRepository<Product, Long> {
    void deleteBySku(Long sku);
    Product findBySku(Long sku);
    boolean existsBySku(long sku);
}