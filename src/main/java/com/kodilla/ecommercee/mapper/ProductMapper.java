package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.ProductGroup;
import com.kodilla.ecommercee.dto.ProductDto;
import com.kodilla.ecommercee.exception.EntityNotFoundException;
import com.kodilla.ecommercee.repository.ProductGroupRepository;
import com.kodilla.ecommercee.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    @Autowired
    private ProductGroupRepository productGroupRepository;

    @Autowired
    private ProductRepository productRepository;

    public ProductDto toProductDto(final Product product) {
        ProductDto productDto = new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.isAvailable()
        );
        if (product.getProductGroup() != null) {
            productDto.setProductGroupId(product.getProductGroup().getId());
        }
        return productDto;
    }

    public Product toProduct(final ProductDto productDto) {
        Product product = new Product(
                productDto.getId(),
                productDto.getName(),
                productDto.getDescription(),
                productDto.getPrice(),
                productDto.isAvailable()
        );
        if (productDto.getProductGroupId() > 0) {
            product.setProductGroup(productGroupRepository.findById(productDto.getProductGroupId()).orElseThrow(() -> new EntityNotFoundException(ProductGroup.class, "id", String.valueOf(productDto.getProductGroupId()))));
        }
        return product;
    }

    public List<ProductDto> toProductDtoList(final List<Product> products) {
        return products.stream()
                .map(this::toProductDto)
                .collect(Collectors.toList());
    }
}
