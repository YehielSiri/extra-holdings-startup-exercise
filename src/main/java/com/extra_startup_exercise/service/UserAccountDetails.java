package com.extra_startup_exercise.service;

import com.extra_startup_exercise.entity.UserAccount;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserAccountDetails implements UserDetails {
    private String username; // Changed from 'name' to 'username' for clarity
    private String password;
    private List<GrantedAuthority> authorities;

    public UserAccountDetails(UserAccount userAccount) {
        this.username = userAccount.getUsername();
        this.password = userAccount.getPassword();
        this.authorities = List.of(userAccount.getRoles().split(","))
                .stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // I'll implement the logic if there will be a need
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // I'll implement the logic if there will be a need
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // I'll implement the logic if there will be a need
    }

    @Override
    public boolean isEnabled() {
        return true; // I'll implement the logic if there will be a need
    }
}
