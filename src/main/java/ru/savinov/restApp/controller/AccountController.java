package ru.savinov.restApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.savinov.restApp.controller.dto.AccountDTO;
import ru.savinov.restApp.service.AccountService;

@RestController
public class AccountController {

    public final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/hello")
    public String helloSpring() {
        return "Hello Spring";
    }

    @PostMapping("/accounts")
    public Long createAccount (@RequestBody AccountDTO accountDTO) {

        Long accountId = accountService.createAccount(accountDTO.getName(),
                accountDTO.getEmail(),
                accountDTO.getBill());
        return accountId;
    }
}
