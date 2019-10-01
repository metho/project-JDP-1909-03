package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.UserDto;
import com.kodilla.ecommercee.exception.UserNotFoundException;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("v1/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) {
        System.out.println("Create new user");
        userService.saveUser(userMapper.mapToUser(userDto));
    }

    @GetMapping("{userId}")
    public UserDto getUser(@PathVariable Long userId) throws UserNotFoundException {
        System.out.println("Get user by ID");
        return userMapper.mapToUserDto(userService.getUser(userId).orElseThrow(UserNotFoundException::new));
    }

    @GetMapping(value = "all")
    public List<UserDto> getAllUsers() {
        System.out.println("Getting list of users");
        return userMapper.mapToUserDtoList(userService.getAllUsers());
    }

    @DeleteMapping("{userId}")
    public void deleteUserById(@PathVariable Long userId) {
        System.out.println("Delete user by ID");
        userService.deleteUserById(userId);
    }

    @PutMapping
    public UserDto updateUser(@RequestBody UserDto userDto) {
        System.out.println("Update the user");
        return userMapper.mapToUserDto(userService.saveUser(userMapper.mapToUser(userDto)));
    }
}
