package com.example.modern.HMS.entity;

import com.example.modern.HMS.enums.Status;
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
@Table(name="appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Integer id;
    @Column(name = "patient_id")
    private Integer patient_id;
    @Column(name = "doctor_id")
    private Integer doctor_id;
    @Column(name = "appointment_date")
    private String appointment_date;
    @Column(name = "appointment_time")
    private String appointment_time;
    @Column(name = "reason")
    private String reason;
    @Column(name = "status")
    private Status status;
    @Column(name = "notes")
    private String notes;
    @Column(name = "created_at")
    private ZonedDateTime created_at;
    @Column(name = "updated_at")
    private ZonedDateTime updated_at;
    @Column(name = "deleted_at")
    private ZonedDateTime deleted_at;

}
