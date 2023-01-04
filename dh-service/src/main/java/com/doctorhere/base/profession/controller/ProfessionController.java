package com.doctorhere.base.profession.controller;

import com.doctorhere.base.profession.model.Profession;
import com.doctorhere.base.profession.model.dto.ProfessionRequestDto;
import com.doctorhere.base.profession.model.dto.ProfessionResponseDto;
import com.doctorhere.base.profession.model.mapper.ProfessionMapper;
import com.doctorhere.base.profession.service.ProfessionService;
import com.doctorhere.common.exception.ResourceNotFoundException;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/admin/profession")
@Api("Uzmanlık Alanı işlemleri servisi")
@RequiredArgsConstructor
public class ProfessionController {

    public static final Logger logger = LoggerFactory.getLogger(ProfessionController.class);

    private final ProfessionService professionService;
    private final ProfessionMapper professionMapper;

    @ApiOperation(value = "Uzmanlık Servisi", response = Profession.class, responseContainer = "List")
    @RequestMapping(value = "/list/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity listAllProfessions(
            @RequestParam(name = "status", required = false) Boolean status,
            @RequestParam(name = "pageNumber", required = false, defaultValue = "1") Integer pageNumber,
            @RequestParam(name = "pageSize", required = false, defaultValue = "20") Integer pageSize,
            @RequestParam(name = "sortingDirection", required = false, defaultValue = "ASC") String sortingDirection,
            @RequestParam(name = "sortingName", required = false, defaultValue = "id") String sortingName,
            @RequestParam(name = "pageable", required = false, defaultValue = "true") Boolean pageable,
            @RequestParam(name = "parents", required = false, defaultValue = "true") Boolean parents,
            @RequestParam(name = "parentId", required = false) Long parentId,
            @RequestParam(name = "name", required = false, defaultValue = "") String name
    ) {
        if (pageable) {
            Page<ProfessionResponseDto> professions = professionService.findAllPageable(pageNumber, pageSize, sortingDirection, sortingName, name, status, parentId, parents).map(professionMapper::toDto);
            return new ResponseEntity(professions, HttpStatus.OK);
        } else {
            List<ProfessionResponseDto> professions = professionMapper.toDto(professionService.findAllList(sortingDirection, sortingName, status, name, parentId, parents));
            return new ResponseEntity(professions, HttpStatus.OK);
        }
    }

    @ApiOperation(value = "Id ye göre Uzmanlık Alanı bilgileri", response = Profession.class)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProfessionResponseDto> getProfession(
            @ApiParam(value = "Getirilecek nesnesinin Id si", required = true) @PathVariable("id") long id) {
        Profession profession = professionService.findByIdAndDeletedFalse(id).orElseThrow(() -> new ResourceNotFoundException("Not found Profession with id = " + id));
        return new ResponseEntity(professionMapper.toDto(profession), HttpStatus.OK);
    }

    @ApiOperation(value = "Id ye göre Uzmanlık Alanı silme")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProfessionResponseDto> deleteProfession(
            @ApiParam(value = "Silinecek nesnenin Id si", required = true) @PathVariable("id") long id) {
        Profession profession = professionService.findByIdAndDeletedFalse(id).orElseThrow(() -> new ResourceNotFoundException("Not found Profession with id = " + id));
        professionService.delete(profession);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Uzmanlık Alanı kaydetme", response = ProfessionResponseDto.class)
    public ResponseEntity<ProfessionResponseDto> createProfession(
            @ApiParam(value = "Eklenecek nesne", required = true) @RequestBody ProfessionRequestDto professionRequestDTO) {
        return new ResponseEntity(professionMapper.toDto(professionService.save(professionMapper.toEntity(professionRequestDTO))), HttpStatus.CREATED);
    }

    @ApiOperation(value = "Id ye göre Uzmanlık Alanı güncelleme", response = ProfessionResponseDto.class)
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateProfession(
            @ApiParam(value = "Güncellenecek nesne", required = true) @RequestBody ProfessionRequestDto professionRequestDTO) {
        Profession profession = professionService.findByIdAndDeletedFalse(professionRequestDTO.getId()).orElseThrow(() -> new ResourceNotFoundException("Not found Profession with id = " + professionRequestDTO.getId()));
        professionMapper.updateEntity(profession, professionRequestDTO);
        return new ResponseEntity(professionMapper.toDto(professionService.update(profession)), HttpStatus.CREATED);
    }
}