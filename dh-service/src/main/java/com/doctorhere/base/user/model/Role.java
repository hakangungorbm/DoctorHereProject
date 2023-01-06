package com.doctorhere.base.user.model;

/**
 * Enumerated {@link User} roles.
 * 
 * @author dh-software-team
 *
 * Aug 16, 2016
 */
public enum Role {
    ADMIN, DOCTOR, PATIENT;
    
    public String authority() {
        return "ROLE_" + this.name();
    }
}
