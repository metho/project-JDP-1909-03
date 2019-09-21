package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.GroupDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/group")
public class GroupController {

    @GetMapping(value = "all")
    public List<GroupDto> getGroups() {
        System.out.println("Getting list of groups");
        // implementation
        return new ArrayList<>();
    }

    @GetMapping("{groupId}")
    public GroupDto getGroup(@PathVariable Long groupId) {
        System.out.println("Getting a group by id");
        // implementation
        return new GroupDto();
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void createGroup(@RequestBody GroupDto groupDto) {
        System.out.println("Creating new group.");
        // implementation
    }

    @PutMapping
    public GroupDto updateGroup(@RequestBody GroupDto groupDto) {
        System.out.println("Updating the Group");
        // implementation
        return new GroupDto();
    }
}
