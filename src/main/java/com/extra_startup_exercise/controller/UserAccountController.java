package com.extra_startup_exercise.controller;

import com.extra_startup_exercise.entity.UserAccount;
//import com.extra_startup_exercise.service.UserAccountService;     # BUG: He can't decode this interface!
import com.extra_startup_exercise.service.*;
import java.util.List;

import io.micrometer.core.annotation.Timed;
import org.springframework.beans.factory.annotation.Autowired;
//import jakarta.validation.Valid;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
public class UserAccountController {

    @Autowired
    private UserAccountService userAccountService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;


//    // For not validated request use this code & record up lines
//    record NewUserAccountRequest(
//            String firstName,
//            String surename,
//            String userName,
//            String password
//    ) {
//
//    }

    // Create operation
    @PostMapping("/createNewUserAccount")
    @Timed(value = "endpoints.prometheus")
    public UserAccount createUserAccount(
            @Validated @RequestBody /*NewUserAccountRequest*/ UserAccount request) {
//        // For not validated request use this code & record up lines & change the argument type.
//        UserAccount userAccount = new UserAccount();
//        userAccount.setFirstName(request.firstName());
//        userAccount.setSurename(request.surename());
//        userAccount.setUserName(request.userName());
//        userAccount.setPassword(request.password());
//        userAccountService.createUserAccount(userAccount);
        return userAccountService.createUserAccount(request);
    }

    // Load operations:
    // Load operation for USER role
    @GetMapping("/user/userAccounts")
    @Timed(value = "endpoints.prometheus")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public List<UserAccount> userLoadUserAccounts() {
        return userAccountService.loadUserAccountList();
    }
    // Load operation for ADMIN role
    @GetMapping("/admin/userAccounts")
    @Timed(value = "endpoints.prometheus")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<UserAccount> adminLoadUserAccounts() {
        return userAccountService.loadUserAccountList();
    }

    // Update operation
    @PutMapping("/userAccounts/{id}")
    @Timed(value = "endpoints.prometheus")
    public UserAccount updateUserAccount(
            @RequestBody UserAccount detailsToUpdate,
            @PathVariable("id") Integer userAccountId) {
        return userAccountService.updateUserAccount(detailsToUpdate, userAccountId);
    }

    // Delete operation
    @DeleteMapping("/userAccounts/{id}")
    @Timed(value = "endpoints.prometheus")
    public String deleteUserAccount(@PathVariable("id") Integer userAccountId) {
        userAccountService.deleteUserAccountById(userAccountId);
        return "Deleted successfully";
    }

    @PostMapping("/generateToken")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
        );
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("Invalid user request!");
        }
    }

}