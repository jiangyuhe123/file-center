package com.ajavac.exception;

/**
 * Created by wyp0596 on 05/03/2017.
 */
public class IdNotFoundException extends RuntimeException {

    public IdNotFoundException() {
        super("记录不存在");
    }
}
