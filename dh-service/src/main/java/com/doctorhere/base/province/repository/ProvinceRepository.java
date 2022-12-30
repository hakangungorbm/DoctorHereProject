package com.doctorhere.base.province.repository;

import com.doctorhere.base.country.model.Country;
import com.doctorhere.base.province.model.Province;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProvinceRepository extends JpaRepository<Province, Long> {
    List<Province> findByCountry(Country country);

    Optional<Province> findById(Long id);
    List<Province> findByCountryCode(String countryCode);
}
