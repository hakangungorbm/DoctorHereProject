package com.doctorhere.base.profession.model.mapper;


import com.doctorhere.base.profession.model.Profession;
import com.doctorhere.base.profession.model.dto.ProfessionRequestDto;
import com.doctorhere.base.profession.model.dto.ProfessionResponseDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProfessionMapper {

    @Mapping(target = "parentId", source = "parent.id")
    @Mapping(target = "parentName", source = "parent.name")
    ProfessionResponseDto toDto(Profession profession);
    List<ProfessionResponseDto> toDto(List<Profession> professions);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "parent.id", source = "parentId")
    Profession toEntity(ProfessionRequestDto professionRequestDTO);

    @Mapping(target = "parent.id", source = "parentId")
    void updateEntity(@MappingTarget Profession profession, ProfessionRequestDto request);

    @BeforeMapping
    default void doBeforeMapping(@MappingTarget Profession entity, ProfessionRequestDto dto) {
        entity.setParent(null);
    }

    @AfterMapping
    default void doAfterMapping(@MappingTarget Profession entity, ProfessionRequestDto dto) {
        if (dto.getParentId() == null) {
            entity.setParent(null);
        }
    }
}
