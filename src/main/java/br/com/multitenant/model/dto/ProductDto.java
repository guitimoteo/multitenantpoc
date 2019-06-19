package br.com.multitenant.model.dto;

import br.com.multitenant.model.entity.Product;
import lombok.Data;

@Data
public class ProductDto {
    private Long sku;
    public ProductDto(Product product) {
        this.sku = product.getSku();
    }
}
