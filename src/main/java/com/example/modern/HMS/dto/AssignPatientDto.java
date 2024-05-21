package com.example.modern.HMS.dto;
import com.example.modern.HMS.entity.Doctor;
import com.example.modern.HMS.entity.Patient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AssignPatientDto {
    private Patient patient;
    private Doctor doctor;
}
