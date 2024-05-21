package com.example.modern.HMS.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto {
    private Integer id;
    private String name;
    private String speciality;
    private String contact_information;
    private String availability;
    private String department;
    private String assigned_patient;
    private String  remarks;
    private ZonedDateTime created_at;
    private ZonedDateTime updated_at;
    private boolean deleted_at;
}
