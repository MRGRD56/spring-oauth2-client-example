package com.mrgrd56.springoauth2.auth;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mrgrd56.springoauth2.dto.Oauth2UserDto;
import com.mrgrd56.springoauth2.utils.ObjectUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final ObjectMapper objectMapper;
    private final OAuth2AuthorizedClientService clientService;

    public AuthService(
            ObjectMapper objectMapper,
            OAuth2AuthorizedClientService clientService) {
        this.objectMapper = objectMapper;
        this.clientService = clientService;
    }

    private OAuth2AuthenticationToken getAuthentication() {
        var authentication = SecurityContextHolder
                .getContext()
                .getAuthentication();

        return ObjectUtils.tryCast(authentication, OAuth2AuthenticationToken.class);
    }

    private OAuth2User getAuthenticatedUser(Authentication authentication) {
        return ObjectUtils.tryCast(authentication.getPrincipal(), OAuth2User.class);
    }

    public Oauth2UserDto getUserInfo() {
        var authentication = getAuthentication();
        if (authentication == null) {
            return null;
        }

        var user = getAuthenticatedUser(authentication);
        if (user == null) {
            return null;
        }

        try {
            var attributes = user.getAttributes();
            var raw = objectMapper.writeValueAsString(attributes);
            return new Oauth2UserDto(
                    authentication.getAuthorizedClientRegistrationId(),
                    user.getAttribute("id"),
                    user.getAttribute("login"),
                    user.getAttribute("avatar_url"),
                    user.getAttribute("email"),
                    raw);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public String getAccessToken() {
        var client = getAuthorizedClient();
        if (client == null) {
            return null;
        }

        return client.getAccessToken().getTokenValue();
    }

    private OAuth2AuthorizedClient getAuthorizedClient() {
        var authentication = getAuthentication();

        if (authentication == null) {
            return null;
        }

        return clientService.loadAuthorizedClient(
                authentication.getAuthorizedClientRegistrationId(),
                authentication.getName());
    }
}
