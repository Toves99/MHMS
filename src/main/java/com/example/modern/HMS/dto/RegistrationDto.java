package com.example.modern.HMS.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationDto {
    private String email;
    private String username;
    private String password;
    private ZonedDateTime created_at;
    private ZonedDateTime updated_at;
    private ZonedDateTime deleted_at;
}
