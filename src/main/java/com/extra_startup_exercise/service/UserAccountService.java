// Java Program to Demonstrate UserAccountService File

package com.extra_startup_exercise.service;

import com.extra_startup_exercise.entity.UserAccount;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UserAccountService {

    // Create operation
    UserAccount createUserAccount(UserAccount userAccount);

    // Load operation
    List<UserAccount> loadUserAccountList();

    // Update operation
    UserAccount updateUserAccount(UserAccount detailsToUpdate,
                                  Integer userAccountIdInDB);

    // Delete operation
    String deleteUserAccountById(Integer userAccountId);
}