package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.ProductDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/product")
@Slf4j
public class ProductController {

    @GetMapping(value = "all")
    public List<ProductDto> getProducts() {
        log.info("Getting list of products");
        return new ArrayList<>();
    }

    @GetMapping("{productId}")
    public ProductDto getProduct(@PathVariable Long productId) {
        log.info("Getting a product by id");
        return new ProductDto();
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void createProduct(@RequestBody ProductDto productDto) {
        log.info("Creating new product.");
    }

    @PutMapping
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        log.info("Updating the product");
        return new ProductDto();
    }

    @DeleteMapping("{productId}")
    public void deleteProduct(@PathVariable Long productId) {
        log.info("Delete product by id");
    }
}