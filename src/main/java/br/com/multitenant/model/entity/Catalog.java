package br.com.multitenant.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document("databases")
public class Catalog {
    @Id
    private Long id;
    private String database;
}