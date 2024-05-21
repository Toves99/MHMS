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
@Table(name="report")
public class ReportAnalysis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "report_type")
    private String report_type;
    @Column(name = "description")
    private String description;
    @Column(name = "generated_by")
    private String generated_by;
    @Column(name = "generated_date")
    private String   generated_date;
    @Column(name = "data_point")
    private String data_point;
    @Column(name = "analytic_results")
    private String analytic_results;
    @Column(name = "visualization")
    private String visualization;
    @Column(name = "created_at")
    private ZonedDateTime created_at;
    @Column(name = "updated_at")
    private ZonedDateTime updated_at;
    @Column(name = "deleted_at")
    private ZonedDateTime deleted_at;
}
