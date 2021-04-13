package ru.savinov.restApp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.savinov.restApp.entity.Account;
import ru.savinov.restApp.repository.AccountRepository;

@Component
public class AccountService2 {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService2(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    /**
     * Для того чтобы параметр Propagation.REQUIRES_NEW работал. Метод должен находится в другом классе
     * подробности см. проект dictionary: transactional.txt
     */

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveAccount() {
        Account account3 = new Account("Bob", "bob@email.bo", 222);
    }
}
