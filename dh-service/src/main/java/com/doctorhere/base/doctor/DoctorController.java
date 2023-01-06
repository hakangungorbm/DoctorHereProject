package com.doctorhere.base.doctor;

import com.doctorhere.base.doctor.model.dto.DoctorRequest;
import com.doctorhere.base.doctor.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/doctor")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @PostMapping("signup")
    public ResponseEntity createDoctor(@RequestBody DoctorRequest doctorRequest) {
        doctorService.create(doctorRequest);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
