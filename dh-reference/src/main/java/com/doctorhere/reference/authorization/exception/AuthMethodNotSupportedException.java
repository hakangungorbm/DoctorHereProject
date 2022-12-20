package com.doctorhere.reference.authorization.exception;

import org.springframework.security.authentication.AuthenticationServiceException;

/**
 * 
 * @author dh-software-team
 *
 * Aug 4, 2016
 */
public class AuthMethodNotSupportedException extends AuthenticationServiceException {
    private static final long serialVersionUID = 3705043083010304496L;

    public AuthMethodNotSupportedException(String msg) {
        super(msg);
    }
}
