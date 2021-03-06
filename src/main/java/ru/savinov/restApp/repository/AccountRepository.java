package ru.savinov.restApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.savinov.restApp.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
