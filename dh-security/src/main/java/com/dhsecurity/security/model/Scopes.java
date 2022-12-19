package com.dhsecurity.security.model;

/**
 * Scopes
 * 
 * @author dh-software-team
 *
 * Aug 18, 2016
 */
public enum Scopes {
    REFRESH_TOKEN;
    
    public String authority() {
        return "ROLE_" + this.name();
    }
}
