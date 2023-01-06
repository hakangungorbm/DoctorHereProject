package com.doctorhere.base.district.repository;

import com.doctorhere.base.country.model.Country;
import com.doctorhere.base.district.model.District;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DistrictRepository extends JpaRepository<District, Long> {
    Optional<District> findById(Long id);
    List<District> findByProvinceId(Long provinceId);
}
