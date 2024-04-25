package org.example.jooq.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AirplaneDto {
    private Integer id;
    private String number;
    private ModelDto model;
    private LocalDate release;
}
