package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.ProductGroupDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/group")
@Slf4j
public class ProductGroupController {

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void createProductGroup(@RequestBody ProductGroupDto productGroupDto) {
        log.info("Create new product group {}", productGroupDto.getName());
        // implementation
    }

    @GetMapping("{groupId}")
    public ProductGroupDto getProductGroup(@PathVariable Long groupId) {
        log.info("Get group by ID = {}", groupId);
        // implementation
        return new ProductGroupDto();
    }

    @GetMapping(value = "all")
    public List<ProductGroupDto> getProductGroups() {
        log.info("Get list of groups");
        // implementation
        return new ArrayList<>();
    }

    @PutMapping
    public ProductGroupDto updateProductGroup(@RequestBody ProductGroupDto productGroupDto) {
        log.info("Update the group with ID = {}", productGroupDto.getId());
        // implementation
        return new ProductGroupDto();
    }
}
