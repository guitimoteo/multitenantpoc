package br.com.multitenant.service;

import br.com.multitenant.model.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> findProducts();
}