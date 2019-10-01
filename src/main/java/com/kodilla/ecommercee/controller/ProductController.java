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


    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void createProduct(@RequestBody ProductDto productDto) {
        log.info("Create new product " + productDto.getName());
    }

    @GetMapping("{productId}")
    public ProductDto getProduct(@PathVariable Long productId) {
        log.info("Get product by ID " + productId);
        return new ProductDto();
    }

    @GetMapping(value = "all")
    public List<ProductDto> getProducts() {
        log.info("Get list of products");
        return new ArrayList<>();
    }

    @DeleteMapping("{productId}")
    public void deleteProduct(@PathVariable Long productId) {
        log.info("Delete product by ID " + productId);
    }

    @PutMapping
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        log.info("Update the product with ID " + productDto.getId());
        return new ProductDto();
    }


}