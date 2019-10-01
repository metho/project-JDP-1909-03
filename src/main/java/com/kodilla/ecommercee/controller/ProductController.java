package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.ProductDto;
import com.kodilla.ecommercee.exception.ProductNotFoundException;
import com.kodilla.ecommercee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("all")
    public List<ProductDto> getProducts() {
        System.out.println("Getting list of products.");
        return productService.getProducts();
    }

    @GetMapping("{productId}")
    public ProductDto getProduct(@PathVariable Long productId) throws ProductNotFoundException {
        System.out.println("Getting a product with id " + productId);
        return productService.getProduct(productId);
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        System.out.println("Creating new product.");
        return productService.createProduct(productDto);
    }

    @PutMapping
    public ProductDto updateProduct(@RequestBody ProductDto productDto) throws ProductNotFoundException {
        System.out.println("Updating the product with id " + productDto.getId());
        return productService.updateProduct(productDto);
    }

    @DeleteMapping("{productId}")
    public void deleteProduct(@PathVariable Long productId) throws ProductNotFoundException {
        System.out.println("Deleting product with id " + productId);
        productService.deleteProduct(productId);
    }
}