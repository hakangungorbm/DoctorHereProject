package com.doctorhere.base.doctor.repository;

import com.doctorhere.base.doctor.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
}
