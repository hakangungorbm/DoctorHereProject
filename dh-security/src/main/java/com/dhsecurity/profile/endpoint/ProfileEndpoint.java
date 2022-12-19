package com.dhsecurity.profile.endpoint;

import com.dhsecurity.security.auth.JwtAuthenticationToken;
import com.dhsecurity.security.model.UserContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * End-point for retrieving logged-in user details.
 * 
 * @author dh-software-team
 *
 * Aug 4, 2016
 */
@RestController
public class ProfileEndpoint {

    @RequestMapping(value="/api/me", method=RequestMethod.GET)
    public @ResponseBody UserContext get(JwtAuthenticationToken token) {
        return (UserContext) token.getPrincipal();
    }
}
