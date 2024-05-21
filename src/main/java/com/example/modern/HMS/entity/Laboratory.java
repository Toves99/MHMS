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
@Table(name="lab")
public class Laboratory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "test_name")
    private String test_name;
    @Column(name = "description")
    private String description;
    @Column(name = "patient_id")
    private Integer patient_id;
    @Column(name = "doctor_id")
    private Integer  doctor_id;
    @Column(name = "sample_collection_date")
    private String sample_collection_date;
    @Column(name = "sample_type")
    private String sample_type;
    @Column(name = "test_results")
    private String  test_results;
    @Column(name = "results_date")
    private String  results_date;
    @Column(name = "technician_id")
    private Integer  technician_id;
    @Column(name = "created_at")
    private ZonedDateTime created_at;
    @Column(name = "updated_at")
    private ZonedDateTime updated_at;
    @Column(name = "deleted_at")
    private ZonedDateTime deleted_at;
}
