package com.doctorhere.base.user.model;


import com.doctorhere.base.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "USER_ROLE", schema = "dhsecurity")
public class UserRole extends BaseEntity {
    public UserRole() {}

    public UserRole(Role _role, User _user) {
        this.role = _role;
        this.user = _user;
    }

    private static final long serialVersionUID = 800295700842006659L;
    @Enumerated(EnumType.STRING)
    @Column(name = "ROLE", insertable = true, updatable = false)
    @CollectionTable(name = "role")
    protected Role role;

    @JoinColumn(name = "APP_USER_ID")
    @ManyToOne
    protected User user;


}