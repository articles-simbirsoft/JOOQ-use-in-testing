package org.example.jooq.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightDto {
    private Long id;
    private PassengerDto passenger;
    private AirplaneDto airplane;
    private LocalDateTime dateTime;
}
