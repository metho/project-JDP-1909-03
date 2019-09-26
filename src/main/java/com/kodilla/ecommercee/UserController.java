package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("v1/user")
public class UserController {

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) {
        System.out.println("Create new user");
    }

    @GetMapping({"userId"})
    public UserDto getUser(@PathVariable Long userId) {
        System.out.println("Get user by ID");
        return new UserDto();
    }

    @GetMapping(value = "all")
    public List<UserDto> getAllUsers() {
        System.out.println("Getting list of users");
        return new ArrayList<>();
    }

    @DeleteMapping("{userId}")
    public void deleteUserById(@PathVariable Long userId) {
        System.out.println("Delete user by ID");
    }

    @PutMapping
    public UserDto updateUser(@RequestBody UserDto userDto) {
        System.out.println("Update the user");
        return new UserDto();
    }
}
