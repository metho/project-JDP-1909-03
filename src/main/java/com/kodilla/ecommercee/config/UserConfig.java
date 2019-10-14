package com.kodilla.ecommercee.config;

import com.kodilla.ecommercee.domain.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class UserConfig extends User {

    private String login;

    private String password;
}

