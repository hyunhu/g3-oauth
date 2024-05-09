package com.example.config.security;

import com.example.account.entities.Account;
import com.example.account.enums.Role;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OauthProvider {
    private final Map<String, Object> provider;
    private final String providerKey;
    private final String name;
    private final String email;
    private final String picture;

    @Builder
    public OauthProvider(Map<String, Object> provider, String providerKey, String name, String email, String picture) {
        this.provider = provider;
        this.providerKey = providerKey;
        this.name = name;
        this.email = email;
        this.picture = picture;
    }

    public static OauthProvider of(String registrationId, String name, Map<String, Object> attributes) {
        return ofGoogle(name, attributes);
    }

    private static OauthProvider ofGoogle(String name, Map<String, Object> provider) {
        return OauthProvider.builder()
                .name((String) provider.get("name"))
                .email((String) provider.get("email"))
                .picture((String) provider.get("picture"))
                .provider(provider)
                .providerKey(name)
                .build();
    }

    public Account toEntity() {
        return Account.builder()
                .name(name)
                .email(email)
                .picture(picture)
                .role(Role.GUEST)
                .build();
    }
}
