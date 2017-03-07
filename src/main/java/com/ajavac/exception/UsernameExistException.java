package com.ajavac.exception;

/**
 * Created by wyp0596 on 05/03/2017.
 */
public class UsernameExistException extends RuntimeException {

    public UsernameExistException() {
        super("用户名已存在");
    }
}
