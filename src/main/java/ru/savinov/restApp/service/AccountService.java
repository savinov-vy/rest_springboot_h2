package ru.savinov.restApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.savinov.restApp.controller.dto.AccountResponseDTO;
import ru.savinov.restApp.exeption.AccountNotFoundExeption;
import ru.savinov.restApp.entity.Account;
import ru.savinov.restApp.repository.AccountRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountService2 accountService2;

    @Autowired
    public AccountService(AccountRepository accountRepository, AccountService2 accountService2) {
        this.accountRepository = accountRepository;
        this.accountService2 = accountService2;
    }
    /**
     * Для того чтобы параметр Propagation.REQUIRES_NEW работал. Метод должен находится в другом классе
     * подробности см. проект dictionary: transactional.txt
     */
    @Transactional
    public Long createAccount(String name, String email, Integer bill) {
        Account account = new Account(name, email, bill);
        Account createdAcc = accountRepository.save(account);
        accountService2.saveAccount();
        int a = 1/0; // ошибка выполненно специально чтобы код ниже не выполнился
        Account account2 = new Account("Account2", "account2@email.rew", 1000);
        accountRepository.save(account2);
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
