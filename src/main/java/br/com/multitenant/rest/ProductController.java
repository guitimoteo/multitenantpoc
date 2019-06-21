package br.com.multitenant.rest;

import br.com.multitenant.model.dto.ProductDto;
import br.com.multitenant.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController()
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductDto> listProduct() {
        log.info("inicio do tenant");
        return productService.findProducts();
    }

    @PostMapping
    public ResponseEntity saveProduct(@RequestBody ProductDto productDto) {
        productService.saveProduct(productDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateProduct(@RequestBody ProductDto productDto) {
        productService.saveProduct(productDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping(value = "/id/{id}")
    public ResponseEntity deleteProduct(@PathVariable(value = "id") Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}