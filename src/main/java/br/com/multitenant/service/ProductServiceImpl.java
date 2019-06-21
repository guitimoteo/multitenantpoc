package br.com.multitenant.service;

import br.com.multitenant.model.dto.ProductDto;
import br.com.multitenant.model.entity.Product;
import br.com.multitenant.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductDto> findProducts() {
        log.info("product catalog");
        log.info("productRepository {}", productRepository.count());
        productRepository.findAll().forEach(p -> log.info(String.valueOf(p)));
        return ((List<Product>) productRepository.findAll())
                                                 .stream()
                                                 .map(p -> new ProductDto(p))
                                                 .collect(Collectors.toList());
    }
}