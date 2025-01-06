package com.extra_startup_exercise.controller;

import com.extra_startup_exercise.entity.UserAccount;
import com.extra_startup_exercise.service.UserAccountService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
//import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("api/v1/userAccounts")
public class UserAccountController {

    @Autowired
    private UserAccountService userAccountService;

//    // For not validated request
//    record NewUserAccountRequest(
//            String firstName,
//            String surename,
//            String userName,
//            String password
//    ) {
//
//    }

    // Create operation
    @PostMapping("/api/v1/userAccounts")
    public UserAccount createUserAccount(
            @Validated @RequestBody /*NewUserAccountRequest*/ UserAccount request) {
//        // For not validated request use this code & record up lines
//        UserAccount userAccount = new UserAccount();
//        userAccount.setFirstName(request.firstName());
//        userAccount.setSurename(request.surename());
//        userAccount.setUserName(request.userName());
//        userAccount.setPassword(request.password());
//        userAccountService.createUserAccount(userAccount);
        return userAccountService.createUserAccount(request);
    }

    // Load operation
    @GetMapping("/api/v1/userAccounts")
    public List<UserAccount> loadUserAccounts() {
        return userAccountService.loadUserAccountList();
    }

    // Update operation
    @PutMapping("api/v1/userAccounts/{id}")
    public UserAccount updateUserAccount(
            @RequestBody UserAccount detailsToUpdate,
            @PathVariable("id") Integer userAccountId) {
        return userAccountService.updateUserAccount(detailsToUpdate, userAccountId);
    }

    // Delete operation
    @DeleteMapping("api/v1/userAccounts/{id}")
    public String deleteUserAccount(@PathVariable("id") Integer userAccountId) {
        userAccountService.deleteUserAccountById(userAccountId);
        return "Deleted successfully";
    }
}