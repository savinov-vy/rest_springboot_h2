package ru.savinov.restApp.controller.dto;

import ru.savinov.restApp.entity.Account;

public class AccountResponseDTO {

    private Long id;

    private String name;

    private String email;

    private Integer bill;

    public AccountResponseDTO(Long id, String name, String email, Integer bill) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.bill = bill;
    }

    public AccountResponseDTO(Account account) {
        this.id = account.getId();
        this.name = account.getName();
        this.email = account.getEmail();
        this.bill = account.getBill();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getBill() {
        return bill;
    }

    public void setBill(Integer bill) {
        this.bill = bill;
    }
}
