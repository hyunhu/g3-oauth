package com.example.config.security;

import com.example.account.entities.Account;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private final String name;
    private final String email;
    private final String picture;

    public SessionUser(Account account) {
        this.name = account.getName();
        this.email = account.getEmail();
        this.picture = account.getPicture();
    }
}
