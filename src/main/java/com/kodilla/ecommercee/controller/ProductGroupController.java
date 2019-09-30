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

    @GetMapping(value = "all")
    public List<ProductGroupDto> getProductGroups() {
        log.info("Getting list of groups");
        // implementation
        return new ArrayList<>();
    }

    @GetMapping("{groupId}")
    public ProductGroupDto getProductGroup(@PathVariable Long groupId) {
        log.info("Getting a group by id");
        // implementation
        return new ProductGroupDto();
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void createProductGroup(@RequestBody ProductGroupDto productGroupDto) {
        log.info("Creating new group.");
        // implementation
    }

    @PutMapping
    public ProductGroupDto updateProductGroup(@RequestBody ProductGroupDto productGroupDto) {
        log.info("Updating the Group");
        // implementation
        return new ProductGroupDto();
    }
}
