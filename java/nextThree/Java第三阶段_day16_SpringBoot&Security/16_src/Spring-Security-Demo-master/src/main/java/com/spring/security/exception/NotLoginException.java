package com.spring.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @Author:
 * @Description:
 * @Date Create in
 */
public class NotLoginException extends AuthenticationException {

    public NotLoginException(String msg, Throwable t) {
        super(msg, t);
    }

    public NotLoginException(String msg) {
        super(msg);
    }
}
