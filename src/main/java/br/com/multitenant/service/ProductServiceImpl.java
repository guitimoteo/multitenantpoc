package br.com.multitenant.service;

import br.com.multitenant.model.dto.ProductDto;
import br.com.multitenant.model.entity.Product;
import br.com.multitenant.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductDto> findProducts() {
        log.debug("findProducts");
        return ((List<Product>) productRepository.findAll())
                                                 .stream()
                                                 .map(p -> new ProductDto(p))
                                                 .collect(Collectors.toList());
    }

    @Override
    public void saveProduct(ProductDto productDto) {
        if(!productRepository.existsBySku(productDto.getSku()))
            productRepository.save(new Product(productDto));
    }

    @Override
    public void updateProduct(ProductDto productDto) {
        Product product = productRepository.findBySku(productDto.getSku());
        if(product == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteBySku(id);
    }
}