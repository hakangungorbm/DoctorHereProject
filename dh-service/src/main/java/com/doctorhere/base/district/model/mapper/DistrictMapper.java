package com.doctorhere.base.district.model.mapper;


import com.doctorhere.base.district.model.District;
import com.doctorhere.base.district.model.dto.DistrictResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DistrictMapper {

    DistrictResponseDto toDto(District district);
    List<DistrictResponseDto> toDto(List<District> districts);

}
