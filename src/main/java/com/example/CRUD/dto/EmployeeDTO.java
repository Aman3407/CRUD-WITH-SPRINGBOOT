package com.example.CRUD.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private long id;
    private String name;
    private LocalDate dateOfJoining;
    private Boolean isActive;
}
