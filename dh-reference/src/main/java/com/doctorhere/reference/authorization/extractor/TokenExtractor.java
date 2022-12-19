package com.doctorhere.reference.authorization.extractor;

/**
 * Implementations of this interface should always return raw base-64 encoded
 * representation of JWT Token.
 * 
 * @author dh-software-team
 *
 * Aug 5, 2016
 */
public interface TokenExtractor {
    public String extract(String payload);
}
