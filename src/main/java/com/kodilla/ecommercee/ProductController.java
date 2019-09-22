package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.ProductDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    @GetMapping(value = "all")
    public List<ProductDto> getProducts() {
        System.out.println("Getting list of products");
        return new ArrayList<>();
    }

    @GetMapping("{productId}")
    public ProductDto getProduct(@PathVariable Long productId) {
        System.out.println("Getting a product by id");
        return new ProductDto();
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void createProduct(@RequestBody ProductDto productDto) {
        System.out.println("Creating new product.");
    }

    @PutMapping
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        System.out.println("Updating the product");
        return new ProductDto();
    }

    @DeleteMapping("{productId}")
    public void deleteProduct(@PathVariable Long productId) {
        System.out.println("Delete product by id");
    }
}