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

    public ProductGroupDto toProductGroupDto(final ProductGroup productGroup) {
        ProductGroupDto productGroupDto = new ProductGroupDto();
        productGroupDto.setId(productGroup.getId());
        productGroupDto.setName(productGroup.getName());
        if (productGroup.getProducts() != null) {
            productGroupDto.setProducts(productMapper.toProductDtoList(productGroup.getProducts()));
        }
        return productGroupDto;
    }

    public List<ProductGroupDto> toProductGroupDtoList(final List<ProductGroup> groups) {
        return groups.stream()
                .map(this::toProductGroupDto)
                .collect(Collectors.toList());
    }

    public ProductGroup toProductGroup(final ProductGroupDto productGroupDto) {
        ProductGroup productGroup = new ProductGroup();
        productGroup.setId(productGroupDto.getId());
        productGroup.setName(productGroupDto.getName());
        return productGroup;
    }
}
