package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.ProductGroupDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/group")
public class ProductGroupController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductGroupController.class);

    @GetMapping(value = "all")
    public List<ProductGroupDto> getProductGroups() {
        LOGGER.info("Getting list of groups");
        // implementation
        return new ArrayList<>();
    }

    @GetMapping("{groupId}")
    public ProductGroupDto getProductGroup(@PathVariable Long groupId) {
        LOGGER.info("Getting a group by id: " + groupId);
        // implementation
        return new ProductGroupDto("name", groupId , new ArrayList<>());
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void createProductGroup(@RequestBody ProductGroupDto productGroupDto) {
        LOGGER.info("Creating new group: "
                    + " ID: " + productGroupDto.getId()
                    + " name: " + productGroupDto.getName()
                    + " products: " + productGroupDto.getProducts());
        // implementation
    }

    @PutMapping
    public ProductGroupDto updateProductGroup(@RequestBody ProductGroupDto productGroupDto) {
        LOGGER.info("Updating the Group with: "
                + " ID: " + productGroupDto.getId()
                + " name: " + productGroupDto.getName()
                + " products: " + productGroupDto.getProducts());
        // implementation
        return productGroupDto;
    }
}
