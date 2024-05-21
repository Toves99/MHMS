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
@Table(name="human_resource")
public class HumanResourceManagement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "employee_name")
    private String employee_name;
    @Column(name = "position")
    private String position;
    @Column(name = "department")
    private String department;
    @Column(name = "contact_information")
    private String contact_information;
    @Column(name = "hire_date")
    private String hire_date;
    @Column(name = "salary")
    private String salary;
    @Column(name = "shift_schedule")
    private String  shift_schedule;
    @Column(name = "performance_record")
    private String  performance_record;
    @Column(name = "leave_record")
    private String  leave_record;
    @Column(name = "created_at")
    private ZonedDateTime created_at;
    @Column(name = "updated_at")
    private ZonedDateTime updated_at;
    @Column(name = "deleted_at")
    private ZonedDateTime deleted_at;
}
