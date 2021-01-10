package com.emse.spring.faircorp;

import com.emse.spring.faircorp.hello.UserService;

public class NameService {
    private UserService userService;


    public NameService(UserService userService) {
        this.userService = userService;

    }

    public String getName() {
        return "Guillaume";
    }
}
