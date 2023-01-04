package com.doctorhere.base.entity;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public class AuditableEntity extends AbstractVersionedEntity {
    @CreatedBy
    @Column(
            insertable = true,
            updatable = false
    )
    private String createdBy;
    @CreatedDate
    @Column(
            insertable = true,
            updatable = false
    )
    private LocalDateTime createdDate;
    @LastModifiedBy
    @Column(
            insertable = false,
            updatable = true
    )
    private String lastModifiedBy;
    @LastModifiedDate
    @Column(
            insertable = false,
            updatable = true
    )
    private LocalDateTime lastModifiedDate;

    public AuditableEntity() {
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public LocalDateTime getCreatedDate() {
        return this.createdDate;
    }

    public String getLastModifiedBy() {
        return this.lastModifiedBy;
    }

    public LocalDateTime getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public void setCreatedBy(final String createdBy) {
        this.createdBy = createdBy;
    }

    public void setCreatedDate(final LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public void setLastModifiedBy(final String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public void setLastModifiedDate(final LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
