package com.ajavac.exception;

/**
 * Created by wyp0596 on 05/03/2017.
 */
public class LoginException extends RuntimeException {

    public LoginException() {
        super("用户名或密码错误");
    }
}
