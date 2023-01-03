package com.doctorhere.base.country.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "DH_COUNTRY",schema = "DHSERVICE")
@Data
public class Country implements Serializable {

    private static final long serialVersionUID = 4614107130986786276L;
    @Id
    @SequenceGenerator(allocationSize = 1, name = "seq_dh_country", sequenceName = "seq_dh_country")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_dh_country")
    private Long Id;
    @Column(name = "name", length = 150)
    private String name;
    @Column(name = "code", length = 50)
    private String code;
    @Column(name = "phone_code", length = 20)
    private String phoneCode;

}