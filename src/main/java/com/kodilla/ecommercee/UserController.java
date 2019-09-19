package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.UserDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/user")
public class UserController {
    @RequestMapping(method = RequestMethod.POST, value = "createUser")
    public void createUser(@RequestBody UserDto userDto) {
    }

    @RequestMapping(method = RequestMethod.GET, value = "getUserKey")
    public UserDto getUserKey(@RequestParam Long userKey) {
        return new UserDto();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteUserKey")
    public void deleteUserKey(@RequestParam Long userKey) {
    }

    @RequestMapping(method = RequestMethod.PUT, value = "UpdateUser")
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return new UserDto();
    }
}