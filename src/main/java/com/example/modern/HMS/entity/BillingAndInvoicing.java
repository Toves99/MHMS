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
@Table(name="billing")
public class BillingAndInvoicing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "invoice_id")
    private Integer invoice_id;
    @Column(name = "patient_id")
    private Integer patient_id;
    @Column(name = "service_rendered")
    private String service_rendered;
    @Column(name = "medical_charges")
    private String medical_charges;
    @Column(name = "lab_test_charges")
    private String lab_test_charges;
    @Column(name = "imaging_charges")
    private String imaging_charges;
    @Column(name = "room_charges")
    private String room_charges;
    @Column(name = "other_charges")
    private String other_charges;
    @Column(name = "payment_method")
    private String payment_method;
    @Column(name = "payment_status")
    private String payment_status;
    @Column(name = "insurance_details")
    private String insurance_details;
    @Column(name = "created_at")
    private ZonedDateTime created_at;
    @Column(name = "updated_at")
    private ZonedDateTime updated_at;
    @Column(name = "deleted_at")
    private ZonedDateTime deleted_at;
}
