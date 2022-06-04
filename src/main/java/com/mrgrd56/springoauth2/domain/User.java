package com.mrgrd56.springoauth2.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @deprecated Unused
 */
@Entity
@Table(name = "users", schema = "public")
public class User extends Base {
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
