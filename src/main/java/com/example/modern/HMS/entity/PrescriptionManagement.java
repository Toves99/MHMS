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
@Table(name="prescription")
public class PrescriptionManagement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "patient_id")
    private Integer patient_id;
    @Column(name = "doctor_id")
    private Integer doctor_id;
    @Column(name = "medication_id")
    private Integer medication_id;
    @Column(name = "dosage_instruction")
    private String   dosage_instruction;
    @Column(name = "issue_date")
    private String issue_date;
    @Column(name = "refill_information")
    private String refill_information;
    @Column(name = "created_at")
    private ZonedDateTime created_at;
    @Column(name = "updated_at")
    private ZonedDateTime updated_at;
    @Column(name = "deleted_at")
    private ZonedDateTime deleted_at;
}
