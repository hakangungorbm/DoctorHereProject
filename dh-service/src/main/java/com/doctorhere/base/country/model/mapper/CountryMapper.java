package com.doctorhere.base.country.model.mapper;


import com.doctorhere.base.country.model.Country;
import com.doctorhere.base.country.model.dto.CountryResponseDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    CountryResponseDto toDto(Country country);
    List<CountryResponseDto> toDto(List<Country> country);

}
