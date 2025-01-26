package com.extra_startup_exercise.repository;

import com.extra_startup_exercise.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAccountRepository
        extends JpaRepository<UserAccount, Integer> {
    Optional<UserAccount> findByUsername(String username); // The 'email' field is used for login
}