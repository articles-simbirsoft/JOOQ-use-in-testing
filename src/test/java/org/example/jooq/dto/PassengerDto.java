package org.example.jooq.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassengerDto {
    private Long id;
    private String fullName;
    private String passportDetails;
    private LocalDate birthdate;
}
