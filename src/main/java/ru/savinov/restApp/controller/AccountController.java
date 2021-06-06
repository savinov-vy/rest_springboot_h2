package ru.savinov.restApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import ru.savinov.restApp.exeption.AccountNotFoundExeption;
import ru.savinov.restApp.controller.dto.AccountRequestDTO;
import ru.savinov.restApp.controller.dto.AccountResponseDTO;
import ru.savinov.restApp.entity.Account;
import ru.savinov.restApp.service.AccountService;

import java.util.List;

@RestController
public class AccountController {

    public final AccountService accountService;

    @Value("${spring.greeting}")
    private String greeting;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/hello")
    public String helloSpring() {
        return greeting;
    }

    @PostMapping("/accounts")
    public Long createAccount(@RequestBody AccountRequestDTO accountRequestDTO) {

        Long accountId = accountService.createAccount(accountRequestDTO.getName(),
                accountRequestDTO.getEmail(),
                accountRequestDTO.getBill());
        return accountId;
    }

    @GetMapping("/accounts/{id}")
    public AccountResponseDTO getAccount(@PathVariable Long id) throws AccountNotFoundExeption {
        Account account = accountService.getAccountById(id);
        return new AccountResponseDTO(account);
    }

    @GetMapping("/accounts/all")
    public List<AccountResponseDTO> getAllAccount() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/string")
    public String getString(@RequestParam(name = "ABC", required = false, defaultValue = "DEF") String line) {
        return line;
    }

    @DeleteMapping("/accounts/{id}")
    public AccountResponseDTO deleteById(@PathVariable Long id) {
        return accountService.deleteById(id);
    }
}
