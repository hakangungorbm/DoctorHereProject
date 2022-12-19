package com.dhsecurity.security.auth.jwt.verifier;

import org.springframework.stereotype.Component;

/**
 * BloomFilterTokenVerifier
 * 
 * @author dh-software-team
 *
 * Aug 17, 2016
 */
@Component
public class BloomFilterTokenVerifier implements TokenVerifier {
    @Override
    public boolean verify(String jti) {
        return true;
    }
}
