package com.doctorhere.base.entity;

import org.hibernate.proxy.HibernateProxy;

import javax.persistence.*;

@MappedSuperclass
public abstract class AbstractEntity {
    private static final long serialVersionUID = 8970281518406996101L;
    @Id
    @Column(
            name = "ID",
            unique = true,
            nullable = false
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    protected Long id;

    public AbstractEntity() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj == null) {
            return false;
        } else {
            if (obj instanceof HibernateProxy) {
                obj = ((HibernateProxy)obj).getHibernateLazyInitializer().getImplementation();
            }

            if (this.getClass() != obj.getClass()) {
                return false;
            } else {
                AbstractEntity other = (AbstractEntity)obj;
                if (this.id == null) {
                    return false;
                } else {
                    return this.id.equals(other.id);
                }
            }
        }
    }

    public int hashCode() {
        int result = 1;
        result = 31 * result + (this.id == null ? 0 : this.id.hashCode());
        return result;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }
}
