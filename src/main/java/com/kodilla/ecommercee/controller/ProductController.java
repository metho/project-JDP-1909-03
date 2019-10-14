package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.ProductDto;
import com.kodilla.ecommercee.exception.EntityNotFoundException;
import com.kodilla.ecommercee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/product")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("all")
    public List<ProductDto> getProducts() {
        log.info("Get list of products");
        return productService.getProducts();
    }

    @GetMapping("{productId}")
    public ProductDto getProduct(@PathVariable Long productId) throws EntityNotFoundException {
        log.info("Get product by ID = {}", productId);
        return productService.getProduct(productId);
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        log.info("Create new product {}", productDto.getName());
        return productService.createProduct(productDto);
    }

    @PutMapping
    public ProductDto updateProduct(@RequestBody ProductDto productDto) throws EntityNotFoundException {
        log.info("Update the product with ID = {}", productDto.getId());
        return productService.updateProduct(productDto);
    }

    @DeleteMapping("{productId}")
    public void deleteProduct(@PathVariable Long productId) throws EntityNotFoundException {
        log.info("Delete product by ID = {}", productId);
        productService.deleteProduct(productId);
    }
}