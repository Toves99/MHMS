package com.example.modern.HMS.dto;

import com.example.modern.HMS.entity.Doctor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {
    private Integer id;
    private String patient_name;
    private String dob;
    private String gender;
    private String address;
    private String contact_information;
    private String emergency_contact;
    private String insurance_information;
    private String medical_history;
    private ZonedDateTime created_at;
    private ZonedDateTime updated_at;
    private ZonedDateTime deleted_at;
}
