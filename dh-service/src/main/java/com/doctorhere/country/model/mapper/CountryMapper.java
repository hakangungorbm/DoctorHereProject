package com.doctorhere.country.model.mapper;


import com.doctorhere.country.model.Country;
import com.doctorhere.country.model.dto.CountryResponseDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CountryMapper {
    CountryResponseDto toDto(Country country);
    List<CountryResponseDto> toDto(List<Country> country);

}
