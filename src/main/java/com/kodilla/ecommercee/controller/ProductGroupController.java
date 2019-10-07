package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.ProductGroupDto;
import com.kodilla.ecommercee.exception.ProductGroupNotFoundException;
import com.kodilla.ecommercee.mapper.ProductGroupMapper;
import com.kodilla.ecommercee.service.ProductGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/group")
@Slf4j
public class ProductGroupController {
    @Autowired
    private ProductGroupService productGroupService;

    @Autowired
    private ProductGroupMapper productGroupMapper;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void createProductGroup(@RequestBody ProductGroupDto productGroupDto) {
        log.info("Create new product group {}", productGroupDto.getName());
        productGroupService.saveProductGroup(productGroupMapper.toProductGroup(productGroupDto));
    }

    @GetMapping("{groupId}")
    public ProductGroupDto getProductGroup(@PathVariable Long groupId) throws ProductGroupNotFoundException {
        log.info("Get group by ID = {}", groupId);
        return productGroupMapper.toProductGroupDto(productGroupService.findGroupById(groupId).orElseThrow(ProductGroupNotFoundException::new));
    }

    @GetMapping(value = "all")
    public List<ProductGroupDto> getProductGroups() {
        log.info("Get list of groups");
        return productGroupMapper.toProductGroupDtoList(productGroupService.findAllProductGroups());
    }

    @PutMapping
    public ProductGroupDto updateProductGroup(@RequestBody ProductGroupDto productGroupDto) {
        log.info("Update the group with ID = {}", productGroupDto.getId());
        return productGroupMapper.toProductGroupDto(productGroupService.saveProductGroup(productGroupMapper.toProductGroup(productGroupDto)));
    }
}
