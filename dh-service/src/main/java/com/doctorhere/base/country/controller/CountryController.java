package com.doctorhere.base.country.controller;

import com.doctorhere.base.country.model.dto.CountryResponseDto;
import com.doctorhere.base.country.model.mapper.CountryMapper;
import com.doctorhere.base.country.service.CountryService;
import com.doctorhere.base.profession.model.dto.ProfessionResponseDto;
import com.hazelcast.core.HazelcastInstance;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/ui")
@AllArgsConstructor
public class CountryController {

    public static final Logger logger = LoggerFactory.getLogger(CountryController.class);

    private final CountryService countryService;
    private final CountryMapper countryMapper;

    @Qualifier("hazelcastInstance")
    private final HazelcastInstance instance;

    @ApiOperation(value = "Ülke Listesi", response = CountryResponseDto[].class, responseContainer = "List")
    @RequestMapping(value = "/country", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CountryResponseDto>> listAllCountries() {
        try {
            Map<String, Object> countryCache = instance.getMap("countryCache");
            List<CountryResponseDto> countries;
            if (countryCache.isEmpty()) {
                countries = countryMapper.toDto(countryService.findAllByOrderByName());
                if (countries.isEmpty()) {
                    return new ResponseEntity(HttpStatus.NO_CONTENT);
                }
                countryCache.put("country", countries);
            } else {
                countries = (List<CountryResponseDto>)countryCache.get("country");
            }

            return new ResponseEntity(countries, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("ListALlController exception");
            return null;
        }
    }

}
