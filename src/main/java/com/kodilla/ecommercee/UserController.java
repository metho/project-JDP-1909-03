package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("v1/user")
public class UserController {
    @PostMapping
    public void createUser(@RequestBody UserDto userDto) {
    }

    @GetMapping({"userKey"})
    public UserDto getUser(@RequestParam String userKey) {
        return new UserDto();
    }

    @GetMapping
    public List<UserDto> getAllUsers(@RequestBody UserDto userDto) {
        return new ArrayList<UserDto>();
    }

    @DeleteMapping("{userKey}")
    public void deleteUserById(@PathVariable String userKey) {
    }

    @PutMapping("update")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return new UserDto();
    }
}
