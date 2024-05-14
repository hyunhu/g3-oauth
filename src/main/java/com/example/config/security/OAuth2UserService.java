package com.example.config.security;

import com.example.account.entities.Account;
import com.example.account.enums.Role;
import com.example.account.repositories.AccountRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class OAuth2UserService implements org.springframework.security.oauth2.client.userinfo.OAuth2UserService<OAuth2UserRequest, OAuth2User> {
    private final AccountRepository accountRepository;
    private final HttpSession httpSession;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        org.springframework.security.oauth2.client.userinfo.OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();

        OauthProvider provider = OauthProvider.of(registrationId, userNameAttributeName, oAuth2User.getAttributes());

        Account account = saveOrUpdate(provider);

        httpSession.setAttribute("user", new SessionUser(account));

        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority(
                        account.getRoleKey())),
                provider.provider(),
                provider.providerKey()
        );
    }

    private Account saveOrUpdate(OauthProvider provider) {
        Account account = accountRepository.findByEmail(provider.email())
                .map(entity -> entity.update(provider.name(), provider.picture()))
                .orElseGet(() -> {
                    Account newAccount = provider.toEntity();
                    newAccount.addRole(Role.GUEST); // 최초 로그인
                    return newAccount;
                });

        if (account.getRole() == Role.GUEST && account.getEmail().equals("hyunhu0309@gmail.com")) { // Role 부여 조건 예시
            account.addRole(Role.USER);
        }

        return accountRepository.save(account);
    }

}
