package br.com.multitenant.model.dto;

import br.com.multitenant.model.entity.Product;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductDto {
    private long sku;
    private float value;
    public ProductDto(Product product) {
        this.sku = product.getSku();
        this.value = product.getValue();
    }
}
