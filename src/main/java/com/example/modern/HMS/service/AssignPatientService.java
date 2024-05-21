package com.example.modern.HMS.service;

import com.example.modern.HMS.dto.AssignPatientDto;
import com.example.modern.HMS.entity.AssignPatient;
import com.example.modern.HMS.entity.Doctor;
import com.example.modern.HMS.entity.Patient;
import com.example.modern.HMS.repository.AssignPatientRepository;
import com.example.modern.HMS.repository.DoctorRepository;
import com.example.modern.HMS.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AssignPatientService {
    private final AssignPatientRepository assignPatientRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    public AssignPatientDto AssignPatientToDoctor(AssignPatientDto assignPatientDto,Integer id){
        Doctor doctor=doctorRepository.getById(id);
        Patient patient=patientRepository.getById(id);
        var assignPatient= AssignPatient.builder()
                .build();
        assignPatient.setPatient(patient);
        assignPatient.setDoctor(doctor);
        assignPatientRepository.save(assignPatient);
        return AssignPatientDto.builder()
                .doctor(doctor.getName())
                .build();
    }
}
