package com.example.modern.HMS.service;

import com.example.modern.HMS.dto.DoctorDto;
import com.example.modern.HMS.entity.Doctor;
import com.example.modern.HMS.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;


    public DoctorDto createDoctor(DoctorDto doctorDto){
        var doctor= Doctor.builder()
                .name(doctorDto.getName())
                .speciality(doctorDto.getSpeciality())
                .contact_information(doctorDto.getContact_information())
                .availability(doctorDto.getAvailability())
                .department(doctorDto.getDepartment())
                .assigned_patient(doctorDto.getAssigned_patient())
                .remarks(doctorDto.getRemarks())
                .created_at(ZonedDateTime.now())
                .deleted_at(false)
                .build();
        doctorRepository.save(doctor);
        return DoctorDto.builder()
                .id(doctor.getId())
                .name(doctor.getName())
                .speciality(doctor.getSpeciality())
                .contact_information(doctor.getContact_information())
                .availability(doctor.getAvailability())
                .department(doctor.getDepartment())
                .assigned_patient(doctor.getAssigned_patient())
                .remarks(doctor.getRemarks())
                .build();
    }
    public Optional<Doctor> getDoctorById(Integer id) {
        return doctorRepository.findById(id);
    }
    public DoctorDto deleteDoctorById(Integer id) {
        Doctor doctor = new Doctor();
        doctorRepository.deleteById(id);
        return DoctorDto.builder()
                .id(doctor.getId())
                .name(doctor.getName())
                .speciality(doctor.getSpeciality())
                .contact_information(doctor.getContact_information())
                .availability(doctor.getAvailability())
                .department(doctor.getDepartment())
                .assigned_patient(doctor.getAssigned_patient())
                .remarks(doctor.getRemarks())
                .build();
    }
    public DoctorDto updateDoctor(DoctorDto doctorDto,Integer id){
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        if(doctorDto.getName()!=null){
            doctor.setName(doctorDto.getName());
        }
        if(doctorDto.getSpeciality()!=null){
            doctor.setSpeciality(doctorDto.getSpeciality());
        }
        if(doctorDto.getContact_information()!=null){
            doctor.setContact_information(doctorDto.getContact_information());
        }
        if(doctorDto.getAvailability()!=null){
            doctor.setAvailability(doctorDto.getAvailability());
        }
        if(doctorDto.getDepartment()!=null){
            doctor.setDepartment(doctorDto.getDepartment());
        }
        if(doctorDto.getAssigned_patient()!=null){
            doctor.setAssigned_patient(doctorDto.getAssigned_patient());
        }
        if(doctorDto.getRemarks()!=null){
            doctor.setRemarks(doctorDto.getRemarks());
        }
        if(doctorDto.getUpdated_at()!=null){
            doctor.setUpdated_at(ZonedDateTime.now());
        }
        doctorRepository.save(doctor);
        return DoctorDto.builder()
                .id(doctor.getId())
                .name(doctor.getName())
                .speciality(doctor.getSpeciality())
                .contact_information(doctor.getContact_information())
                .availability(doctor.getAvailability())
                .department(doctor.getDepartment())
                .assigned_patient(doctor.getAssigned_patient())
                .remarks(doctor.getRemarks())
                .build();
    }
}
