package com.doctorhere.base.country.model.dto;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
public class CountryResponseDto{

    private String name;
    private String sortName;
    private String phoneCode;
    private String code;

}