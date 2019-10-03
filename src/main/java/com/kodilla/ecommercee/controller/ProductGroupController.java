package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.ProductGroupDto;
import com.kodilla.ecommercee.exception.ProductGroupNotFoundException;
import com.kodilla.ecommercee.mapper.ProductGroupMapper;
import com.kodilla.ecommercee.service.ProductGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/group")
public class ProductGroupController {
    @Autowired
    private ProductGroupService productGroupService;

    @Autowired
    private ProductGroupMapper productGroupMapper;

    @GetMapping(value = "all")
    public List<ProductGroupDto> getProductGroups() {
        System.out.println("Getting list of groups");
        return productGroupMapper.mapToProductGroupDtoList(productGroupService.findAllProductGroups());
    }

    @GetMapping("{groupId}")
    public ProductGroupDto getProductGroup(@PathVariable Long groupId) throws ProductGroupNotFoundException {
        System.out.println("Getting a group by id");
        return productGroupMapper.mapToProductGroupDto(productGroupService.findGroupById(groupId).orElseThrow(ProductGroupNotFoundException::new));
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void createProductGroup(@RequestBody ProductGroupDto productGroupDto) {
        System.out.println("Creating new group.");
        productGroupService.saveProductGroup(productGroupMapper.mapToProductGroup(productGroupDto));
    }

    @PutMapping
    public ProductGroupDto updateProductGroup(@RequestBody ProductGroupDto productGroupDto) {
        System.out.println("Updating the Group");
        return productGroupMapper.mapToProductGroupDto(productGroupService.saveProductGroup(productGroupMapper.mapToProductGroup(productGroupDto)));
    }
}
