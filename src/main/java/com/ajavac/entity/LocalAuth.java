package com.ajavac.entity;

import com.ajavac.constants.Role;
import com.ajavac.dto.LocalAuthInfo;

import javax.persistence.*;

/**
 * Created by wyp0596 on 05/03/2017.
 */
@Entity
public class LocalAuth {

    @Id
    @GeneratedValue
    private long localAuthId;

    @Column(unique = true, updatable = false, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(updatable = false, nullable = false)
    private Role role;

    public LocalAuth() {
    }

    public LocalAuth(LocalAuthInfo localAuthInfo) {
        this.username = localAuthInfo.getUsername();
        this.password = localAuthInfo.getPassword();
        this.role = Role.typeOf(localAuthInfo.getType());
    }

    public LocalAuth(String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public long getLocalAuthId() {
        return localAuthId;
    }

    public void setLocalAuthId(long localAuthId) {
        this.localAuthId = localAuthId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
