package com.dhsecurity.security.auth.ajax;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Model intended to be used for AJAX based authentication.
 * 
 * @author dh-software-team
 *
 * Aug 3, 2016
 */

public class LoginRequest {
    private String username;
    private String password;
    private String grantType;

    @JsonCreator
    public LoginRequest(@JsonProperty("username") String username, @JsonProperty("password") String password, @JsonProperty("grant_type") String grantType) {
        this.username = username;
        this.password = password;
        this.grantType = grantType;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getGrantType() {
        return grantType;
    }
}
