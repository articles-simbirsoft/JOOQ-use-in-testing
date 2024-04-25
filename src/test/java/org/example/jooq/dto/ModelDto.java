package org.example.jooq.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModelDto {
    private Integer id;
    private String name;
    private CompanyDto companyDto;
}
