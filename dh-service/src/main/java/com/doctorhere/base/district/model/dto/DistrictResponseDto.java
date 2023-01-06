package com.doctorhere.base.district.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class DistrictResponseDto implements Serializable {

    private Long Id;
    private String name;
    private String code;

}