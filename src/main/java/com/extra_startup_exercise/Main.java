package com.extra_startup_exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("api/v1/user_accounts")
public class Main {

    private final UserAccountRepository userAccountRepository;

    public Main(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping
    public List<UserAccount> getUserAccounts() {
        return userAccountRepository.findAll();
    }

    record NewUserAccountRequest(
            String firstName,
            String surename,
            String userName,
            String password
    ) {

    }

    @PostMapping
    public void addUserAccount(@RequestBody NewUserAccountRequest request) {
        UserAccount userAccount = new UserAccount();
        userAccount.setFirstName(request.firstName());
        userAccount.setSurename(request.surename());
        userAccount.setUserName(request.userName());
        userAccount.setPassword(request.password());
        userAccountRepository.save(userAccount);
    }
}
