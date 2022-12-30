package com.doctorhere.base.province.controller;

import com.doctorhere.base.province.model.Province;
import com.doctorhere.base.province.model.dto.ProvinceResponseDto;
import com.doctorhere.base.province.model.mapper.ProvinceMapper;
import com.doctorhere.base.province.service.ProvinceService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hazelcast.core.HazelcastInstance;
import lombok.AllArgsConstructor;
import net.bytebuddy.description.method.MethodDescription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/ui")
@AllArgsConstructor
public class ProvinceController {

    public static final Logger logger = LoggerFactory.getLogger(ProvinceController.class);

    @Autowired
    private final ProvinceService provinceService;
    @Autowired
    private final ProvinceMapper provinceMapper;

    @Qualifier("hazelcastInstance")
    @Autowired
    private HazelcastInstance instance;     // autowire hazel cast instance

    // ------------------- Retrieve All Countries ---------------------------------------------

    @SuppressWarnings({"unchecked", "rawtypes"})
    @RequestMapping(value = "/province/{countryCode}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProvinceResponseDto>> listAllProvinces(@PathVariable("countryCode") String countryCode) {
        try {

            Map<String, String> provinceByCountryCache = instance.getMap("provinceByCountryCode");
            List<ProvinceResponseDto> provinceDTOs = null;

            if (!provinceByCountryCache.containsKey(countryCode)) {
                provinceDTOs = provinceMapper.toDto( provinceService.findByCountryCode(countryCode));
                if (provinceDTOs.isEmpty()) {
                    return new ResponseEntity(HttpStatus.NO_CONTENT);
                }

                String json = new Gson().toJson(provinceDTOs, ArrayList.class);
                provinceByCountryCache.put(countryCode, json);
            } else {
                String json = provinceByCountryCache.get(countryCode);
                provinceDTOs = new Gson().fromJson(json, ArrayList.class);
            }
            return new ResponseEntity<List<ProvinceResponseDto>>(provinceDTOs, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("ListALlController exception");
            return null;
        }
    }

}
