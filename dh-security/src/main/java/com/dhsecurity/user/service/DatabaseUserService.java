package com.dhsecurity.user.service;

import com.dhsecurity.entity.User;
import com.dhsecurity.security.UserService;
import com.dhsecurity.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Mock implementation.
 * 
 * @author dh-software-team
 *
 * Aug 4, 2016
 */
@Service
public class DatabaseUserService implements UserService {
    private final UserRepository userRepository;
    
    @Autowired
    public DatabaseUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    public UserRepository getUserRepository() {
        return userRepository;
    }

    @Override
    public Optional<User> getByUsername(String username) {
        return this.userRepository.findByUsername(username);
    }
}
