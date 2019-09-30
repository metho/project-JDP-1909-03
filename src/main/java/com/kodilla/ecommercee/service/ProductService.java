package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.dto.ProductDto;
import com.kodilla.ecommercee.exception.ProductNotFoundException;
import com.kodilla.ecommercee.mapper.ProductMapper;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductRepository productRepository;

    public List<ProductDto> getProducts() {
        return productMapper.mapToProductDtoList(productRepository.findAll());
    }

    public ProductDto getProduct(final Long productId) throws ProductNotFoundException {
        return productMapper.mapToProductDto(productRepository.findById(productId).orElseThrow(ProductNotFoundException::new));
    }

    public ProductDto createProduct(final ProductDto productDto) {
        return productMapper.mapToProductDto(productRepository.save(productMapper.mapToProduct(productDto)));
    }

    public ProductDto updateProduct(final ProductDto productDto) throws ProductNotFoundException {
        if (productRepository.findById(productDto.getId()).isPresent()) {
            return productMapper.mapToProductDto(productRepository.save(productMapper.mapToProduct(productDto)));
        }
        throw new ProductNotFoundException();
    }

    public boolean deleteProduct(final Long productId) throws ProductNotFoundException {
        if (productRepository.findById(productId).isPresent()) {
            productRepository.deleteById(productId);
            return true;
        }
        throw new ProductNotFoundException();
    }
}
