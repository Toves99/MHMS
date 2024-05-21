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
@Table(name="inventory")
public class InventoryManagement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "item_name")
    private String item_name;
    @Column(name = "description")
    private String description;
    @Column(name = "quantity")
    private String quantity;
    @Column(name = "reorder_level")
    private String reorder_level;
    @Column(name = "supplier_information")
    private String supplier_information;
    @Column(name = "claim_id")
    private Integer claim_id;
    @Column(name = "claim_status")
    private String  claim_status;
    @Column(name = "last_ordered_date")
    private String  last_ordered_date;
    @Column(name = "expiry_date")
    private String  expiry_date;
    @Column(name = "created_at")
    private ZonedDateTime created_at;
    @Column(name = "updated_at")
    private ZonedDateTime updated_at;
    @Column(name = "deleted_at")
    private ZonedDateTime deleted_at;

}
