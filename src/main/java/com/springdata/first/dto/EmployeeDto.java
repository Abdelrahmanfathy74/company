package com.springdata.first.dto;

import com.springdata.first.model.entity.Department;
import com.springdata.first.model.entity.Employee;
import com.springdata.first.model.entity.Salary;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {
    private Integer id;
    @NotNull(message = "first_name can not be null")
    private String firstname;
    @NotBlank
    private String lastname;

    private DepartmentDto department;
    private SalaryDto salary;


    }



