package com.doctorhere.base.district.service;


import com.doctorhere.base.district.model.District;
import com.doctorhere.base.district.repository.DistrictRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DistrictService {
    private final DistrictRepository districtRepository;

    public Optional<District> findById(long id) {
        return districtRepository.findById(id);
    }
    public List<District> findByProvinceId(Long provinceId) {
        return districtRepository.findByProvinceId(provinceId);
    }
}
