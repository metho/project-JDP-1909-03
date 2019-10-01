package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.UserDto;
import com.kodilla.ecommercee.exception.UserNotFoundException;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("v1/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public void createUser(@RequestBody UserDto userDto) {
        log.info("Create new user " + userDto.getName() + " " + userDto.getSurname());
        userService.saveUser(userMapper.mapToUser(userDto));
    }

    @GetMapping("{userId}")
    public UserDto getUser(@PathVariable Long userId) throws UserNotFoundException {
        log.info("Get user by ID " + userId);
        return userMapper.mapToUserDto(userService.getUser(userId).orElseThrow(UserNotFoundException::new));
    }

    @GetMapping(value = "all")
    public List<UserDto> getAllUsers() {
        log.info("Get list of users");
        return userMapper.mapToUserDtoList(userService.getAllUsers());
    }

    @DeleteMapping("{userId}")
    public void deleteUserById(@PathVariable Long userId) {
        log.info("Delete user by ID " + userId);
        userService.deleteUserById(userId);
    }

    @PutMapping
    public UserDto updateUser(@RequestBody UserDto userDto) {
        log.info("Update the user with ID " + userDto.getId());
        return userMapper.mapToUserDto(userService.saveUser(userMapper.mapToUser(userDto)));
    }
}
