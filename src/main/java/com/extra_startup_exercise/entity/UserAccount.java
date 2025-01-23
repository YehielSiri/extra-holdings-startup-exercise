package com.extra_startup_exercise.entity;

import jakarta.persistence.*;

import java.util.Objects;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@Entity
public class UserAccount {
    @Id
    @SequenceGenerator(
        name = "userAccount_id_sequence",
            sequenceName = "userAccount_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
            generator = "userAccount_id_sequence"
    )
    private Integer id;   // Will get a primary key from JPA

    @NotBlank(message = "User Account first name can't be left empty")
    private String firstName = "";

    @NotBlank(message = "User Account last name can't be left empty")
    private String surename = "";

    @NotNull(message = "Email can not be NULL")
    @Email(message = "Please enter a valid email Id") // Using 'email' because it's the correct field for login
    @Column(unique = true)  // A security validation - username has to be unique!
    private String username = "";

    @Size(min = 8, max = 8, message = "Password should have a length of 8 characters.")
    private String password = "";

    // For authentication & authorization by Spring Boot security.
    @Enumerated(EnumType.STRING)
    private Role role;

    public UserAccount(String firstName,
                       String surename,
                       String username,
                       String password) {
        // Validate fields are not null
        if (firstName != null ||
                surename != null ||
                username != null ||
                password != null) {
            this.firstName = firstName;
            this.surename = surename;
            this.username = username;
            this.password = password;
        }
    }

    public UserAccount() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurename() {
        return surename;
    }

    public void setSurename(String surename) {
        this.surename = surename;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAccount that = (UserAccount) o;
        return getFirstName().equals(that.getFirstName()) &&
                getSurename().equals(that.getSurename()) &&
                getUsername().equals(that.getUsername()) &&
                getPassword().equals(that.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getSurename(), getUsername(), getPassword());
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "firstName='" + firstName + '\'' +
                ", surename='" + surename + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
