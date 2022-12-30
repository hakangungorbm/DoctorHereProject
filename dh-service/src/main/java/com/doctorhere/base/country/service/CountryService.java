package com.doctorhere.base.country.service;


import com.doctorhere.base.country.repository.CountryRepository;
import com.doctorhere.base.country.model.Country;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CountryService {
    private final CountryRepository countryRepository;

    public Optional<Country> findById(Long id) { return countryRepository.findById(id);}
    public Optional<Country> findByName(String name) { return countryRepository.findByName(name);}
    public List<Country> findAllByOrderByName() {
        return countryRepository.findAllByOrderByName();
    }

}
