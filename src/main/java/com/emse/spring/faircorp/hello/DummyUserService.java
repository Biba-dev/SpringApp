package com.emse.spring.faircorp.hello;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DummyUserService implements UserService {
    private GreetingService greetingService;

    public DummyUserService(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @Override
    public void greetAll() {
        List<String> list = new ArrayList<String>();
        list.add("Elodie");
        greetingService.greet("Elodie");
        list.add("Charles");
        greetingService.greet("Charles");
    }

}
