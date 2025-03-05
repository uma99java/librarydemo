package com.example.Details;

import com.example.demo.Entity.LibrarianEntity;
import com.example.demo.Entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class LibrarianDetails implements UserDetails {
    private final LibrarianEntity librarian;
    String username;
    String parol;

    public LibrarianDetails(LibrarianEntity librarian) {
        this.librarian = librarian;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(librarian.getRole()),
                new SimpleGrantedAuthority(librarian.getName()));
    }

    @Override
    public String getPassword() {
        parol = String.valueOf(librarian.getPassword());
        return parol;
    }

    @Override
    public String getUsername() {
        username = String.valueOf(librarian.getNumber());
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
