package com.doctorhere.base.district.model;

import com.doctorhere.base.country.model.Country;
import com.doctorhere.base.province.model.Province;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "DH_DISTRICT")
@Data
public class District implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -7466663259649978232L;
    @Id
    @SequenceGenerator(allocationSize = 1, name = "seq_dh_district", sequenceName = "seq_dh_district")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_dh_district")
    private Long id;


    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "code", length = 10)
    private String code;

    @Column(name = "status", length = 3)
    private Boolean status;

    @JoinColumn(name = "country_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Country country;

    @JoinColumn(name = "province_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Province province;

}