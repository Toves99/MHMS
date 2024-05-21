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
@Table(name="PatientDischarge")
public class PatientDischarge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "patient_id")
    private Integer patient_id;
    @Column(name = "discharge_date")
    private String discharge_date;
    @Column(name = "discharge_summary")
    private String discharge_summary;
    @Column(name = "follow_up_instruction")
    private String   follow_up_instruction;
    @Column(name = "billing_details")
    private String billing_details;
    @Column(name = "created_at")
    private ZonedDateTime created_at;
    @Column(name = "updated_at")
    private ZonedDateTime updated_at;
    @Column(name = "deleted_at")
    private ZonedDateTime deleted_at;
}
