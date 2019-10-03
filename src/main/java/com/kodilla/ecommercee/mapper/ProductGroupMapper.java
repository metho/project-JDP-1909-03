package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.ProductGroup;
import com.kodilla.ecommercee.dto.ProductGroupDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductGroupMapper {
    @Autowired
    private ProductMapper productMapper;

    public ProductGroupDto mapToProductGroupDto(final ProductGroup productGroup) {
        ProductGroupDto productGroupDto = new ProductGroupDto();
        productGroupDto.setId(productGroup.getId());
        productGroupDto.setName(productGroup.getName());
        if (productGroup.getProducts() != null) {
            productGroupDto.setProducts(productMapper.mapToProductDtoList(productGroup.getProducts()));
        }
        return productGroupDto;
    }

    public List<ProductGroupDto> mapToProductGroupDtoList(final List<ProductGroup> groups) {
        return groups.stream()
                .map(this::mapToProductGroupDto)
                .collect(Collectors.toList());
    }

    public ProductGroup mapToProductGroup(final ProductGroupDto productGroupDto) {
        ProductGroup productGroup = new ProductGroup();
        productGroup.setId(productGroupDto.getId());
        productGroup.setName(productGroupDto.getName());
        return productGroup;
    }
}
