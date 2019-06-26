package br.com.multitenant.model.entity;

import br.com.multitenant.model.dto.ProductDto;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@Document("products")
public class Product {
    @Id
    @Getter
    private ObjectId id;

    @Indexed(unique = true ,name = "sku")
    private long sku;

    @Field("value")
    private float value;

    public Product(ProductDto productDto) {
        this.sku = productDto.getSku();
        this.value = productDto.getValue();
    }
}