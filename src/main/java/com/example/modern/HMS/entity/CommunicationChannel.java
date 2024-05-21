package com.example.modern.HMS.entity;

import com.example.modern.HMS.enums.CommunicationType;
import com.example.modern.HMS.enums.MessageStatus;
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
@Table(name="messages")
public class CommunicationChannel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Integer id;
    @Column(name = "sender_id")
    private Integer sender_id;
    @Column(name = "receiver_id")
    private Integer receiver_id;
    @Column(name = "message_content")
    private String message_content;
    @Column(name = "timestamp")
    private ZonedDateTime timestamp;
    @Column(name = "communication_type")
    private CommunicationType communicationType;
    @Column(name = "status")
    private MessageStatus messageStatus;
    @Column(name = "created_at")
    private ZonedDateTime created_at;
    @Column(name = "updated_at")
    private ZonedDateTime updated_at;
    @Column(name = "deleted_at")
    private ZonedDateTime deleted_at;

}
