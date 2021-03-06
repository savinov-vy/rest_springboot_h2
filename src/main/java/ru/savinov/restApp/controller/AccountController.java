package ru.savinov.restApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.savinov.restApp.controller.dto.AccoutnRestDTO;

@RestController
public class AccountController {

    @GetMapping("/hello")
    public String helloSpring() {
        return "Hello Spring";
    }

    @PostMapping("/accounts")
    public Long createAccount (@RequestBody AccoutnRestDTO accoutnRestDTO) {

        return 1L;
    }
}
