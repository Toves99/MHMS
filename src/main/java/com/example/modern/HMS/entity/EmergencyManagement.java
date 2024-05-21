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
@Table(name="emergency")
public class EmergencyManagement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "patient_id")
    private Integer patient_id;
    @Column(name = "emergency_type")
    private String emergency_type;
    @Column(name = "response_team")
    private String response_team;
    @Column(name = "response_time")
    private String response_time;
    @Column(name = "action_taken")
    private String action_taken;
    @Column(name = "outcome")
    private String outcome;
    @Column(name = "follow_up")
    private String  follow_up;
    @Column(name = "created_at")
    private ZonedDateTime created_at;
    @Column(name = "updated_at")
    private ZonedDateTime updated_at;
    @Column(name = "deleted_at")
    private ZonedDateTime deleted_at;
}
