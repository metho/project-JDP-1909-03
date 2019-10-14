package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.dto.ProductDto;
import com.kodilla.ecommercee.exception.EntityNotFoundException;
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
        return productMapper.toProductDtoList(productRepository.findAll());
    }

    public ProductDto getProduct(final Long productId) throws EntityNotFoundException {
        return productMapper.toProductDto(productRepository.findById(productId).orElseThrow(() -> new EntityNotFoundException(Product.class, "id", productId.toString())));
    }

    public ProductDto createProduct(final ProductDto productDto) {
        return productMapper.toProductDto(productRepository.save(productMapper.toProduct(productDto)));
    }

    public ProductDto updateProduct(final ProductDto productDto) throws EntityNotFoundException {
        if (productRepository.findById(productDto.getId()).isPresent()) {
            return productMapper.toProductDto(productRepository.save(productMapper.toProduct(productDto)));
        }
        throw new EntityNotFoundException(Product.class, "id", String.valueOf(productDto.getId()));
    }

    public void deleteProduct(final Long productId) throws EntityNotFoundException {
        if (productRepository.findById(productId).isPresent()) {
            productRepository.deleteById(productId);
        } else {
            throw new EntityNotFoundException(Product.class, "id", productId.toString());
        }
    }
}
