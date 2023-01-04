package com.doctorhere.base.province.controller;

import com.doctorhere.base.province.model.dto.ProvinceResponseDto;
import com.doctorhere.base.province.model.mapper.ProvinceMapper;
import com.doctorhere.base.province.service.ProvinceService;
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
public class ProvinceController {

    public static final Logger logger = LoggerFactory.getLogger(ProvinceController.class);

    private final ProvinceService provinceService;

    private final ProvinceMapper provinceMapper;

    @Qualifier("hazelcastInstance")
    private final HazelcastInstance instance;

    @ApiOperation(value = "Ülke Kodu ile Şehir Listesi", response = ProvinceResponseDto[].class)
    @RequestMapping(value = "/province/{countryCode}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProvinceResponseDto>> listAllProvinces(@PathVariable("countryCode") String countryCode) {
        try {
            Map<String, Object> provinceByCountryCache = instance.getMap("provinceByCountryCode");
            List<ProvinceResponseDto> provinceDTOs;

            if (!provinceByCountryCache.containsKey(countryCode)) {
                provinceDTOs = provinceMapper.toDto( provinceService.findByCountryCode(countryCode));
                if (provinceDTOs.isEmpty()) {
                    return new ResponseEntity(HttpStatus.NO_CONTENT);
                }
                provinceByCountryCache.put(countryCode, provinceDTOs);
            } else {
                provinceDTOs = (List<ProvinceResponseDto>)provinceByCountryCache.get(countryCode);
            }
            return new ResponseEntity(provinceDTOs, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("ListALlController exception");
            return null;
        }
    }

}
