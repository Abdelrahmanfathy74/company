package com.springdata.first.dto;

import com.springdata.first.model.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.NotNull;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalaryDto{
    private Integer salary_id;
    @NotNull
    private Double salary_amt;

}
