package com.example.modern.HMS.entity;

import com.example.modern.HMS.enums.ImageType;
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
public class Radiography {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "patient_id")
    private Integer patient_id;
    @Column(name = "doctor_id")
    private Integer doctor_id;
    @Column(name = "image_type")
    private ImageType imageType;
    @Column(name = "imaging_date")
    private String   imaging_date;
    @Column(name = "imaging_results")
    private String imaging_results;
    @Column(name = "radiologist_id")
    private Integer radiologist_id;
    @Column(name = "note")
    private String note;
    @Column(name = "created_at")
    private ZonedDateTime created_at;
    @Column(name = "updated_at")
    private ZonedDateTime updated_at;
    @Column(name = "deleted_at")
    private ZonedDateTime deleted_at;
}
