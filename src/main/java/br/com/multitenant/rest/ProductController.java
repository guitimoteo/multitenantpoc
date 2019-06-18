package br.com.multitenant.rest;

import br.com.multitenant.model.dto.ProductDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.List;

@Slf4j
@RestController("api/products")
public class ProductController {

    @GetMapping("/")
    public List<ProductDto> listProduct() {
        // Inject tenantId in the request
        RequestContextHolder.getRequestAttributes().setAttribute("tenantId","1", RequestAttributes.SCOPE_REQUEST);
        return null;
    }
}