package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    public User toUser(final UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getName(),
                userDto.getSurname()
        );
    }

    public UserDto toUserDto(final User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getSurname()
        );
    }

    public List<UserDto> toUserDtoList(final List<User> userList) {
        return userList.stream()
                .map(t -> new UserDto(t.getId(), t.getName(), t.getSurname()))
                .collect(Collectors.toList());
    }
}
