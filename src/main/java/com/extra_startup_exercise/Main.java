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
}
