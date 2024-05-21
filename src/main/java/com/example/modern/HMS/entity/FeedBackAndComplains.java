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
@Table(name="feedback")
public class FeedBackAndComplains {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "patient_id")
    private Integer patient_id;
    @Column(name = "staff_id")
    private Integer staff_id;
    @Column(name = "feedback_type")
    private String feedback_type;
    @Column(name = "descriptions")
    private String descriptions;
    @Column(name = "feedback_date")
    private ZonedDateTime feedback_date;
    @Column(name = "resolution_status")
    private String resolution_status;
    @Column(name = "resolution_details")
    private String  resolution_details;
    @Column(name = "created_at")
    private ZonedDateTime created_at;
    @Column(name = "updated_at")
    private ZonedDateTime updated_at;
    @Column(name = "deleted_at")
    private ZonedDateTime deleted_at;
}
