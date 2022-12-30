package com.doctorhere.base.province.service;


import com.doctorhere.base.country.model.Country;
import com.doctorhere.base.province.model.Province;
import com.doctorhere.base.province.repository.ProvinceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProvinceService {
    private final ProvinceRepository provinceRepository;

    public Optional<Province> findById(long id) {
        return provinceRepository.findById(id);
    }

    public List<Province> findByCountry(Country country) {
        return provinceRepository.findByCountry(country);
    }
    public List<Province> findByCountryCode(String countryCode) {
        return provinceRepository.findByCountryCode(countryCode);
    }
}
