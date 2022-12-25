package com.doctorhere.country.service;


import com.doctorhere.country.model.Country;
import com.doctorhere.country.model.dto.CountryResponseDto;
import com.doctorhere.country.repository.CountryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
