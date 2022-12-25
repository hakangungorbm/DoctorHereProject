package com.doctorhere.country.repository;

import com.doctorhere.country.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Long> {
    public Optional<Country> findByName(String name);

    Optional<Country> findById(Long id);

    public List<Country> findAllByOrderByName();
}
