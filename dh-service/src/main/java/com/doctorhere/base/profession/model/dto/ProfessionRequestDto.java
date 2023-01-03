package com.doctorhere.base.profession.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class ProfessionRequestDto implements Serializable {

    @NotNull(message = "Ad boş olamaz")
    private String name;
    private Integer sortOrder;
    @ApiModelProperty(value = "Identifier")
    private Long id;
    @ApiModelProperty(value = "Versiyon Bilgisi")
    private int version;
    private String description;
    private String subDescription;
    private String  imageUrl;
    private Long parentId;
    private String tag;
    private Integer  time;

}
