package com.ajavac.dto;

import com.ajavac.entity.LocalAuth;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

/**
 * Created by wyp0596 on 05/03/2017.
 */
public class LocalAuthInfo {

    private long localAuthId;

    @Length(min = 1, max = 32)
    private String username;

    @NotBlank
    @Length(min = 1, max = 32)
    private String password;

    @Range(min = 0, max = 1)
    private int type;

    public LocalAuthInfo() {
    }

    public LocalAuthInfo(LocalAuth localAuth) {
        this.localAuthId = localAuth.getLocalAuthId();
        this.type = localAuth.getRole().getType();
        this.username = localAuth.getUsername();
    }

    public long getLocalAuthId() {
        return localAuthId;
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

    @Override
    public String toString() {
        return "LocalAuthInfo{" +
                "localAuthId=" + localAuthId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", type=" + type +
                '}';
    }
}
