package com.doctorhere.base.province.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProvinceResponseDto implements Serializable {

    private Long Id;
    private String name;
    private String phoneCode;

}