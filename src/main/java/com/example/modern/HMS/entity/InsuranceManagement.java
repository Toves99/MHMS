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
@Table(name="insurance")
public class InsuranceManagement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "provider_name")
    private String provider_name;
    @Column(name = "contact_information")
    private String contact_information;
    @Column(name = "policy_number")
    private String policy_number;
    @Column(name = "coverage_details")
    private String coverage_details;
    @Column(name = "patient_id")
    private Integer patient_id;
    @Column(name = "claim_id")
    private Integer claim_id;
    @Column(name = "claim_status")
    private String  claim_status;
    @Column(name = "claim_amount")
    private String  claim_amount;
    @Column(name = "approval_date")
    private String  approval_date;
    @Column(name = "created_at")
    private ZonedDateTime created_at;
    @Column(name = "updated_at")
    private ZonedDateTime updated_at;
    @Column(name = "deleted_at")
    private ZonedDateTime deleted_at;
}
