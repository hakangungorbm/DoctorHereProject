package com.doctorhere.country.controller;

import com.doctorhere.country.model.dto.CountryResponseDto;
import com.doctorhere.country.model.mapper.CountryMapper;
import com.doctorhere.country.service.CountryService;
import com.hazelcast.core.HazelcastInstance;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/ui")
@AllArgsConstructor
public class CountryController {

    public static final Logger logger = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private final CountryService countryService;
    @Autowired
    private final CountryMapper countryMapper;

    @Qualifier("hazelcastInstance")
    @Autowired
    private HazelcastInstance instance;     // autowire hazel cast instance

    // ------------------- Retrieve All Countries ---------------------------------------------

    @SuppressWarnings({"unchecked", "rawtypes"})
    @RequestMapping(value = "/country", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CountryResponseDto>> listAllCountries() {
        try {
            Map<String, String> addressCache = instance.getMap("addressCache");
            List<CountryResponseDto> countries = null;
            if (addressCache.isEmpty()) {
                countries = countryMapper.toDto(countryService.findAllByOrderByName());
                if (countries.isEmpty()) {
                    return new ResponseEntity(HttpStatus.NO_CONTENT);
                }
                String json = new Gson().toJson(countries, ArrayList.class);
                addressCache.put("countryCache", json);
            } else {
                String json = addressCache.get("countryCache");
                countries = new Gson().fromJson(json, ArrayList.class);
            }

            return new ResponseEntity<List<CountryResponseDto>>(countries, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("ListALlController exception");
            return null;
        }
    }

}
