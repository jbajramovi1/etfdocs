package com.etfdoc.etfdoc.ViewModels;

import com.etfdoc.etfdoc.Models.Account;

public class AccountVM {

    private Long id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    public AccountVM(Long id, String email, String password, String firstName, String lastName){
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public AccountVM(String email, String password, String firstName, String lastName){
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public AccountVM(Account account){
        this.id = account.getId();
        this.email = account.getEmail();
        this.password = account.getPassword();
        this.firstName = account.getFirstName();
        this.lastName = account.getLastName();
    }

    public Long getId() {
        return id;
    }


    public String getEmail() {
        return email;
    }


    public String getPassword() {
        return password;
    }


    public String getFirstName() {
        return firstName;
    }


    public String getLastName() {
        return lastName;
    }

}
