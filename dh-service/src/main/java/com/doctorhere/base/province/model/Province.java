package com.doctorhere.base.province.model;

import com.doctorhere.base.country.model.Country;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "DH_PROVINCE")
@Data
public class Province implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -1414027368609159887L;
    @Id
    @SequenceGenerator(allocationSize = 1, name = "seq_dh_province", sequenceName = "seq_dh_province")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_dh_province")
    private Long id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "code", length = 10)
    private String code;

    @JoinColumn(name = "country_id")
    @ManyToOne
    private Country country;

    @Column(name = "phone_code", length = 20)
    private String phoneCode;

}