package ru.savinov.restApp.exeption;

public class AccountNotFoundExeption extends RuntimeException {

    public AccountNotFoundExeption(String message) {
        super(message);
    }
}
