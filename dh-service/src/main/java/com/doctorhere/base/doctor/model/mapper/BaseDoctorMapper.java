package com.doctorhere.base.doctor.model.mapper;

import com.doctorhere.base.profession.model.Profession;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper
public interface BaseDoctorMapper {
    @Named("extractDoctorProfessionsIdList")
    default List<Long> extractDoctorProfessionsIdList(Set<Profession> professionSet) {
        return professionSet != null ? professionSet.stream()
                .map(Profession::getId)
                .collect(Collectors.toList()) : Collections.emptyList();
    }

    @Named("convertToDoctorProfessions")
    default Set<Profession> convertToDoctorProfessions(List<Long> professionIdList) {
        return professionIdList != null ? professionIdList.stream()
                .map(professionId -> {
                    Profession profession = new Profession();
                    profession.setId(professionId);

                    return profession;
                })
                .collect(Collectors.toSet()) : Collections.emptySet();
    }

}
