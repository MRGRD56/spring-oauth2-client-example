package com.mrgrd56.springoauth2.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Objects;

public class Oauth2UserDto {
    private String registration;
    private Integer id;
    private String login;
    private String avatarUrl;
    private String email;
    private String raw;

    public Oauth2UserDto() {
    }

    public Oauth2UserDto(String registration, Integer id, String login, String avatarUrl, String email, String raw) {
        this.registration = registration;
        this.id = id;
        this.login = login;
        this.avatarUrl = avatarUrl;
        this.email = email;
        this.raw = raw;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Oauth2UserDto userInDto = (Oauth2UserDto) o;

        return Objects.equals(id, userInDto.id);
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
