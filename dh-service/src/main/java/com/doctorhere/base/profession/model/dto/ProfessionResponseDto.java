package com.doctorhere.base.profession.model.dto;


import lombok.*;

import java.io.Serializable;

@Getter
@Setter
public class ProfessionResponseDto implements Serializable {
	private Long id;
    private int version;
	private Integer sortOrder;
    private String name;
    private String description;
    private String subDescription;
    private String  imageUrl;
    private String  tag;
    private Integer  time;
    private Long parentId;
    private String parentName;

}
	 
