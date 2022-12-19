package com.dhsecurity.security;

import com.dhsecurity.entity.User;

import java.util.Optional;

/**
 * 
 * @author dh-software-team
 *
 * Aug 17, 2016
 */
public interface UserService {
    public Optional<User> getByUsername(String username);
}
