package com.extra_startup_exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.Clock;
import java.util.List;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/greet")
    public GreetResponse greet() {
        return new GreetResponse(
                "Hello",
                List.of("Java", "Python", "C"),
                new Person("Shmuel"));
    }

    record Person(String name){

    }

    record GreetResponse(
            String greet,
            List<String> favProgrammingLanguages,
            Person person) {

    }
}
