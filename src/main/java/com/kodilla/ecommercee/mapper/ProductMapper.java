package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.dto.ProductDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

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
        return new Product(
                productDto.getId(),
                productDto.getName(),
                productDto.getDescription(),
                productDto.getPrice(),
                productDto.isAvailable()
        );
    }

    public List<ProductDto> toProductDtoList(final List<Product> products) {
        return products.stream()
                .map(this::toProductDto)
                .collect(Collectors.toList());
    }
}
