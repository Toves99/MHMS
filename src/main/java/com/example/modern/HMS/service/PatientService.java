package com.example.modern.HMS.service;

import com.example.modern.HMS.dto.PatientDto;
import com.example.modern.HMS.entity.Patient;
import com.example.modern.HMS.repository.DoctorRepository;
import com.example.modern.HMS.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    public PatientDto createPatient(PatientDto patientDto){
        var patient= Patient.builder()
                .patient_name(patientDto.getPatient_name())
                .dob(patientDto.getDob())
                .gender(patientDto.getGender())
                .address(patientDto.getAddress())
                .contact_information(patientDto.getContact_information())
                .emergency_contact(patientDto.getEmergency_contact())
                .insurance_information(patientDto.getInsurance_information())
                .medical_history(patientDto.getMedical_history())
                .created_at(ZonedDateTime.now())
                .build();
        patientRepository.save(patient);
        return PatientDto.builder()
                .id(patient.getId())
                .patient_name(patient.getPatient_name())
                .dob(patient.getDob())
                .gender(patient.getGender())
                .address(patient.getAddress())
                .contact_information(patient.getContact_information())
                .emergency_contact(patient.getEmergency_contact())
                .insurance_information(patient.getInsurance_information())
                .medical_history(patient.getMedical_history())
                .created_at(patient.getCreated_at())
                .build();
    }

}
