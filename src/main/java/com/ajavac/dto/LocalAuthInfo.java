package com.ajavac.dto;

import com.ajavac.entity.LocalAuth;

/**
 * Created by wyp0596 on 05/03/2017.
 */
public class LocalAuthInfo {

    private String username;

    private String password;

    private int type;

    public LocalAuthInfo() {
    }

    public LocalAuthInfo(LocalAuth localAuth) {
        this.type = localAuth.getRole().getType();
        this.username = localAuth.getUsername();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getType() {
        return type;
    }
}
