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
@Table(name="facility")
public class FacilityManagement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "location")
    private String location;
    @Column(name = "maintenance_schedule")
    private String   maintenance_schedule;
    @Column(name = "maintenance_record")
    private String maintenance_record;
    @Column(name = "assigned_personnel")
    private String assigned_personnel;
    @Column(name = "created_at")
    private ZonedDateTime created_at;
    @Column(name = "updated_at")
    private ZonedDateTime updated_at;
    @Column(name = "deleted_at")
    private ZonedDateTime deleted_at;
}
