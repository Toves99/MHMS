package com.example.modern.HMS.entity;

import com.example.modern.HMS.enums.PaymentMethod;
import com.example.modern.HMS.enums.PaymentStatus;
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
@Table(name="payment_processing")
public class PaymentProcessing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "invoice_id")
    private Integer invoice_id;
    @Column(name = "patient_id")
    private Integer patient_id;
    @Column(name = "amount_paid")
    private String amount_paid;
    @Column(name = "payment_date")
    private String payment_date;
    @Column(name = "payment_method")
    private PaymentMethod paymentMethod;
    @Column(name = "transaction_id")
    private String transaction_id;
    @Column(name = "payment_status")
    private PaymentStatus paymentStatus;
    @Column(name = "created_at")
    private ZonedDateTime created_at;
    @Column(name = "updated_at")
    private ZonedDateTime updated_at;
    @Column(name = "deleted_at")
    private ZonedDateTime deleted_at;
}
