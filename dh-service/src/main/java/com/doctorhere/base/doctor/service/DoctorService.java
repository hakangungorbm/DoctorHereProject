package com.doctorhere.base.doctor.service;

import com.doctorhere.base.doctor.model.Doctor;
import com.doctorhere.base.doctor.model.dto.DoctorRequest;

public interface DoctorService {

    void create(DoctorRequest doctorRequest);

    Doctor update(DoctorRequest doctorRequest);

}
