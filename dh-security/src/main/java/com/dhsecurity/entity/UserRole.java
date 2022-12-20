package com.dhsecurity.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * UserRole
 * 
 * @author dh-software-team
 *
 *         Aug 18, 2016
 */
@Entity
@Table(name = "user_role")
public class UserRole {
    @Embeddable
    public static class Id implements Serializable {
        private static final long serialVersionUID = 1322120000551624359L;
        
        @Column(name = "APP_USER_ID")
        protected Long userId;
        
        @Enumerated(EnumType.STRING)
        @Column(name = "ROLE")
        protected Role role;
        
        public Id() { }

        public Id(Long userId, Role role) {
            this.userId = userId;
            this.role = role;
        }
    }
    
    @EmbeddedId
    Id Id = new Id();
    
    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE", insertable=false, updatable=false)
    protected Role role;

    public Role getRole() {
        return role;
    }
}
