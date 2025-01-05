package com.extra_startup_exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
//    @GetMapping("/greet")
//    public GreetResponse greet() {
//        return new GreetResponse(
//                "Hello",
//                List.of("Java", "Python", "C"),
//                new Person("Shmuel"));
//    }
//
//    record Person(String name){
//
//    }
//
//    record GreetResponse(
//            String greet,
//            List<String> favProgrammingLanguages,
//            Person person) {
//
//    }
}
