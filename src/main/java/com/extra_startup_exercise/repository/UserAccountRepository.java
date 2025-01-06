package com.extra_startup_exercise.repository;

import com.extra_startup_exercise.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository
        extends JpaRepository<UserAccount, Integer> {
}
