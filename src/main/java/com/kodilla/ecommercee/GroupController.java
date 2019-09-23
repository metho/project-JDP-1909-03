package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.ProductGroupDto;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/group")
public class GroupController {

    @GetMapping(value = "all")
    public List<ProductGroupDto> getProductGroups() {
        System.out.println("Getting list of groups");
        // implementation
        return new ArrayList<>();
    }

    @GetMapping("{groupId}")
    public ProductGroupDto getProductGroup(@PathVariable Long groupId) {
        System.out.println("Getting a group by id");
        // implementation
        return new ProductGroupDto();
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void createProductGroup(@RequestBody ProductGroupDto productGroupDto) {
        System.out.println("Creating new group.");
        // implementation
    }

    @PutMapping
    public ProductGroupDto updateProductGroup(@RequestBody ProductGroupDto productGroupDto) {
        System.out.println("Updating the Group");
        // implementation
        return new ProductGroupDto();
    }
}
