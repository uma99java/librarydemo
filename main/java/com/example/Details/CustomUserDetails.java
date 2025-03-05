package com.example.Details;

import com.example.demo.Entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

@Component
public class CustomUserDetails implements org.springframework.security.core.userdetails.UserDetails {
    private final UserEntity user;
    String username;
    String parol;

    public CustomUserDetails(UserEntity user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(
                new SimpleGrantedAuthority(user.getRole()), // Роль
                new SimpleGrantedAuthority(user.getName())  // Имя
        );
    }


    @Override
    public String getPassword() {
        parol = String.valueOf(user.getPassword());
        return parol;
    }

    @Override
    public String getUsername() {
        username = String.valueOf(user.getNumber());
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

