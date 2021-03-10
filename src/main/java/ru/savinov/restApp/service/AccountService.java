package ru.savinov.restApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.savinov.restApp.controller.dto.AccountResponseDTO;
import ru.savinov.restApp.exeption.AccountNotFoundExeption;
import ru.savinov.restApp.entity.Account;
import ru.savinov.restApp.repository.AccountRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Long createAccount(String name, String email, Integer bill) {
        Account account = new Account(name, email, bill);
        Account createdAcc = accountRepository.save(account);
        return createdAcc.getId();
    }

    public Account getAccountById(Long id) throws AccountNotFoundExeption {
        return accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundExeption("Can't find account with id: " + id));
    }

    public List<AccountResponseDTO> getAllAccounts() {
        return accountRepository.findAll().stream()
                .map(AccountResponseDTO::new)
                .collect(Collectors.toList());
    }

    public AccountResponseDTO deleteById(Long id) {
        AccountResponseDTO accountRespDTO = new AccountResponseDTO(getAccountById(id));
        accountRepository.deleteById(id);
        return accountRespDTO;
    }
}
