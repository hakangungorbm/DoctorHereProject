package com.doctorhere.base.district.controller;

import com.doctorhere.base.district.model.dto.DistrictResponseDto;
import com.doctorhere.base.district.model.mapper.DistrictMapper;
import com.doctorhere.base.district.service.DistrictService;
import com.hazelcast.core.HazelcastInstance;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/ui")
@AllArgsConstructor
public class DistrictController {

    public static final Logger logger = LoggerFactory.getLogger(DistrictController.class);

    private final DistrictService districtService;

    private final DistrictMapper districtMapper;

    @Qualifier("hazelcastInstance")
    private final HazelcastInstance instance;

    @ApiOperation(value = "İl id ile ilçe listesi", response = DistrictResponseDto[].class)
    @RequestMapping(value = "/district/{provinceId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<DistrictResponseDto>> listAllDistricts(@PathVariable("provinceId") Long provinceId) {
        try {
            Map<Long, Object> districtByProvinceCache = instance.getMap("districtByProvince");
            List<DistrictResponseDto> districtDtos;

            if (!districtByProvinceCache.containsKey(provinceId)) {
                districtDtos = districtMapper.toDto( districtService.findByProvinceId(provinceId));
                if (districtDtos.isEmpty()) {
                    return new ResponseEntity(HttpStatus.NO_CONTENT);
                }
                districtByProvinceCache.put(provinceId, districtDtos);
            } else {
                districtDtos = (List<DistrictResponseDto>)districtByProvinceCache.get(provinceId);
            }
            return new ResponseEntity(districtDtos, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("ListALlController exception");
            return null;
        }
    }

}
