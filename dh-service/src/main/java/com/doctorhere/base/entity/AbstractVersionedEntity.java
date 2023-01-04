package com.doctorhere.base.entity;

import javax.persistence.*;

@MappedSuperclass
public class AbstractVersionedEntity extends AbstractEntity {
    private static final long serialVersionUID = 1L;
    @Version
    @Column(
            name = "VERSION"
    )
    private int version = 0;

    public AbstractVersionedEntity() {
    }

    public int getVersion() {
        return this.version;
    }

    public void setVersion(final int version) {
        this.version = version;
    }
}
