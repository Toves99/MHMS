package com.example.modern.HMS.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="medicalRecords")
public class MedicalRecords {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "patient_id")
    private Integer patient_id;
    @Column(name = "visit_date")
    private String visit_date;
    @Column(name = "doctor_id")
    private Integer doctor_id;
    @Column(name = "diagnosis")
    private String   diagnosis;
    @Column(name = "treatment_plan")
    private String treatment_plan;
    @Column(name = "medication_prescribed")
    private String medication_prescribed;
    @Column(name = "lab_test_results")
    private String  lab_test_results;
    @Column(name = "imaging_results")
    private String  imaging_results;
    @Column(name = "progress_note")
    private String  progress_note;
    @Column(name = "created_at")
    private ZonedDateTime created_at;
    @Column(name = "updated_at")
    private ZonedDateTime updated_at;
    @Column(name = "deleted_at")
    private ZonedDateTime deleted_at;
}
