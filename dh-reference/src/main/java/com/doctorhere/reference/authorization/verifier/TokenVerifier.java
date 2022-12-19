package com.doctorhere.reference.authorization.verifier;

/**
 * 
 * @author dh-software-team
 *
 * Aug 17, 2016
 */
public interface TokenVerifier {
    public boolean verify(String jti);
}
