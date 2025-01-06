package com.extra_startup_exercise;

import com.extra_startup_exercise.entity.UserAccount;
import com.extra_startup_exercise.repository.UserAccountRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("api/v1/userAccounts")
public class Main {

    private final UserAccountRepository userAccountRepository;

    public Main(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    // Load operation
    @GetMapping
    public List<UserAccount> loadUserAccounts() {
        return userAccountRepository.findAll();
    }

    record NewUserAccountRequest(
            String firstName,
            String surename,
            String userName,
            String password
    ) {

    }

    // Create operation
    @PostMapping
    public String createUserAccount(@RequestBody NewUserAccountRequest request) {
        UserAccount userAccount = new UserAccount();
        userAccount.setFirstName(request.firstName());
        userAccount.setSurename(request.surename());
        userAccount.setUserName(request.userName());
        userAccount.setPassword(request.password());
        userAccountRepository.save(userAccount);
        return "Saved successfully";
    }

    // Delete operation
    @DeleteMapping("api/v1/userAccounts/{userAccountId}")
    public String deleteUserAccount(@PathVariable("userAccountId") Integer id) {
        userAccountRepository.deleteById(id);
        return "Deleted successfully";
    }

    // Update operation
    @PutMapping("api/v1/userAccounts/{userAccountId}")
    public UserAccount updateUserAccount(
            @RequestBody NewUserAccountRequest request,
            @PathVariable("userAccountId") Integer id) {
        UserAccount toUpdate = userAccountRepository.findById(id).get();
        toUpdate.setFirstName(request.firstName);
        toUpdate.setSurename(request.surename);
        toUpdate.setUserName(request.userName);
        toUpdate.setPassword(request.password);
        return userAccountRepository.save(toUpdate);
    }

}
