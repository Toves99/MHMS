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
@Table(name="refund")
public class RefundManagement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "payment_id")
    private Integer payment_id;
    @Column(name = "patient_id")
    private Integer patient_id;
    @Column(name = "refund_amount")
    private String refund_amount;
    @Column(name = "refund_date")
    private String refund_date;
    @Column(name = "reason")
    private String reason;
    @Column(name = "refund_status")
    private String refund_status;
    @Column(name = "created_at")
    private ZonedDateTime created_at;
    @Column(name = "updated_at")
    private ZonedDateTime updated_at;
    @Column(name = "deleted_at")
    private ZonedDateTime deleted_at;
}
