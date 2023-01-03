package com.doctorhere.base.profession.model;


import com.doctorhere.base.entity.BaseEntity;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Entity
@Table(name="DH_PROFESSION")
@Getter
@Setter
@NoArgsConstructor
@SQLDelete(sql ="update dh_profession set deleted = true where id = ? and version=?")
@Where(clause = "deleted = false")
public class Profession extends BaseEntity {

    @Column(name="sort_order", length = 3)
	private Integer sortOrder;
    @Column(name="name", length = 100)
    private String name;
    @Column(name="description", length = 500)
    private String description;
    @Column(name="sub_description", length = 500)
    private String subDescription;
    @Column(name = "image_url", length = 150)
    private String  image;
    @ManyToOne
    @JoinColumn(name="parent_id", nullable = true)
    private Profession parent;
    @Column(name = "tag", length = 500)
    private String  tag;
    //bu uzmanlık alanında önerilen görüşme kaç dk olmalı
    @Column(name = "time", length = 5)
    private Integer  time;
    @Column(name = "status", length = 150)
    private Boolean status;
}
	 
