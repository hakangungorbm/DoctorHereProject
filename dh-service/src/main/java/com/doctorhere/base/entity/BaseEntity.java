package com.doctorhere.base.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.dao.OptimisticLockingFailureException;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
@AttributeOverrides({
        @AttributeOverride(name = "lastModifiedDate", column = @Column(insertable = true)),
        @AttributeOverride(name = "lastModifiedBy", column = @Column(insertable = true))
})
public abstract class BaseEntity extends AuditableEntity {
    private boolean deleted = false;

    @Override
    public void setVersion(int version) {
        if (version != this.getVersion()) {
            throw new OptimisticLockingFailureException("");
        }
    }
}
