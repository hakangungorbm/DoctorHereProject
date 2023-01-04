package com.doctorhere.base.country.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CountryResponseDto implements Serializable{
    private String name;
    private String sortName;
    private String phoneCode;
    private String code;
}