package com.example.config.security;

import com.example.account.entities.Account;
import com.example.department.entities.Department;
import com.example.account.enums.Role;
import lombok.Builder;

import java.util.Map;

@Builder
public record OauthProvider(Map<String, Object> provider, String providerKey, String name, String email,
                            String picture) {

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

    public Account toEntity(Department department) {
        return Account.builder()
                .name(name)
                .email(email)
                .picture(picture)
                .role(Role.GUEST)
                .department(department)
                .build();
    }
}
