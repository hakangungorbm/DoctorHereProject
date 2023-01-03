package com.doctorhere.base.entity.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class AbstractDto implements Serializable {
    @ApiModelProperty(value = "Identifier")
    private Long id;
    @ApiModelProperty(value = "Kayıt Versiyonu")
    private int version;
}
