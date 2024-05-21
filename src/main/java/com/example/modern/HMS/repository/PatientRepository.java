package com.example.modern.HMS.repository;

import com.example.modern.HMS.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Integer> {
//    @Query("SELECT p FROM Patient p WHERE p.doctor.id = :doctorId")
//    List<Patient> findPatientsByDoctorId(@Param("doctorId") Long doctorId);
}
