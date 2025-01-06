package com.extra_startup_exercise.entity;

import jakarta.persistence.*;
import java.util.Objects;

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
    private String firstName = "";
    private String surename = "";
    private String userName = "";    // Add security validation - username has to be unique!
    private String password = "";

    public UserAccount(String firstName,
                       String surename,
                       String userName,
                       String password) {
        // Validate fields are not null
        if (firstName != null ||
                surename != null ||
                userName != null ||
                password != null) {
            this.firstName = firstName;
            this.surename = surename;
            this.userName = userName;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserAccount that = (UserAccount) o;
        return getFirstName().equals(that.getFirstName()) &&
                getSurename().equals(that.getSurename()) &&
                getUserName().equals(that.getUserName()) &&
                getPassword().equals(that.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getSurename(), getUserName(), getPassword());
    }

    @Override
    public String toString() {
        return "UserAccount{" +
                "firstName='" + firstName + '\'' +
                ", surename='" + surename + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
